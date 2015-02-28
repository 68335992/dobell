package com.loveahu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController extends BaseController {

	@ResponseBody
	@RequestMapping("/")
	public String index(HttpServletRequest request,
			HttpServletResponse response
			){
		return "welcome";
	}
	
	@ResponseBody
	@RequestMapping("/favicon")
	public String favicon(HttpServletRequest request,
			HttpServletResponse response
			){
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/robots.txt")
	public String robots(HttpServletRequest request,
			HttpServletResponse response
			){
		return "[]";
	}
}
