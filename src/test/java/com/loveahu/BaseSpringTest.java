package com.loveahu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseSpringTest {

	protected static ApplicationContext context = null;
	
	static{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
