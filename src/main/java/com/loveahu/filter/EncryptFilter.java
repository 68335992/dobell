package com.loveahu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.tx.galaxy.util.StringUtil;

import com.loveahu.service.IMicroblogService;
import com.loveahu.service.IUserService;
import com.loveahu.util.encrypy.HttpEncrypt;

public class EncryptFilter implements Filter {

	Logger log = Logger.getLogger(EncryptFilter.class);

	private static final String ENCRYPT_KEY = "cert";
	
	private static volatile WebApplicationContext beanContext = null;
	private IUserService userService;
	private IMicroblogService microblogService;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化spring环境
		initSprintEnv(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			System.out.println("request in ["+((HttpServletRequest)request).getRequestURI()+"]");
			HttpServletRequest req = (HttpServletRequest) request;
			String encrypt = req.getHeader(ENCRYPT_KEY);
			if (StringUtil.isNotBlank(encrypt)) {
				HttpEncrypt httpEncrypt = HttpEncrypt.getEncrypt(encrypt);
				if (null != httpEncrypt) {
					switch (httpEncrypt) {
					case AES:
						request = new EncryptBodyHttpServletRequestWrapper(req,null,httpEncrypt);
						break;
					case AAA:
						//request = new EncryptBodyHttpServletRequestWrapper(req, microblogService, httpEncrypt);
						request = new EncryptBodyHttpServletRequestWrapper(req, userService, httpEncrypt);
						break;
					default:
						log.warn("catch an unexecute encrypt " + httpEncrypt);
						break;
					}
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	private void initSprintEnv(FilterConfig config){
		//初始化
		ServletContext context = config.getServletContext();
		//判断当前环境是否有spring环境
		//如果有,持久applicationContext引用
		if (null==beanContext) {
			beanContext = (WebApplicationContext) context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		}
		if (null==beanContext) {
			beanContext = WebApplicationContextUtils.getWebApplicationContext(context);
		}
		if (null==beanContext) {
			System.out.println("EncryptFilter can not find Spring context.System exit.");
			log.error("EncryptFilter can not find Spring context.System exit.");
			System.exit(-1);
		}
		userService = (IUserService) beanContext.getBean("userService",IUserService.class);
		microblogService = (IMicroblogService) beanContext.getBean("microblogService",IMicroblogService.class);
	}

	@Override
	public void destroy() {

	}

}
