package com.projectERA.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;
import com.projectERA.model.Teacher;

@Controller
@RequestMapping("/api/students")
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
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(String email, String firstName, String lastName, String ldapGUID) {
		try {
			Student student = new Student(email, firstName, lastName, ldapGUID);
			studentDao.create(student);
		} catch (Exception ex) {
			return "Error creating the student: " + ex.toString();
		}
		return "Student succesfully created!";
	}

	/**
	 * Delete the identified student.
	 */
	@RequestMapping(value = "/delete")
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

	@RequestMapping(value = "/getAll")
	@ResponseBody
	public List<Student> getAll() {
		List<Student> students= studentDao.getAll();
		return students;
	}
	
	/**
	* List All Teachers.
	*/
//	@CrossOrigin(origins="localhost:4200")
	@RequestMapping(value = "/getById")
	@ResponseBody
	public Student getById(Integer id) {
		Student student = studentDao.getById(id);
		return student;
	}
	
	/**
	 * Update the email and names for the identified student.
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateName(Integer id, String email, String firstname, String lastname) {
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
