package com.projectERA.controller.api;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.manager.interfaces.ISubjectManager;
import com.projectERA.model.Student;
import com.projectERA.model.Subject;
import com.projectERA.model.Teacher;

@Controller
public class SubjectAPIController {
	@Autowired
	private ISubjectManager subjectManager;
	
	@RequestMapping(value = "/subjects/create")
	@ResponseBody
	public String create(Integer id, String title, Date deadline, Integer groupSize, String description,
			Integer idPromo, String specialty, ArrayList<Teacher> Authors) {
		try {
			Subject subject = new Subject(id, title, deadline, groupSize, description, idPromo, specialty, Authors);
			subjectManager.create(subject);
		} catch (Exception ex) {
			return "Error creating the subject: " + ex.toString();
		}
		return "Subject succesfully created!";
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
			return "Error deleting the subject : " + ex.toString();
		}
		return "subject succesfully deleted!";
	}

}
