package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.common.CommonPicDo;

@Repository("commonPicDao")
public class CommonPicDao extends AppBaseDao {

	Logger log = Logger.getLogger(CommonPicDao.class);
	
	public CommonPicDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public List<String> getNameBySchoolType(long schoolId,int type) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("schoolId", schoolId);
		map.put("type", type);
		return this.executeQueryForList("pic.getNameBySchoolType", map);
	}
	
	public List<CommonPicDo> getAllScohool() throws SQLException{
		return this.executeQueryForList("pic.getAllScohool", null);
	}
}
