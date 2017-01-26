package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;

@Controller
public class StudentAPIController {

	/**
	 * Recover the StudentDao from IStudentDao to use within this controller.
	 */
	@Autowired
	private IStudentDao studentDao;
	
	/**
	 * Create a new Student with an auto-generated id and email/lastname/firstname as passed
	 * values.
	 */
	@RequestMapping(value = "/students/create")
	@ResponseBody
	public String create(String firstname, String lastname, String email) {
		try {
			Student student = new Student(firstname, lastname, email);
			studentDao.create(student);
		} catch (Exception ex) {
			return "Error creating the student: " + ex.toString();
		}
		return "Student succesfully created!";
	}

	/**
	 * Delete the identified student.
	 */
	@RequestMapping(value = "/students/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Student student = new Student(id);
			studentDao.delete(student);
		} catch (Exception ex) {
			return "Error deleting the student: " + ex.toString();
		}
		return "Student succesfully deleted!";
	}

	/**
	 * Update the email and names for the identified student.
	 */
	@RequestMapping(value = "/students/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String email) {
		try {
			Student student = studentDao.getById(id);
			student.setFirstName(firstname);
			student.setLastName(lastname);
			student.setEmail(email);
			studentDao.update(student);
		} catch (Exception ex) {
			return "Error updating the student: " + ex.toString();
		}
		return "Student succesfully updated!";
	}

}
