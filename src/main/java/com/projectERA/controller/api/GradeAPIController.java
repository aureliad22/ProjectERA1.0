package com.projectERA.controller.api;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.IGradeManager;
import com.projectERA.model.Grade;

@Controller
public class GradeAPIController {

	@Autowired
	private IGradeManager gradeManager;

	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/grades/create")
	@ResponseBody
	public String create(String name, String year) {
		try {
			Grade grade = new Grade(name, year);
			gradeManager.create(grade);
		} catch (Exception ex) {
			return "Error creating the grade: " + ex.toString();
		}
		return "Grade succesfully created!";
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value = "/grades/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Grade grade = new Grade(id);
			gradeManager.delete(grade);
		} catch (Exception ex) {
			return "Error deleting the grade: " + ex.toString();
		}
		return "Grade succesfully deleted!";
	}

	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */
	@RequestMapping(value = "/grades/update")
	@ResponseBody
	public String updateName(Integer id, String name, String year) {
		try {
			Grade grade = gradeManager.getById(id);
			grade.setName(name);;
			grade.setYear(year);
			gradeManager.update(grade);
		} catch (Exception ex) {
			return "Error updating the grade: " + ex.toString();
		}
		return "Grade succesfully updated!";
	}

}
