package com.loveahu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.school.SchoolDepartmentDo;

@Repository("schoolDepartmentDao")
public class SchoolDepartmentDao extends AppBaseDao {

	Logger log = Logger.getLogger(SchoolDepartmentDao.class);
	
	public SchoolDepartmentDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public String getDepName(long depid) throws SQLException{
		return (String) this.executeQueryForObject("schoolDepartment.getDepName", depid);
	}
	
	public List<SchoolDepartmentDo> getDepartmentsBySchool(long schoolId) throws SQLException{
		return this.executeQueryForList("schoolDepartment.getDepartmentsBySchool", schoolId);
	}
}
