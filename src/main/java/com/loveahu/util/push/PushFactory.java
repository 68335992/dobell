package com.loveahu.util.push;

import com.loveahu.util.push.getui.PushtoSingle;

public class PushFactory {

	private static PushtoSingle getuiSingle = new PushtoSingle();
	
	public static PushtoSingle getGetuiSingle(){
		return getuiSingle;
	}
}
