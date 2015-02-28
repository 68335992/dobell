package com.loveahu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tx.galaxy.util.JsonUtil;
import cn.com.tx.galaxy.util.StringUtil;

import com.loveahu.constant.DoBell;
import com.loveahu.controller.code.user.CommonPicGetCode;
import com.loveahu.controller.code.user.UserAlterPasswordCode;
import com.loveahu.controller.code.user.UserCheckCode;
import com.loveahu.dao.domain.ResultDo;
import com.loveahu.dao.domain.common.CommonSchoolDo;
import com.loveahu.dao.domain.common.CommonUserDo;
import com.loveahu.dao.domain.common.SiteDo;
import com.loveahu.dao.domain.php.api.CheckUserResultDo;
import com.loveahu.service.IFriendService;
import com.loveahu.service.IPhpApiService;
import com.loveahu.service.IPicService;
import com.loveahu.service.ISchoolService;
import com.loveahu.service.IUserService;
import com.loveahu.util.BCSUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	@Resource
	private ISchoolService schoolService;
	@Resource
	private IPicService picService;
	@Resource
	private IFriendService friendService;
	@Resource
	private IPhpApiService phpApiService;
	
	@ResponseBody
	@RequestMapping("/CommonPicGet.php")
	public String CommonPicGet(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(DoBell.PARAMS_UID) int type,
			@RequestParam(DoBell.PARAMS_SCHOOL_ID) long schoolId
			) {
		CommonSchoolDo school = schoolService.getSchoolById(schoolId);
		if (null==school) {
			return jsonResult(CommonPicGetCode.RETURN_FAIL_NOSCHOOL.code, null);
		}else{
			List<String> names = picService.getNameBySchoolType(schoolId, type);
			if (null==names) {
				return jsonResult(CommonPicGetCode.RETURN_FAIL_SERVICERROR.code, null);
			}
			List<SiteDo> sites = new ArrayList<SiteDo>();
			for(String name:names){
				String tmp = BCSUtil.generateUrl(name);
				if (null!=tmp) {
					sites.add(new SiteDo(tmp));
				}
			}
			return jsonResult(CommonPicGetCode.RETURN_SUCCESS.code, sites);
		}
	}
	
	@ResponseBody
	@RequestMapping("/UserAlterPassword.php")
	public String UserAlterPassword(HttpServletRequest request,
			HttpServletResponse response,
			String funcId,
			String password,
			@RequestParam(DoBell.PARAMS_SCHOOL_ID) int schoolId
			) {
		/**
		 * TODO:必须先校验用户密码
		 */
		long uid = userService.getUsrIdByFuncId(funcId, schoolId);
		if (uid<0) {
			return jsonResult(UserAlterPasswordCode.RETURN_FAIL_NOUSR.code, null);
		}
		boolean update = userService.alterPasswordByFuncId(funcId, password, schoolId);
		return jsonResult(update?UserAlterPasswordCode.RETURN_SUCCESS.code:UserAlterPasswordCode.RETURN_FAIL_SERVICERROR.code, 
				update?uid:null);
	}
	
	@ResponseBody
	@RequestMapping("/UserCheck.php")
	public String UserCheck(HttpServletRequest request,
			HttpServletResponse response,
			String funId,
			String funPasswd,
			long schoolId
			) {
		if (schoolId!=1&&schoolId!=2) {
			return jsonResult(UserCheckCode.RETURN_FAIL_NOSCHOOL.code, null);
		}
		CommonUserDo user = userService.getUserByFuncid(funId, schoolId);
		if (null!=user) {
			return jsonResult(UserCheckCode.RETURN_FAIL_REGISTERED.code, null);
		}
		ResultDo result = phpApiService.checkUser(funId, funPasswd, schoolId);
		if (null==result) {
			return jsonResult(UserCheckCode.RETURN_FAIL_NOACCESS.code, null);
		}else{
			return jsonResult(result.getCode(), result.getData());
		}
	}
	
}
