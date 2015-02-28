package com.loveahu.task;

import org.apache.log4j.Logger;

public class TestTask {

	Logger log = Logger.getLogger(TestTask.class);
	
	public void execute(){
		long now = System.currentTimeMillis();
		log.info("test task start");
		try {
			log.info("test task running");
		} catch (Throwable e) {
			e.printStackTrace();
			log.error("test task failed.",e);
			return;
		}
		System.out.println("test task end.cost:"+(System.currentTimeMillis()-now)+"ms");
	}
}
