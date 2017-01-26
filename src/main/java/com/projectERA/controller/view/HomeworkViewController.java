package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.manager.interfaces.IHomeworkManager;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Homework;

=======

import com.projectERA.dao.interfaces.IHomeworkDao;
>>>>>>> 920f72d190a7ba387bdb4d62e5a9961c892a44df

@Controller
public class HomeworkViewController {
	@Autowired
	private IHomeworkDao homeworkDao;
	
	@GetMapping("/homeworks/create")
	public String homeworkCreate(Model model){
		model.addAttribute("attributs",DumpFields.<Homework>inspect(Homework.class));
		return "grade/gradeCreate";
	}
	
	@PostMapping("/homeworks/create")
	public String itemTestRetreiver(@ModelAttribute Homework homework){
		System.out.println(homework);
		homeworkManager.create(homework);

		String redirectUrl = "/";
	    return "redirect:" + redirectUrl;
	}


}
