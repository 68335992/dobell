package com.loveahu.dao.eum;

public enum MicroblogInfoType {

	INFO_TYPE_NOMO(1),
	INFO_TYPE_TPING(2),
	INFO_TYPE_TPCOM(3)
	;
	
	private MicroblogInfoType(int type){
		this.type =type;
	}
	
	public int type;
	public String tip;
	
	public static boolean valid(int type){
		MicroblogInfoType[] pts = MicroblogInfoType.values();
		for(MicroblogInfoType pt:pts){
			if (type==pt.type) {
				return true;
			}
		}
		return false;
	}
}
