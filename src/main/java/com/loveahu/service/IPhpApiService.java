package com.loveahu.service;

import com.loveahu.dao.domain.ResultDo;

public interface IPhpApiService {

	public ResultDo checkUser(String funId,String funPasswd,long schoolId);
}
