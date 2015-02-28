package com.loveahu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.dao.eum.ActionOp;
import com.loveahu.service.IUserService;
import com.loveahu.service.aop.annotation.Action;

@Controller
@RequestMapping("/user")
public class TmpController extends BaseController{
	
	Logger log = Logger.getLogger(TmpController.class);
	
	@Resource
	private IUserService userService;
	
	@ResponseBody
	@Action(op = ActionOp.USER_INFO,needUid=false)
	@RequestMapping("/hi")
	public String getCommonUserByPathUid(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("uid") int uid
			) {
		String out = JsonUtil.Object2Json(userService.getUserByUid(uid));
		return out;
	}
	
	
	
}
