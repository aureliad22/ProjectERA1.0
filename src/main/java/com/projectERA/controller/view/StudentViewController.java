package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Student;


@Controller
public class StudentViewController {

	@Autowired
	private IStudentDao studentDao;
	
	@GetMapping("/students/create")
	public String userCreate(Model model) {
		model.addAttribute("attributs", DumpFields.<Student>inspect(Student.class));
		return "students/studentCreate";
	}

	@PostMapping("/students/create")
	public String itemTestRetreiver(@ModelAttribute Student student){

		System.out.println(student);
		studentDao.create(student);

		String redirectUrl = "/";
	    return "redirect:" + redirectUrl;
	}



}
