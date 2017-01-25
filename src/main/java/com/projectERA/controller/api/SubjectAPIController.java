package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.ISubjectManager;
import com.projectERA.model.Student;
import com.projectERA.model.Subject;

@Controller
public class SubjectAPIController {
	@Autowired
	private ISubjectManager subjectManager;
	
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
	@RequestMapping(value = "/subjects/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Subject subject = new Subject(id);
			subjectManager.delete(subject );
		} catch (Exception ex) {
			return "Error deleting thesubject : " + ex.toString();
		}
		return "subject succesfully deleted!";
	}

}
