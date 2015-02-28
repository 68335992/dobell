package com.loveahu.service;

import java.util.List;

import com.loveahu.dao.domain.common.CommonSchoolDo;
import com.loveahu.dao.domain.school.SchoolDepartmentDo;
import com.loveahu.dao.domain.school.SchoolMajorDo;

public interface ISchoolService {
	
	String getDepName(long depid);
	
	List<SchoolDepartmentDo> getDepartmentsBySchool(long schoolId);

	CommonSchoolDo getSchoolById(long schoolId);
	
	List<SchoolMajorDo> getDepInfo(long schoolId);
	
	List<SchoolMajorDo> getMajInfo(long depId,byte type);
	
	String getMajName(long majid);
}
