package com.projectERA.controller.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.IHomeworkManager;
import com.projectERA.model.Homework;




@Controller
public class HomeworkAPIController {
	
	
private IHomeworkManager homeworkManager;

@RequestMapping(value = "/homeworks/create")
@ResponseBody
public String create( Integer id, String title, String document) {
	try {
		Homework homework = new Homework(id ,title,document);
		homeworkManager.create(homework);
	} catch (Exception ex) {
		return "Error creating the Homework: " + ex.toString();
	}
	return "Homework succesfully created!";
}

@RequestMapping(value = "/homeworks/delete")
@ResponseBody
public String delete(Integer id) {
	try {
		Homework homework = new Homework(id);
		homeworkManager.delete(homework);
	} catch (Exception ex) {
		return "Error deleting the homework: " + ex.toString();
	}
	return "Homework succesfully deleted!";
}

@RequestMapping(value = "/homeworks/update")
@ResponseBody
public String updateName( Integer id, String title, String document) {
	try {
		Homework homework = homeworkManager.getById(id);
		homework.setTitle(title);
		homework.setDocument(document);
		homeworkManager.update(homework);
	} catch (Exception ex) {
		return "Error updating the homework: " + ex.toString();
	}
	return "Homework succesfully updated!";
}













}
