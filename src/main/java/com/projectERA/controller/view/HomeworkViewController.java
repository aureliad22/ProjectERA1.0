package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.projectERA.dao.interfaces.IHomeworkDao;

@Controller
public class HomeworkViewController {
	@Autowired
	private IHomeworkDao homeworkDao;
	



}
