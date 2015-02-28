package com.loveahu.dao.domain.common;

import java.io.Serializable;

public class SiteDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SiteDo(){}
	
	public SiteDo(String site){
		this.site = site;
	}
	
	String site;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
}
