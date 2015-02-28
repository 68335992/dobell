package com.loveahu.service;

import java.util.List;
import java.util.Map;

import com.loveahu.dao.domain.microblog.MicroblogCommentDo;
import com.loveahu.dao.domain.microblog.MicroblogMainDo;
import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;

public interface IMicroblogService {

	/**
	 * 组合接口
	 */
	Map<String, Object> getOneMicroBlog_3(long blogId,long myUserId);
	
	Map<String, Object> getOneMblogShare(long id);
	
	Map<String, Object> getOneTopic(long topicId);
	
	List<Map<String, Object>> getMblogList(long usrId,long frdId,long lastId,int objCount,int contentType,String topicStr,long schoolId);

	//MicroblogNewListGet.php
	List<Map<String, Object>> getMicroblogMainNewList(long usrId,long lastId,int objCount,long schoolId);
	
	//基础服务接口
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogMainDao
	//MicroblogDetailGet.php	
	MicroblogMainDo getMicroblogMainByBlogId(long blogId);
	
	//MicroblogDelete.php
	int deleteMicroblogMain(long blogId,int deleteFlag);
	
	//MicroblogListGet.php
	List<MicroblogMainDo> getMicroblogMainList(long usrId,long frdId,long lastId,int objCount,int contentType,String topicStr,long schoolId);

	//MicroblogSend.php
	long addMicroblogMain(long usrId,String contentStr,String mentionUsrIdStr,int imageNum,
			int isTran,long origBlogId,long transBlogId,int shareId,long topicId,long schoolId,int type);
	
	//MicroblogReadUpdate.php
	int updateMicroblogMainRead(long usrId);
	
	//MicroblogNoReadCountGet.php
	int getMicroblogMainNoReadCount(long usrId);
	
	//MicroblogHotListGet.php
	List<MicroblogMainDo> getMicroblogMainHotList(long usrId,long schoolId);
	
	MicroblogMainDo getMicroblogMainById(long bid);
	
	int increaseMblogBrowse(long bid);
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogZanDao
	//MicroblogZanSend.php
	long addMicroblogZan(long usrId,long blogId);
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogCommentDao
	//MicroblogCommentListGet.php
	List<MicroblogCommentDo> getMicroblogCommentList(long blogId,long lastId,int objCount,long usrId);
	
	//MicroblogCommentSend.php	
	long addMicroblogComment(long usrId,long objUsrId,long blogId,long rootCommentId,String commentContent);
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogTopicDao
	//TopicWallTopicListGet.php(已经废弃)
	//List<MicroblogTopicDo> getMicroblogTopicWallList(long lastId,long objCount,long schoolId);
	
	//TopicWallIngTopicListGet.php
	List<MicroblogTopicDo> getMicroblogTopicWallingList(long schoolId);
	
	//TopicSquarRandomeGet.php(已经废弃)
	//List<MicroblogTopicDo> getMicroblogTopicSquarRandom(long schoolId);
	
	//TopicListSearch.php
	List<MicroblogTopicDo> getMicroblogTopicSearchList(long lastId,int objCount,long schoolId,String keyword);
	
	//TopicHotNormalListGet.php
	List<MicroblogTopicDo> getMicroblogTopicHotNormalList(long lastId,int objCount,long schoolId);
	
	//TopicBoardGet.php
	List<MicroblogTopicDo> getMicroblogTopicBoardList(long schoolId);
	
	//MicroblogTopicListGet.php
	List<MicroblogTopicDo> getMicroblogTopicList(long lastId,int objCount,long schoolId);
	
	Long getTopicIdByTopicStr(String topicStr,long schoolId);
	
	long getOneGoodTopicId(long schoolId);
	
	List<Long> getWallIngTopicIdList(long schoolId);
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogShareDao
	//ShareImageUpload.php
	String addMicroblogShareImage();
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//MicroblogImageDao
	//MicroblogImageUpload.php
	String addMicroblogMainImage();

	//MicroblogShareAPI.php未做
	//activeHzPro.php未做
}
