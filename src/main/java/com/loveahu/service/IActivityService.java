package com.loveahu.service;

import java.util.Map;

import com.loveahu.dao.domain.common.CommonActivityDo;

public interface IActivityService {

	CommonActivityDo getActivityById(long actId);
	
	Map<String, Object> getOneMedal(long actId,long blogId);
}
