package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.ITeacherManager;
import com.projectERA.model.Teacher;

@Controller
public class TeacherAPIController {

	@Autowired
	private ITeacherManager teacherManager;

	/**
	 * Create a new user with an auto-generated id and email and name as passed
	 * values.
	 */
	@RequestMapping(value = "/teachers/create")
	@ResponseBody
	public String create(String firstname, String lastname, String login, String password, String email) {
		try {
			Teacher teacher = new Teacher(firstname, lastname, login, password, email);
			teacherManager.create(teacher);
		} catch (Exception ex) {
			return "Error creating the teacher: " + ex.toString();
		}
		return "Teacher succesfully created!";
	}

	/**
	 * Delete the user with the passed id.
	 */
	@RequestMapping(value = "/teachers/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Teacher teacher = new Teacher(id);
			teacherManager.delete(teacher);
		} catch (Exception ex) {
			return "Error deleting the teacher: " + ex.toString();
		}
		return "Teacher succesfully deleted!";
	}

	/**
	 * Update the email and the name for the user indentified by the passed id.
	 */
	@RequestMapping(value = "/teachers/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String login, String password) {
		try {
			Teacher teacher = teacherManager.getById(id);
			teacher.setFirstName(firstname);
			teacher.setLastName(lastname);
			teacher.setLogin(login);
			teacher.setPassword(password);
			teacherManager.update(teacher);
		} catch (Exception ex) {
			return "Error updating the teacher: " + ex.toString();
		}
		return "Teacher succesfully updated!";
	}

//	  /**
//	   * Retrieve the id for the user with the passed email address.
//	   */
//	  @RequestMapping(value="/get-by-email")
//	  @ResponseBody
//	  public String getByEmail(String email) {
//	    String teacherId;
//	    try {
//	      Teacher teacher = teacherManager.getByEmail(email);
//	      teacherId = String.valueOf(teacher.getId());
//	    }
//	    catch (Exception ex) {
//	      return "User not found: " + ex.toString();
//	    }
//	    return "The user id is: " + teacherId;
//	  }
}
