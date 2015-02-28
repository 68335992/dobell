package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.tx.galaxy.util.JsonUtil;

import com.loveahu.dao.MicroblogCommentDao;
import com.loveahu.dao.MicroblogMainDao;
import com.loveahu.dao.MicroblogPicDao;
import com.loveahu.dao.MicroblogShareDao;
import com.loveahu.dao.MicroblogTopicDao;
import com.loveahu.dao.MicroblogZanDao;
import com.loveahu.dao.domain.microblog.MicroblogCommentDo;
import com.loveahu.dao.domain.microblog.MicroblogMainDo;
import com.loveahu.dao.domain.microblog.MicroblogShareDo;
import com.loveahu.dao.domain.microblog.MicroblogTopicDo;
import com.loveahu.dao.eum.ContentType;
import com.loveahu.dao.eum.MicroblogInfoType;
import com.loveahu.service.IActivityService;
import com.loveahu.service.IMicroblogService;
import com.loveahu.service.IUserService;
import com.loveahu.util.BCSUtil;
import com.loveahu.util.MicroBlogUtil;

@Service("microblogService")
public class MicroblogService implements IMicroblogService {

	Logger log = Logger.getLogger(MicroblogService.class);
	
	@Resource
	IActivityService activityService;
	@Resource
	IUserService userService;
	
	@Resource
	MicroblogMainDao microblogMainDao;
	@Resource
	MicroblogCommentDao microblogCommentDao;
	@Resource
	MicroblogShareDao microblogShareDao;
	@Resource
	MicroblogZanDao microblogZanDao;
	@Resource
	MicroblogTopicDao microblogTopicDao;
	@Resource
	MicroblogPicDao microblogPicDao;

	@Override
	public MicroblogMainDo getMicroblogMainByBlogId(long blogId) {
		if (blogId < 1) {
			return null;
		}
		try {
			return microblogMainDao.getMicroblogMainByBlogId(blogId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getCommonMicroblogByBid fail "+blogId,e);
			return null;
		}
	}

	@Override
	public List<MicroblogCommentDo> getMicroblogCommentList(long blogId, long lastId,
			int objCount,long usrId) {
		// TODO Auto-generated method stub
		try {
			List<Long> list = new ArrayList<Long>();
			list = microblogCommentDao.getMicroblogCommentIdList(blogId, lastId, objCount);
			int listSize = list.size();
			List<MicroblogCommentDo> microblogCommentDoList = new ArrayList<MicroblogCommentDo>(); 
			for(int i=0;i < listSize;i++){
				microblogCommentDoList.add(microblogCommentDao.getMicroblogCommentByCommentId(list.get(i)));
			}
			return microblogCommentDoList;
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMicroblogCommentList fail "+blogId+lastId+objCount+usrId,e);
			return null;
		}
	}

	@Override
	public int deleteMicroblogMain(long blogId,int deleteFlag) {
		// TODO Auto-generated method stub
		try {
			return (int) (microblogMainDao.deleteMicroblogMain(blogId,deleteFlag));
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("deleteMicroblogMain fail:"+blogId,e);
			return 0;
		}
	}

	@Override
	public List<MicroblogMainDo> getMicroblogMainList(long usrId, long frdId,
			long lastId, int objCount, int contentType, String topicStr,
			long schoolId) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long addMicroblogMain(long usrId, String contentStr,
			String mentionUsrIdStr, int imageNum, int isTran, long origBlogId,
			long transBlogId, int shareId, long topicId, long schoolId, int type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMicroblogMainRead(long usrId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMicroblogMainNoReadCount(long usrId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> getMicroblogMainNewList(long usrId, long lastId,
			int objCount, long schoolId) {
		if (lastId==0) {
			//基础数据
			List<Map<String, Object>> blogs = getMblogList(usrId, 0, lastId, objCount, 1, "", schoolId);
			if (null==blogs) {
				blogs = new ArrayList<Map<String,Object>>();
			}
			for(Map<String, Object> blog:blogs){
				squreCardTypeHandle(blog,MicroblogInfoType.INFO_TYPE_NOMO.type);
			}
			//优质话题
			long oneTopicId = getOneGoodTopicId(schoolId);
			Map<String, Object> oneTopic = null;
			if (oneTopicId>0) {
				oneTopic = getOneTopic(oneTopicId);
				squreCardTypeHandle(oneTopic, MicroblogInfoType.INFO_TYPE_TPCOM.type);
			}
			//正在进行
			List<Long> wallIngTopicIdList = getWallIngTopicIdList(schoolId);
			List<Map<String, Object>> wallIngTopicList = new ArrayList<Map<String,Object>>();
			if (null!=wallIngTopicIdList&&wallIngTopicIdList.size()>0) {
				for(Long id:wallIngTopicIdList){
					Map<String, Object> tmp = getOneTopic(id);
					if (null!=tmp) {
						squreCardTypeHandle(tmp, MicroblogInfoType.INFO_TYPE_TPING.type);
						wallIngTopicList.add(tmp);
					}
				}
			}
			
			List<Map<String, Object>> rst = new ArrayList<Map<String,Object>>();
			//如果有正在进行的微博墙，那么置顶的是type=3的微博墙话题
			if (null!=wallIngTopicList&&wallIngTopicList.size()>0) {
				rst.addAll(wallIngTopicList);
			}
			//接下来是按照lasttime排序的微博列表，在第三个微博的位置会插入一条随机获取的优质(_good=1)话题
			if (oneTopic!=null) {
				if (blogs.size()>3) {
					blogs.add(3,oneTopic);
				}else{
					blogs.add(oneTopic);
				}
			}
			rst.addAll(blogs);
			return rst;
		}else{
			//基础数据
			List<Map<String, Object>> blogs = getMblogList(usrId, 0, lastId, objCount, 1, "", schoolId);
			if (null==blogs) {
				blogs = new ArrayList<Map<String,Object>>();
			}
			for(Map<String, Object> blog:blogs){
				squreCardTypeHandle(blog,MicroblogInfoType.INFO_TYPE_NOMO.type);
			}
			return blogs;
		}
	}
	
	private void squreCardTypeHandle(Map<String, Object> info,int type){
		if (null!=info) {
			info.put("dataType", type);
		}
	}

	@Override
	public List<MicroblogMainDo> getMicroblogMainHotList(long usrId,
			long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long addMicroblogZan(long usrId, long blogId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long addMicroblogComment(long usrId, long objUsrId, long blogId,
			long rootCommentId, String commentContent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MicroblogTopicDo> getMicroblogTopicWallingList(long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroblogTopicDo> getMicroblogTopicSearchList(long lastId,
			int objCount, long schoolId, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroblogTopicDo> getMicroblogTopicHotNormalList(long lastId,
			int objCount, long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroblogTopicDo> getMicroblogTopicBoardList(long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MicroblogTopicDo> getMicroblogTopicList(long lastId,
			int objCount, long schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMicroblogShareImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMicroblogMainImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MicroblogMainDo getMicroblogMainById(long bid) {
		try {
			return microblogMainDao.getMicroblogMainById(bid);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMicroblogMainById fail",e);
			return null;
		}
	}

	@Override
	public Map<String, Object> getOneMicroBlog_3(long blogId, long myUserId) {
		MicroblogMainDo blog = getMicroblogMainById(blogId);
		if (null==blog) {
			return null;
		}
		Map<String, Object> share = getOneMblogShare(blog.get_shareid());
		Map<String, Object> author = userService.getOnePerson(myUserId, blog.get_uid());
		int isZaned = 0;
		try {
			isZaned = microblogZanDao.getZanByUidBlogId(myUserId, blogId)==null?0:1;
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getZanByUidBlogId fail "+myUserId+" "+blogId,e);
		}
		List<String> images =new ArrayList<String>();
		List<String> imageHDs = new ArrayList<String>();
		try {
			List<String> piclist = microblogPicDao.getMicroblogPicByBid(blogId);
			if (null!=piclist&&piclist.size()>0) {
				for(String pic:piclist){
					images.add(BCSUtil.getBlogImagePath(pic));
					imageHDs.add(BCSUtil.getBlogImageHDPath(pic));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMicroblogPicByBid fail "+blogId,e);
		}
		Map<String, Object> rst = new HashMap<String, Object>();
		rst.put("id", blogId);
		rst.put("status", blog.get_status());
		rst.put("isZaned", isZaned);
		
		rst.put("launchTime", Long.toString(blog.get_createtime().getTime()));
		rst.put("lauchPlace", "[UNSET]");
		
		rst.put("blogContent", JsonUtil.json2JsonObject(blog.get_content()));
		rst.put("imageUrlList", images);
		rst.put("imageUrlListHD", imageHDs);
		
		rst.put("share", share);
		
		rst.put("browseCount", Math.ceil(blog.get_browsenum()/10));
		rst.put("commentCount", blog.get_commnum());
		rst.put("transCount", blog.get_trannum());
		rst.put("zanCount", blog.get_zannum());
		
		rst.put("author", author);
		rst.put("medal", blog.get_status()>(byte)1?activityService.getOneMedal(blog.get_status(), blogId):null);
		rst.put("topic", blog.get_tid()>0?getOneTopic(blog.get_tid()):null);
		
		rst.put("hotRank", blog.get_hotrank());
		rst.put("recRank", blog.get_recrank());
		
		return rst;
	}

	@Override
	public Map<String, Object> getOneMblogShare(long id) {
		try {
			MicroblogShareDo share = microblogShareDao.getMicroblogShare(id);
			Map<String, Object> rst = new HashMap<String, Object>();
			if (null!=share) {
				rst.put("id", id);
				rst.put("source", JsonUtil.json2JsonObject(share.get_source()));
				rst.put("text", share.get_text());
				rst.put("image", share.get_image());
				rst.put("url", JsonUtil.json2JsonObject(share.get_dourl()));
			}
			return rst;
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getOneMblogShare fail",e);
			return null;
		}
	}

	@Override
	public Map<String, Object> getOneTopic(long topicId) {
		try {
			MicroblogTopicDo topic = microblogTopicDao.getMicroblogTopicByTopicId(topicId);
			Map<String, Object> rst = new HashMap<String, Object>();
			if (null!=topic) {
				rst.put("tid", topicId);
				rst.put("createUsrId", topic.get_createuid());
				rst.put("hot", topic.get_hot());
				rst.put("topic", topic.get_topic());
			}
			return rst;
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getOneTopic fail "+topicId,e);
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> getMblogList(long usrId, long frdId,
			long lastId, int objCount, int contentType, String topicStr,
			long schoolId) {
		List<Long> blogIds = null;
		ContentType type = ContentType.getContentType(contentType);
		try {
			switch (type) {
			case NEW:
				blogIds = microblogMainDao.getNewBlogIdList(usrId, lastId, objCount, schoolId);
				break;
			case HOT:
				blogIds = microblogMainDao.getHotBlogIdList(usrId, lastId, objCount, schoolId);
				break;
			case FRIEND:
				blogIds = microblogMainDao.getFriendBlogIdList(usrId, lastId, objCount, schoolId);
				break;
			case GROUP:
				blogIds = microblogMainDao.getGroupBlogIdList(usrId, lastId, objCount, schoolId);
				break;
			case SOMEONE:
				blogIds = microblogMainDao.getSomeoneBlogIdList(usrId, frdId, lastId, objCount, schoolId);
				break;
			case TOPIC:{
				Long topicId = getTopicIdByTopicStr(topicStr, schoolId);
				if (null!=topicId) {
					blogIds = microblogMainDao.getTopicBlogIdList(usrId, lastId, objCount, topicId, schoolId);
				}
				break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getMblogList fail",e);
		}
		List<Map<String, Object>> rst = new ArrayList<Map<String,Object>>();
		if (null!=blogIds&&blogIds.size()>0) {
			for(long blogId:blogIds){
				Map<String, Object> tmp = getOneMicroBlog_3(blogId, usrId);
				if (null!=tmp) {
					rst.add(tmp);
					increaseMblogBrowse(blogId);
				}
			}
		}
		return rst;
	}

	@Override
	public Long getTopicIdByTopicStr(String topicStr, long schoolId) {
		try {
			return microblogTopicDao.getTopicIdByTopicStr(topicStr, schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getTopicIdByTopicStr fail "+topicStr+" "+schoolId,e);
			return null;
		}
	}

	@Override
	public int increaseMblogBrowse(long bid) {
		try {
			return microblogMainDao.increaseMblogBrowse(bid, MicroBlogUtil.getBrowseNum());
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("increaseMblogBrowse fail "+bid,e);
			return -1;
		}
	}

	@Override
	public long getOneGoodTopicId(long schoolId) {
		try {
			List<Long> ids = microblogTopicDao.getGoodTopicIdBySchoolId(schoolId);
			if (null==ids||ids.size()==0) {
				return 0;
			}else{
				return ids.get(new Random().nextInt(ids.size()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getOneGoodTopicId fail "+schoolId,e);
			return 0;
		}
	}

	@Override
	public List<Long> getWallIngTopicIdList(long schoolId) {
		try {
			return microblogTopicDao.getWallIngTopicIdList(schoolId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getWallIngTopicIdList fail "+schoolId,e);
			return null;
		}
	}



}
