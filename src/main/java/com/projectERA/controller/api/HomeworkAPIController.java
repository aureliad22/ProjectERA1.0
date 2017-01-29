package com.projectERA.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IHomeworkDao;
import com.projectERA.model.Homework;

@Controller
@RequestMapping("/api/homework")
public class HomeworkAPIController {
	
	/**
	 * Recover the HomeworkDao from IHomeworkDao to use within this controller.
	 */
	private IHomeworkDao homeworkDao;

	/**
	 * Create a homework with the title/document as passed values.
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	public String create(Integer id, String title, String document) {
		try {
			Homework homework = new Homework(id, title, document);
			homeworkDao.create(homework);
		} catch (Exception ex) {
			return "Error creating the Homework: " + ex.toString();
		}
		return "Homework succesfully created!";
	}

//	/**
//	 * Delete the identified homework.
//	 */
//	@RequestMapping(value = "/homeworks/delete")
//	@ResponseBody
//	public String delete(Integer id) {
//		try {
//			Homework homework = new Homework(id);
//			homeworkDao.delete(homework);
//		} catch (Exception ex) {
//			return "Error deleting the homework: " + ex.toString();
//		}
//		return "Homework succesfully deleted!";
//	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateName(Integer id, String title, String document) {
		try {
			Homework homework = homeworkDao.getById(id);
			homework.setTitle(title);
			homework.setDocument(document);
			homeworkDao.update(homework);
		} catch (Exception ex) {
			return "Error updating the homework: " + ex.toString();
		}
		return "Homework succesfully updated!";
	}

}
