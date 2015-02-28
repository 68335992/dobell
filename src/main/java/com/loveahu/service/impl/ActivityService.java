package com.loveahu.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.loveahu.dao.CommonActivityDao;
import com.loveahu.dao.CommonPicDao;
import com.loveahu.dao.domain.common.CommonActivityDo;
import com.loveahu.dao.domain.common.CommonPicDo;
import com.loveahu.dao.domain.microblog.MicroblogMainDo;
import com.loveahu.service.IActivityService;
import com.loveahu.service.IMicroblogService;
import com.loveahu.service.IPicService;
import com.loveahu.util.BCSUtil;

@Service("activityService")
public class ActivityService implements IActivityService {

	Logger log = Logger.getLogger(ActivityService.class);

	@Resource
	IMicroblogService microblogService;
	
	@Resource
	CommonActivityDao commonActivityDao;

	@Override
	public CommonActivityDo getActivityById(long actId) {
		try {
			return commonActivityDao.getActivityById(actId);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("getActivityById fail",e);
			return null;
		}
	}

	@Override
	public Map<String, Object> getOneMedal(long actId, long blogId) {
		CommonActivityDo activity = getActivityById(actId);
		Map<String, Object> rst = new HashMap<String, Object>();
		if (null!=activity) {
			MicroblogMainDo blog = microblogService.getMicroblogMainById(blogId);
			rst.put("mid", actId);
			rst.put("status", activity.get_status());
			rst.put("theme", activity.get_name());
			rst.put("intro", activity.get_notice());
			rst.put("type", activity.get_type());
			rst.put("picUrl", BCSUtil.getmMedalImagePath(activity.get_medal()));
			rst.put("rewardXuhao", blogId);
			rst.put("rewardTime", null==blog?"0":Long.toString(blog.get_createtime().getTime()));
		}
		return rst;
	}
}
