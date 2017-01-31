package com.projectERA.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

@Controller
@RequestMapping("/api/teachers")
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
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String email, String firstName, String lastName, String ldapGUID) {
		try {
			Teacher teacher = new Teacher(email, firstName, lastName, ldapGUID);
			teacherDao.create(teacher);
		} catch (Exception ex) {
			return "Error creating the teacher: " + ex.toString();
		}
		return "Teacher succesfully created!";
	}

	/**
	 * Delete the identified teacher.
	 */
	@RequestMapping(value = "/delete")
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
//	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public List<Teacher> getAll() {
		List<Teacher> teachers= teacherDao.getAll();
		return teachers;
	}
	
	/**
	* List All Teachers.
	*/
//	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(value = "/getById")
	@ResponseBody
	public Teacher getById(Integer id) {
		Teacher teacher = teacherDao.getById(id);
		return teacher;
	}
	
	/**
	 * Update the email and names for the identified teacher.
	 */
//	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(method=RequestMethod.PUT, value = "/update")
	@ResponseBody
	public String update(Integer id, String email, String firstName, String lastName) {
		try {
			Teacher teacher = teacherDao.getById(id);
			teacher.setEmail(email);
			teacher.setFirstName(firstName);
			teacher.setLastName(lastName);
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
