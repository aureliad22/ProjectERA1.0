package com.projectERA.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

@Controller
public class TeacherAPIController {

	/**
	 * Recover the TeacherDao from ITeacherDao to use within this controller.
	 */
	@Autowired
	private ITeacherDao teacherDao;

	/**
	 * Create a new Teacher with an auto-generated id, and email/lastname/firstname as passed
	 * values.
	 */
	@RequestMapping(value = "/teachers/create")
	@ResponseBody
	public String create(String firstname, String lastname, String email) {
		try {
			Teacher teacher = new Teacher(firstname, lastname, email);
			teacherDao.create(teacher);
		} catch (Exception ex) {
			return "Error creating the teacher: " + ex.toString();
		}
		return "Teacher succesfully created!";
	}

	/**
	 * Delete the identified teacher.
	 */
	@RequestMapping(value = "/teachers/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Teacher teacher = new Teacher(id);
			teacherDao.delete(teacher);
		} catch (Exception ex) {
			return "Error deleting the teacher: " + ex.toString();
		}
		return "Teacher succesfully deleted!";
	}


	/**
	* List All Teachers.
	*/
	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(value = "/teachers/getall")
	@ResponseBody
	public List<Teacher> getAll() {
		List<Teacher> teachers= teacherDao.getAll();
		return teachers;
	}
	
	/**
	 * Update the email and names for the identified teacher.
	 */
	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(value = "/teachers/update")
	@ResponseBody
	public String updateName(Integer id, String firstname, String lastname, String email) {
		try {
			Teacher teacher = teacherDao.getById(id);
			teacher.setEmail(email);
			teacher.setFirstName(firstname);
			teacher.setLastName(lastname);
			teacherDao.update(teacher);
		} catch (Exception ex) {
			return "Error updating the teacher: " + ex.toString();
		}
		return "Teacher succesfully updated!";
	}

//	  /**
//	   * Retrieve the id for the user with the passed email address.
//	   */
//	  @RequestMapping(value="/teachers/getByEmail")
//	  @ResponseBody
//	  public String getByEmail(String email) {
//	    String teacherId;
//	    try {
//	      Teacher teacher = teacherDao.getByEmail(email);
//	      teacherId = String.valueOf(teacher.getId());
//	    }
//	    catch (Exception ex) {
//	      return "Teacher not found: " + ex.toString();
//	    }
//	    return "The teacher's email is: " + teacherId;
//	  }
}
