package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.CommonSchoolDao;
import com.loveahu.dao.SchoolDepartmentDao;
import com.loveahu.dao.SchoolMajorDao;
import com.loveahu.dao.domain.common.CommonSchoolDo;
import com.loveahu.dao.domain.school.SchoolDepartmentDo;
import com.loveahu.dao.domain.school.SchoolMajorDo;
import com.loveahu.service.ISchoolService;

@Service("schoolService")
public class SchoolService implements ISchoolService {

	Logger log = Logger.getLogger(SchoolService.class);
	
	@Resource
	CommonSchoolDao commonSchoolDao;
	
	@Resource
	SchoolDepartmentDao schoolDepartmentDao;
	
	@Resource
	SchoolMajorDao schoolMajorDao;
	
	@Override
	public CommonSchoolDo getSchoolById(long schoolId) {
		try {
			return commonSchoolDao.getSchoolById(schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getSchoolById fail",e);
			return null;
		}
	}

	@Override
	public String getDepName(long depid) {
		try {
			return schoolDepartmentDao.getDepName(depid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getDepName fail",e);
			return null;
		}
	}

	@Override
	public List<SchoolDepartmentDo> getDepartmentsBySchool(long schoolId) {
		try {
			return schoolDepartmentDao.getDepartmentsBySchool(schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getDepartmentsBySchool fail",e);
			return null;
		}
	}

	@Override
	public List<SchoolMajorDo> getDepInfo(long schoolId) {
		try {
			return schoolMajorDao.getDepInfo(schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getDepInfo fail",e);
			return null;
		}
	}

	@Override
	public List<SchoolMajorDo> getMajInfo(long depId, byte type) {
		try {
			return schoolMajorDao.getMajInfo(depId, type);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMajInfo fail",e);
			return null;
		}
	}

	@Override
	public String getMajName(long majid) {
		try {
			return schoolMajorDao.getMajName(majid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMajName fail",e);
			return null;
		}
	}

}
