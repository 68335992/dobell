package com.loveahu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

import cn.com.tx.galaxy.http.HttpMethodHelper;
import cn.com.tx.galaxy.util.CharsetUtil;

public class HttpConnPool {

	Logger log = Logger.getLogger(HttpConnPool.class);
	
	private volatile static HttpConnPool instance = null;
	//同步通信实例
	private static HttpClient synClient;
	//文件上传实例
	private HttpClient fileClient;
	
	private HttpConnPool(){
		//初始化通信实例
		multiThreadedMethodHttpConnectionManager = new MultiThreadedHttpConnectionManager();
		multiThreadedMethodHttpConnectionManager.getParams().setConnectionTimeout(10 * 1000);
		multiThreadedMethodHttpConnectionManager.getParams().setSoTimeout(60 * 1000);
		multiThreadedMethodHttpConnectionManager.getParams().setDefaultMaxConnectionsPerHost(32);
		multiThreadedMethodHttpConnectionManager.getParams().setMaxTotalConnections(128);
		synClient = new HttpClient(multiThreadedMethodHttpConnectionManager);
		
		multiThreadedFileHttpConnectionManager = new MultiThreadedHttpConnectionManager();
		multiThreadedFileHttpConnectionManager.getParams().setConnectionTimeout(30 * 1000);
		multiThreadedFileHttpConnectionManager.getParams().setSoTimeout(60 * 1000);
		multiThreadedFileHttpConnectionManager.getParams().setDefaultMaxConnectionsPerHost(8);
		multiThreadedFileHttpConnectionManager.getParams().setMaxTotalConnections(16);
		fileClient = new HttpClient(multiThreadedFileHttpConnectionManager);
	}
	
	public static HttpConnPool getInstance(){
		if (null == instance) {
			synchronized (HttpConnPool.class) {
				if (null == instance) {
					instance = new HttpConnPool();
				}
			}
		}
		return instance;
	}
	
	
	private MultiThreadedHttpConnectionManager multiThreadedMethodHttpConnectionManager;
	private MultiThreadedHttpConnectionManager multiThreadedFileHttpConnectionManager;
	
	public String post(String url,Map<String, String> args) throws IOException{
		return post(url, args,CharsetUtil.UTF8.getCharset());
	}
	
	//执行请求
	public String post(String url,Map<String, String> args,String charset) throws IOException{
		PostMethod postMethod = null;
		try{
			postMethod = initPostMethod(url,args,charset);
			int state = synClient.executeMethod(postMethod);//执行请求
			if(!(state==HttpStatus.SC_OK)){//判断http请求是否成功
				log.error("http conn pool post failed.url: "+url+" response state: "+state);
				System.err.println("http conn pool post failed.url: "+url+" response state: "+state);
				return null;
			}
			InputStream resStream = postMethod.getResponseBodyAsStream();//获取测试服务器的响应结果流
			BufferedReader br = new BufferedReader(new InputStreamReader(resStream,charset));//BufferedReader缓存响应结果流
			StringBuilder resBuilder = new StringBuilder();//这里使用StringBuilder StringBuffer是线程安全的
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuilder.append(resTemp);
			}
			String resp = resBuilder.toString();			
			return resp;//获取返回
		} catch (IOException e) {
			throw e;
		}finally{
			if(null!=postMethod){
				postMethod.releaseConnection();
			}
		}
	}
	
	public String postFile(String url,String fileName,byte[] bytes,String charset) throws IOException{
		PostMethod postMethod = null;
		try{
			postMethod = initFileMethod(url,fileName,bytes,charset);
			int	state = fileClient.executeMethod(postMethod);
			//执行请求
			if(!(state==HttpStatus.SC_OK)){
				log.error("http conn pool file failed.url:"+url+" response state:"+state);
				return null;
			}
			InputStream resStream = postMethod.getResponseBodyAsStream();
			//获取测试服务器的响应结果流
			BufferedReader br = new BufferedReader(new InputStreamReader(resStream));//BufferedReader缓存响应结果流
			StringBuilder resBuilder = new StringBuilder();//这里使用StringBuilder StringBuffer是线程安全的
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuilder.append(resTemp);
			}
			return resBuilder.toString();			
		} catch (IOException e) {
			throw e;
		} finally{
			if(null!=postMethod){
				postMethod.releaseConnection();
			}
		}
	}
	
	private PostMethod initPostMethod(String url,Map<String, String> args,String charset){
		//以post方式执行http请求的uri
		PostMethod postMethod = HttpMethodHelper.getPostMethodByCharset(charset,url);
		//http请求的编码格式
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,charset);
		//添加请求的参数
		NameValuePair[] values = null;
		if (null==args||args.size()==0) {
			values = new NameValuePair[0];
		}else{
			values = new NameValuePair[args.size()];
			Iterator<String> key = args.keySet().iterator();
			int index = 0;
			while(key.hasNext()){
				String tmp = key.next();
				values[index++] = new NameValuePair(tmp, args.get(tmp));
			}
		}
		postMethod.setRequestBody(values);
		return postMethod;
	}	
	
	private PostMethod initFileMethod(String url,String fileName,byte[] bytes,String charset){
		PostMethod postMethod = HttpMethodHelper.getPostMethodByCharset(charset,url);
		FilePart fp = new FilePart(fileName, new ByteArrayPartSource(fileName, bytes));
		MultipartRequestEntity mrp = new MultipartRequestEntity(new Part[] { fp }, postMethod.getParams());
		postMethod.setRequestEntity(mrp);
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
		return postMethod;
	}
	
}
