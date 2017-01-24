package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.IStudentManager;
import com.projectERA.model.Student;

@Controller
public class StudentAPIController {

	@Autowired
	private IStudentManager studentManager;
	
	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/students/create")
	@ResponseBody
	public String create(String firstname, String lastname, String login, String password, String email) {
		try {
			Student student = new Student(firstname, lastname, login, password, email);
			studentManager.create(student);
		} catch (Exception ex) {
			return "Error creating the student: " + ex.toString();
		}
		return "Student succesfully created!";
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value = "/students/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Student student = new Student(id);
			studentManager.delete(student);
		} catch (Exception ex) {
			return "Error deleting the student: " + ex.toString();
		}
		return "Student succesfully deleted!";
	}

	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */
	@RequestMapping(value = "/students/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String login, String password, String email) {
		try {
			Student student = studentManager.getById(id);
			student.setFirstName(firstname);
			student.setLastName(lastname);
			student.setLogin(login);
			student.setPassword(password);
			student.setEmail(email);
			studentManager.update(student);
		} catch (Exception ex) {
			return "Error updating the student: " + ex.toString();
		}
		return "Student succesfully updated!";
	}
	
//	  /**
//	   * Retrieve the id for the user with the passed email address.
//	   */
//	  @RequestMapping(value="/get-by-email")
//	  @ResponseBody
//	  public String getByEmail(String email) {
//	    String studentId;
//	    try {
//	      Student student = studentManager.getByEmail(email);
//	      studentId = String.valueOf(student.getId());
//	    }
//	    catch (Exception ex) {
//	      return "User not found: " + ex.toString();
//	    }
//	    return "The user id is: " + studentId;
//	  }
}
