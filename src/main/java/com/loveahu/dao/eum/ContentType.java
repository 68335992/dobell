package com.loveahu.dao.eum;

public enum ContentType {

	NEW(1),
	HOT(2),
	FRIEND(3),
	GROUP(4),
	SOMEONE(5),
	TOPIC(6)
	;
	
	private ContentType(int type){
		this.type =type;
	}
	
	public int type;
	public String tip;
	
	public static ContentType getContentType(int op){
		ContentType[] types = ContentType.values();
		for(ContentType type:types){
			if (op==type.type) {
				return type;
			}
		}
		return null;
	}
	
	public static boolean valid(int type){
		ContentType[] pts = ContentType.values();
		for(ContentType pt:pts){
			if (type==pt.type) {
				return true;
			}
		}
		return false;
	}
}
