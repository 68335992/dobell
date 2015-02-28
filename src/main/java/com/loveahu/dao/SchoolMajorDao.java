package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.school.SchoolMajorDo;

@Repository("schoolMajorDao")
public class SchoolMajorDao extends AppBaseDao {

	Logger log = Logger.getLogger(SchoolMajorDao.class);
	
	public SchoolMajorDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public List<SchoolMajorDo> getDepInfo(long schoolId) throws SQLException{
		return this.executeQueryForList("schoolMajor.getDepInfo", schoolId);
	}
	
	public List<SchoolMajorDo> getMajInfo(long depId,byte type) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("depId", depId);
		map.put("type", type);
		return this.executeQueryForList("schoolMajor.getMajInfo", map);
	}
	
	public String getMajName(long majid) throws SQLException{
		return (String) this.executeQueryForObject("schoolMajor.getMajName", majid);
	}
}
