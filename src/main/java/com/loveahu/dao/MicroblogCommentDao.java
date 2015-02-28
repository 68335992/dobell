package com.loveahu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.loveahu.dao.domain.microblog.MicroblogCommentDo;


@Repository("microblogCommentDao")
public class MicroblogCommentDao extends AppBaseDao {

	Logger log = Logger.getLogger(MicroblogCommentDao.class);

	public MicroblogCommentDao() {
		super.setRoute(DS_DOBELL);
	}

	public List<Long> getMicroblogCommentIdList(long blogId,long lastId,int objCount) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blogId);
		if (lastId > 0) {
			map.put("lastId", lastId);
		}
		map.put("objCount", objCount);
		return (List<Long>) this.executeQueryForList(
				"microblogComment.getMicroblogCommentIdList", map);
	}
	
	public MicroblogCommentDo getMicroblogCommentByCommentId(long commentId) throws SQLException {	
		return (MicroblogCommentDo)this.executeQueryForObject("microblogComment.getMicroblogCommentByCommentId", commentId);
	}
	
	
	
}
