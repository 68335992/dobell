package com.loveahu.util.push.getui;

import org.apache.log4j.Logger;

import cn.com.tx.galaxy.util.JsonUtil;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.loveahu.constant.DoBell;
import com.loveahu.util.push.domain.PushBody;

public class PushtoSingle {

	Logger log = Logger.getLogger(PushtoSingle.class);
	
	public void push(String id,String title,String content,char type,String info){
		try {
		IGtPush push = new IGtPush(DoBell.GETUI_HOST, DoBell.GETUI_APPKEY, DoBell.GETUI_MASTER);
		push.connect();
		PushBody body = new PushBody();
		body.setContent(content);
		body.setInfo(info);
		body.setTip(title);
		body.setTopic(title);
		body.setType(type);
		String bodyStr = JsonUtil.Object2Json(body);
//		bodyStr = "{\"content\":\"   晓寒..... 在评论中@你了1\",\"info\":\"{}\",\"tip\":\"小安温馨提示:\",\"topic\":\"小安温馨提示:\",\"type\":\"1\"}";
		bodyStr = "{\"content\":\"   晓寒..... 在评论中@你了1\",\"info\":\"{}\",\"tip\":\"小安温馨提示:\",\"topic\":\"小安温馨提示:\",\"type\":1}";
		System.out.println(bodyStr);
		TransmissionTemplate template = getTransmissionTemplate(bodyStr); 
		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		message.setOfflineExpireTime(12 * 1000 * 3600);
		message.setData(template);
		message.setPushNetWorkType(0); //根据WIFI推送设置

		Target target1 = new Target();
		target1.setAppId(DoBell.GETUI_APPID);
		target1.setClientId(id);

		IPushResult ret = push.pushMessageToSingle(message, target1);
		System.out.println("push "+id+" rst ["+ret.getResponse().toString()+"]");
		log.info("push "+id+"rst ["+ret.getResponse().toString()+"]");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static TransmissionTemplate getTransmissionTemplate(String content)
			throws Exception {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(DoBell.GETUI_APPID);
		template.setAppkey(DoBell.GETUI_APPKEY);
		template.setTransmissionType(2);
		template.setTransmissionContent(content);
		return template;
	}
}