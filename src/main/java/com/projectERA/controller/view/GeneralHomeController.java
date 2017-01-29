package com.projectERA.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneralHomeController {

	
	@RequestMapping(method=RequestMethod.GET, path="/home")
	public String index(Model model){
		return "home";
	
	}
//	@RequestMapping(method=RequestMethod.GET, path="/students/login")
//	public String loginEtudiant (Model model){
//		return "loginStudent";
//	}
	
//	@RequestMapping(method=RequestMethod.GET, path="/teachers/login")
//	public String loginEnseignant (Model model){
//		return "loginTeacher";
//	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="/archives/browse")
	public String browseArchives (Model model){
		return "archivesBrowse";
	}
	
}
	

