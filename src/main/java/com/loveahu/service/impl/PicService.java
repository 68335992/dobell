package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.CommonPicDao;
import com.loveahu.dao.domain.common.CommonPicDo;
import com.loveahu.service.IPicService;

@Service("picService")
public class PicService implements IPicService {

	Logger log = Logger.getLogger(PicService.class);

	@Resource
	CommonPicDao commonPicDao;
	
	@Override
	public List<String> getNameBySchoolType(long schoolId, int type) {
		try {
			return commonPicDao.getNameBySchoolType(schoolId, type);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getNameBySchoolType fail",e);
			return null;
		}
	}

	@Override
	public List<CommonPicDo> getAllScohool() {
		try {
			return commonPicDao.getAllScohool();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getAllScohool fail",e);
			return null;
		}
	}

}
