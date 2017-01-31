package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IGradeDao;
import com.projectERA.model.Grade;

@Controller
@RequestMapping("/api/grades")
public class GradeAPIController {

	/**
	 * Recover the GradeDao from IGradeDao to use within this controller.
	 */
	@Autowired
	private IGradeDao gradeDao;

	/**
	 * Create a new grade with an auto-generated id and name/year as passed
	 * values.
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String name, String year) {
		try {
			Grade grade = new Grade(name, year);
			gradeDao.create(grade);
		} catch (Exception ex) {
			return "Error creating the grade: " + ex.toString();
		}
		return "Grade succesfully created!";
	}

	/**
	 * Delete the identified grade.
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Grade grade = new Grade(id);
			gradeDao.delete(grade);
		} catch (Exception ex) {
			return "Error deleting the grade: " + ex.toString();
		}
		return "Grade succesfully deleted!";
	}

	/**
	 * Update the identified grade's name.
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateName(Integer id, String name, String year) {
		try {
			Grade grade = gradeDao.getById(id);
			grade.setName(name);;
			grade.setYear(year);
			gradeDao.update(grade);
		} catch (Exception ex) {
			return "Error updating the grade: " + ex.toString();
		}
		return "Grade succesfully updated!";
	}

}
