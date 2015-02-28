package com.loveahu.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.common.CommonSchoolDo;

@Repository("commonSchoolDao")
public class CommonSchoolDao extends AppBaseDao {

	Logger log = Logger.getLogger(CommonSchoolDao.class);
	
	public CommonSchoolDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public CommonSchoolDo getSchoolById(long schoolId) throws SQLException{
		return  (CommonSchoolDo) this.executeQueryForObject("school.getSchool", schoolId);
	}
}
