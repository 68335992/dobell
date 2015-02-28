package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;
import com.loveahu.dao.domain.microblog.MicroblogZanDo;

@Repository("microblogZanDao")
public class MicroblogZanDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogZanDao.class);

	public MicroblogZanDao() {
		super.setRoute(DS_DOBELL);
	}

	public MicroblogZanDo getZanByUidBlogId(long uid,long bid) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("bid", bid);
		return (MicroblogZanDo) this.executeQueryForObject("microblogZan.getZanByUidBlogId", map);
	}
}
