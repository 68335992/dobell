package com.loveahu.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.dao.domain.ResultDo;
import com.loveahu.service.IPhpApiService;
import com.loveahu.util.HttpConnPool;

@Service("phpApiService")
public class PhpApiService implements IPhpApiService {

	HttpConnPool conn = HttpConnPool.getInstance();
	
	@Override
	public ResultDo checkUser(String funId, String funPasswd, long schoolId) {
		ResultDo result = new ResultDo('1', null);
		Map<String, String> args = new HashMap<String, String>();
		args.put("funId", funId);
		args.put("funPasswd", funPasswd);
		args.put("schoolId", Long.toString(schoolId));
		try {
			String resp = conn.post(PHP_SERVER_HOST+API_CHECK_USER, args);
			if (null==resp) {
				return result;
			}
			ResultDo rst = JsonUtil.Json2T(resp, ResultDo.class);
			return rst==null?result:rst;
		} catch (Throwable e) {
			e.printStackTrace();
			return result;
		}
	}

	
	private static final String PHP_SERVER_HOST = "http://10.10.11.183:40280/WebExt/";
	
	private static final String API_CHECK_USER = "UserCheck.php";
}
