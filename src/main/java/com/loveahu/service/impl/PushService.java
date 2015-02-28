package com.loveahu.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.com.tx.galaxy.util.StringUtil;

import com.loveahu.constant.DoBell;
import com.loveahu.dao.eum.PushType;
import com.loveahu.service.IPushService;
import com.loveahu.service.IUserService;
import com.loveahu.util.push.PushFactory;

@Service("pushService")
public class PushService implements IPushService {

	Logger log = Logger.getLogger(PushService.class);

	@Resource
	IUserService userService;
	
	@Override
	public void pushSingle(long fuid, long tuid, byte type, String info) {
		if (!PushType.valid(type)) {
			return;
		}
		String getuiId = userService.getGetuiIdByUsrId(tuid);
		if (StringUtil.isBlank(getuiId)) {
			log.error("cannt find getuiid ["+tuid+"]");
			return;
		}
		if (DoBell.GEITUI_IGNORE_ID.equals(getuiId)) {
			return;
		}
		final Byte olType = userService.getUserOlType(tuid);
		if (null==olType) {
			log.error("cannt find oltype ["+tuid+"]");
			return;
		}
		String fusername = userService.getNickByUsrId(fuid);
		fusername = null==fusername?"":fusername;
		userService.increaseBadge(tuid);
		Integer badge = userService.getUserBadge(tuid);
		badge = null==badge?0:badge;
		if (olType==2) {
			/**
			 * TODO:IOS推送
			 */
		}else if(olType != -9){
			/**
			 * Android推送
			 */
			PushType pushType = PushType.getPushType(type);
			switch (pushType) {
			case MICROBLOG_AT:
			case COMMENT_AT:
			case MICROBLOG_COMMENT:
			case REPLY_COMMENT:
			case REWARD_MICROBLOG:
			case MICROBLOG_ZAN:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_SITUATION, info);
				break;
			case FRIEND_REQUEST:
			case FRIEND_FORBID:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_REQUEST, info);
				break;
			case FRIEND_MARK:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_FRIEND, info);
				break;
			case SEND_CARD:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_CARD, info);
				break;
			case SCIPT:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_SCRIP, info);
				break;
			case GROUP_NEWS:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_SPORT, info);
				break;
			case GAME_GOD:
				androidPushSingle(getuiId, DoBell.PUSH_DEFAULT_TITLE, fusername+" "+pushType.tip, PUSH_TYPE_TOOLS, info);
				break;
			default:
				break;
			}
		}
	}
	
	private void androidPushSingle(String id,String title,String content,char type,String info){
		PushFactory.getGetuiSingle().push(id, title, content, type, info);
	}
}
