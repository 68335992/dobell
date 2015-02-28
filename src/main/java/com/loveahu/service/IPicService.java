package com.loveahu.service;

import java.util.List;

import com.loveahu.dao.domain.common.CommonPicDo;

public interface IPicService {

	List<String> getNameBySchoolType(long schoolId,int type);
	
	List<CommonPicDo> getAllScohool();
}
