package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.common.CommonActivityDo;
import com.loveahu.dao.domain.common.CommonPicDo;

@Repository("commonActivityDao")
public class CommonActivityDao extends AppBaseDao {

	Logger log = Logger.getLogger(CommonActivityDao.class);
	
	public CommonActivityDao(){
		super.setRoute(DS_DOBELL);
	}
	
	public CommonActivityDo getActivityById(long actId) throws SQLException{
		return (CommonActivityDo) this.executeQueryForObject("commonActivity.getActivityById", actId);
	}
}
