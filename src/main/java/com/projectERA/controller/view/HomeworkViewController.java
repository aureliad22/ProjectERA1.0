package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectERA.manager.interfaces.IHomeworkManager;
import com.projectERA.model.DumpFields;
import com.projectERA.model.Student;

@Controller
public class HomeworkViewController {
	@Autowired
	private IHomeworkManager homeworkManager;
	



}
