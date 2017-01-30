package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectERA.dao.interfaces.IHomeworkDao;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Homework;


@Controller
public class HomeworkViewController {
	@Autowired
	private IHomeworkDao homeworkDao;
	
	@GetMapping("/homeworks/create")
	public String homeworkCreate(Model model){
	
		return "homework_deposit";
	}
	
	
	@GetMapping("/homeworks/teacherdeposit")
	public String homeworkTeacherDeposit(Model model){
		
		return "teacher_deposit";
	}



}
