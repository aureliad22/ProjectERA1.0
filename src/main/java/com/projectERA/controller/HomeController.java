package com.projectERA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET, path="/home")
	public String index(Model model){
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/page1")
	public String page1(Model model){
		return "page1";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/page2")
	public String page2(Model model){
		return "page2";
	}
	
}
