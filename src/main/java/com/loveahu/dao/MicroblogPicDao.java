package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;
import com.loveahu.dao.domain.microblog.MicroblogZanDo;

@Repository("microblogPicDao")
public class MicroblogPicDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogPicDao.class);

	public MicroblogPicDao() {
		super.setRoute(DS_DOBELL);
	}

	public List<String> getMicroblogPicByBid(long bid) throws SQLException{
		return this.executeQueryForList("microblogPic.getMicroblogPicByBid", bid);
	}
}
