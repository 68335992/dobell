package com.loveahu.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import cn.com.tx.galaxy.util.StringUtil;

import com.loveahu.filter.jetty.http.HttpFields;
import com.loveahu.filter.jetty.http.HttpMethods;
import com.loveahu.filter.jetty.http.MimeTypes;
import com.loveahu.filter.jetty.util.LazyList;
import com.loveahu.filter.jetty.util.MultiMap;
import com.loveahu.filter.jetty.util.UrlEncoded;
import com.loveahu.service.IUserService;
import com.loveahu.util.encrypy.EncryptUtil;
import com.loveahu.util.encrypy.HttpEncrypt;

public class EncryptBodyHttpServletRequestWrapper extends
		HttpServletRequestWrapper {
	
	Logger log = Logger.getLogger(EncryptBodyHttpServletRequestWrapper.class);

	private final byte[] decryptBody;
	private HttpServletRequest request;
	private MultiMap<String> _baseParameters;
    private MultiMap<String> _parameters;
    private boolean _paramsExtracted;
	
	public EncryptBodyHttpServletRequestWrapper(HttpServletRequest request,IUserService userService,HttpEncrypt encrypt) throws IOException {
		super(request);
		int bodyLength = request.getContentLength();
		byte[] body = new byte[bodyLength];
		if (bodyLength > 0) {
			ServletInputStream sis = request.getInputStream();
			if (sis.markSupported()) {
				sis.mark(bodyLength);
				sis.read(body, 0, bodyLength);
				sis.reset();
			}else{
				sis.read(body, 0, bodyLength);
//				sis.close();
			}
		}
		switch (encrypt) {
		case AES:
				try {
					body = EncryptUtil.AES.decrypt2Bytes(Base64.decodeBase64(body), encrypt.defaultKey);
				} catch (InvalidKeyException e) {
					e.printStackTrace();
					log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+new String(encrypt.defaultKey)+"]", e);
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
					log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+new String(encrypt.defaultKey)+"]", e);
				} catch (BadPaddingException e) {
					e.printStackTrace();
					log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+new String(encrypt.defaultKey)+"]", e);
				} catch (Throwable e) {
					e.printStackTrace();
					log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+new String(encrypt.defaultKey)+"]", e);
				}
			break;
		case AAA:
			String key = "";
			try {
				String token = request.getHeader(encrypt.tokenKey);
				if (StringUtil.isNotBlank(token)) {
//					key = userService.getKeyByToken(token);
					key = "TODO MODIFY";
					if (StringUtil.isNotBlank(key)) {
						body = EncryptUtil.AES.decrypt2Bytes(Base64.decodeBase64(body), key.getBytes());
					}else{
						log.warn("e34w cannt find key by token:"+token);
						log.error("e34w cannt find key by token:"+token);
					}
				}
			} catch (InvalidKeyException e) {
				e.printStackTrace();
				log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+key+"]", e);
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
				log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+key+"]", e);
			} catch (BadPaddingException e) {
				e.printStackTrace();
				log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+key+"]", e);
			} catch (Throwable e) {
				e.printStackTrace();
				log.error("e34w cannt decrypt["+encrypt+"] for ["+new String(body)+"] ["+key+"]", e);
			}
		break;
		default:
			log.error("e34w cannt find decrypt with "+encrypt+"["+new String(body)+"]");
			break;
		}
		decryptBody = body;
	}

	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(decryptBody);  
        return new ServletInputStream() {  
            @Override  
            public int read() throws IOException {  
                return bais.read();  
            }  
        }; 
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream(),request.getCharacterEncoding()));
	}

	@Override
	public String getParameter(String name) {
		if (!_paramsExtracted) 
            extractParameters();
        return (String) _parameters.getValue(name, 0);
	}

	@Override
	public Map getParameterMap() {
		 if (!_paramsExtracted) 
	            extractParameters();
		 return Collections.unmodifiableMap(_parameters.toStringArrayMap());
	}

	@Override
	public Enumeration getParameterNames() {
		if (!_paramsExtracted) 
            extractParameters();
        return Collections.enumeration(_parameters.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		if (!_paramsExtracted) 
            extractParameters();
        List<Object> vals = _parameters.getValues(name);
        if (vals==null)
            return null;
        return (String[])vals.toArray(new String[vals.size()]);
	}
	
	 /* ------------------------------------------------------------ */
    /**
     * Extract Paramters from query string and/or form _content.
     */
    public void extractParameters()
    {
        if (_baseParameters == null) 
            _baseParameters = new MultiMap(16);
        
        if (_paramsExtracted) 
        {
            if (_parameters==null)
                _parameters=_baseParameters;
            return;
        }
        
        _paramsExtracted = true;

        //加密请求暂时不支持query parameter
        // Handle query string
//        if (_uri!=null && _uri.hasQuery())
//        {
//            if (_queryEncoding==null)
//                _uri.decodeQueryTo(_baseParameters);
//            else
//            {
//                try
//                {
//                    _uri.decodeQueryTo(_baseParameters,_queryEncoding);
//                }
//                catch (UnsupportedEncodingException e)
//                {
//                    if (Log.isDebugEnabled())
//                        Log.warn(e);
//                    else
//                        Log.warn(e.toString());
//                }
//            }
//        }

        // handle any _content.
        String encoding = getCharacterEncoding();
        String content_type = getContentType();
        if (content_type != null && content_type.length() > 0)
        {
            content_type = HttpFields.valueParameters(content_type, null);
            
            //&& _inputState==__NONE
            //由于是可重复读body 所以无需保证inputstream reader只一次
            if (MimeTypes.FORM_ENCODED.equalsIgnoreCase(content_type)  &&
                    (HttpMethods.POST.equals(getMethod()) || HttpMethods.PUT.equals(getMethod())))
            {
                int content_length = getContentLength();
                if (content_length != 0)
                {
                    try
                    {
                        int maxFormContentSize=-1;
                        //不限制表单长度
//                        if (_context!=null)
//                            maxFormContentSize=_context.getContextHandler().getMaxFormContentSize();
//                        else
//                        {
//                            Integer size = (Integer)_connection.getConnector().getServer().getAttribute("org.eclipse.jetty.server.Request.maxFormContentSize");
//                            if (size!=null)
//                                maxFormContentSize =size.intValue();
//                        }
//                        
//                        if (content_length>maxFormContentSize && maxFormContentSize > 0)
//                        {
//                            throw new IllegalStateException("Form too large"+content_length+">"+maxFormContentSize);
//                        }
                        InputStream in = getInputStream();
                       
                        // Add form params to query params
                        UrlEncoded.decodeTo(in, _baseParameters, encoding,content_length<0?maxFormContentSize:-1);
                    }
                    catch (IOException e)
                    {
                    }
                }
            }
        }
        
        if (_parameters==null)
            _parameters=_baseParameters;
        else if (_parameters!=_baseParameters)
        {
            // Merge parameters (needed if parameters extracted after a forward).
            Iterator iter = _baseParameters.entrySet().iterator();
            while (iter.hasNext())
            {
                Map.Entry entry = (Map.Entry)iter.next();
                String name=(String)entry.getKey();
                Object values=entry.getValue();
                for (int i=0;i<LazyList.size(values);i++)
                    _parameters.add(name, LazyList.get(values, i));
            }
        }   
        System.out.println("Aes request body:"+new String(decryptBody));
    }

	
}
