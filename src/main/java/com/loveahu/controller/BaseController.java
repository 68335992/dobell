package com.loveahu.controller;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.dao.domain.ResultDo;

/**
 * controller 基类
 * @author administrator
 *
 */
public class BaseController {
	
	protected String jsonResult(char code,Object data) {
		return JsonUtil.Object2Json(new ResultDo(code, data));
	}
}
