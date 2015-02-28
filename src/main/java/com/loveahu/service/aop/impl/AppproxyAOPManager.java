package com.loveahu.service.aop.impl;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;

import com.loveahu.service.IUserService;
import com.loveahu.service.aop.IAppproxyAOPManager;
import com.loveahu.service.aop.annotation.Action;
import com.loveahu.service.aop.annotation.CheckUserLogin;

public class AppproxyAOPManager extends IAppproxyAOPManager {

//	Logger log = Logger.getLogger(AppproxyAOPManager.class);
	
	@Resource
	IUserService userService;
	
	@Override
	public Object checkUserLogin(ProceedingJoinPoint jointPoint,CheckUserLogin checkUserLogin,long now) throws Throwable {
		
//		Object[] os = jointPoint.getArgs();
//		for (Object o : os) {
//			if (o instanceof HttpServletRequest) {
//				HttpServletRequest request = (HttpServletRequest)o;
//				String uidStr = (String) request.getParameter(checkUserLogin.uid());
//				String skeyStr = (String) request.getParameter(checkUserLogin.skey());
//				if (StringUtil.isBlank(uidStr)||StringUtil.isBlank(skeyStr)||(!StringUtil.isNumeric(uidStr))) {
//					McResultDo apr = new McResultDo();
//					apr.setError(true);
//					apr.setErrorMessage(checkUserLogin.tip());
//					System.out.println("Aop:check user [fail] ["+uidStr+"/"+skeyStr+"] method "+jointPoint.getSignature().getName()+" cost "+(System.currentTimeMillis()-now));
//					return JsonUtil.Object2Json(apr); 
//				}
//				long uid = Long.parseLong(uidStr);
//				AccountDo account = accountService.getAccountByUid(uid);
//				if (null!=account&&StringUtil.isNotBlank(account.getSkey())&&account.getSkey().equals(skeyStr)) {
//					if (account.getState()==AccountState.FORBID.state) {
//						McResultDo apr = new McResultDo();
//						apr.setError(true);
//						apr.setErrorMessage(checkUserLogin.tip());
//						System.out.println("Aop:check user [faile forbid] <used cache> ["+uidStr+"] method "+jointPoint.getSignature().getName()+" cost "+(System.currentTimeMillis()-now));
//						return JsonUtil.Object2Json(apr); 
//					}else{
//						//如果存在并相等，则直接执行逻辑
//						//TODO:此处有一个小问题，就是当用户修改密码后，如果不使用新密码的话，旧密码不会失效（除非被提出缓存）
//						System.out.println("Aop:check user [ok] <used cache> ["+uidStr+"] method "+jointPoint.getSignature().getName()+" cost "+(System.currentTimeMillis()-now));
//						return null;
//					}
//				}else{
//					McResultDo apr = new McResultDo();
//					apr.setError(true);
//					apr.setErrorMessage(checkUserLogin.tip());
//					System.out.println("Aop:check user [fail] ["+uidStr+"/"+skeyStr+"] Method:"+jointPoint.getSignature().getName()+" Costs:"+(System.currentTimeMillis()-now)+"ms");
//					return JsonUtil.Object2Json(apr); 
//				}
//			}
//		}
//		McResultDo apr = new McResultDo();
//		apr.setError(true);
//		apr.setErrorMessage(checkUserLogin.tip());
//		System.out.println("Aop:check user [fail] Method:"+jointPoint.getSignature().getName()+" Costs:"+(System.currentTimeMillis()-now)+"ms");
//		return JsonUtil.Object2Json(apr);
		return null;
	}

	@Override
	public void action(ProceedingJoinPoint jointPoint,
			Action controllerAction, long now) throws Throwable {
//		Object[] os = jointPoint.getArgs();
//		for (Object o : os) {
//			if (o instanceof HttpServletRequest) {
//				HttpServletRequest request = (HttpServletRequest)o;
//				ActionDo action = new ActionDo();
//				if (controllerAction.needUid()) {
//					String uidStr = (String) request.getParameter(controllerAction.uidKey());
//					if (NumericUtil.isNumeric(uidStr)) {
//						action.setUid(Long.parseLong(uidStr));
//					}
//				}
//				String loc = request.getHeader(controllerAction.loc());
//				if (StringUtil.isBlank(loc)) {
//					action.setLoc(MC.DEFAULT_LOC);
//				}else{
//					action.setLoc(loc);
//				}
//				action.setOp(controllerAction.op().op);
//				action.setT(now);
//				monitorService.addAction(action);
//			}
//		}
	}

}
