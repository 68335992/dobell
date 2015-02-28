package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;

@Repository("microblogShareDao")
public class MicroblogShareDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogShareDao.class);

	public MicroblogShareDao() {
		super.setRoute(DS_DOBELL);
	}

	public MicroblogShareDo getMicroblogShare(long sid) throws SQLException {
		return (MicroblogShareDo) this.executeQueryForObject(
				"microblogShare.getMicroblogShare", sid);
	}

}
