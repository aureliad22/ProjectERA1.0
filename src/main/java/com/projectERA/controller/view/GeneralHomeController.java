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
	@RequestMapping(method=RequestMethod.GET, path="/loginStudent")
	public String loginEtudiant (Model model){
		return "loginStudent";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/loginTeacher")
	public String loginEnseignant (Model model){
		return "loginTeacher";
	}
	
}
	

