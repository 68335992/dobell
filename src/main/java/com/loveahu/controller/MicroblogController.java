package com.loveahu.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loveahu.constant.DoBell;
import com.loveahu.controller.code.microblog.MicroblogNewListGetCode;
import com.loveahu.dao.domain.common.CommonUserDo;
import com.loveahu.service.IMicroblogService;
import com.loveahu.service.IUserService;

@Controller
@RequestMapping("/microblog")
public class MicroblogController extends BaseController{
	
	Logger log = Logger.getLogger(MicroblogController.class);
	
	@Resource
	private IMicroblogService microblogService;
	@Resource
	private IUserService userService;
	
	@ResponseBody
	//@Action(op = ActionOp.USER_INFO,needUid=false)
	@RequestMapping("/MicroblogCommentListGet.php")
	public String getMicroblogCommentList(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam long blogId,
			@RequestParam int objCount,
			@RequestParam long lastId,
			@RequestParam long usrId
			) {
		return jsonResult('1',microblogService.getMicroblogCommentList(blogId, lastId, objCount,usrId));
	}
	
	@ResponseBody
	@RequestMapping("/MicroblogNewListGet.php")
	public String MicroblogNewListGet(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(DoBell.PARAMS_UID) long usrId,
			long lastId,
			int objCount,
			long schoolId
			) {
		CommonUserDo user = userService.getUserByUid(usrId);
		if (null==user) {
			return jsonResult(MicroblogNewListGetCode.RETURN_FAIL_NOUSR.code, null);
		}
		List<Map<String, Object>> rst = microblogService.getMicroblogMainNewList(usrId, lastId, objCount, schoolId);
		return jsonResult(MicroblogNewListGetCode.RETURN_SUCCESS.code, rst);
	}
	
}
