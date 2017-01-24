package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.manager.interfaces.IGradeManager;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Grade;


@Controller
public class GradeViewController {
	@Autowired
	private IGradeManager gradeManager;
	
	@GetMapping("/grades/create")
	public String userCreate(Model model) {
		model.addAttribute("attributs", DumpFields.<Grade>inspect(Grade.class));
		return "grade/gradeCreate";
	}

	@PostMapping("/grades/create")
	public String itemTestRetreiver(@ModelAttribute Grade grade){
		System.out.println(grade);
		gradeManager.create(grade);

		String redirectUrl = "/";
	    return "redirect:" + redirectUrl;
	}



}

