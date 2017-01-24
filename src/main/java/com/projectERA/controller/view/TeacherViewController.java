package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.manager.interfaces.ITeacherManager;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Teacher;


@Controller
public class TeacherViewController {
	@Autowired
	private ITeacherManager teacherManager;
	
	@GetMapping("/teachers/create")
	public String userCreate(Model model) {
		model.addAttribute("attributs", DumpFields.<Teacher>inspect(Teacher.class));
		return "teacher/teacherCreate";
	}

	@PostMapping("/teachers/create")
	public String itemTestRetreiver(@ModelAttribute Teacher teacher){
		/*Teacher teacher = new Teacher(firstname, lastname, login, password);*/
		System.out.println(teacher);
		teacherManager.create(teacher);

		String redirectUrl = "/";
	    return "redirect:" + redirectUrl;
	}



}

