package com.projectERA.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projectERA.dao.interfaces.IGroupDao;
import com.projectERA.model.Group;



@Controller
public class GroupAPIController {
	
	/**
	 * Recover the GroupDao from IGroupDao to use within this controller.
	 */
	@Autowired
	private IGroupDao groupDao;
	
	/**
	 * Delete the identified group.
	 */
	@RequestMapping(value = "/groups/create")
	@ResponseBody
	public String create(Integer id) {
		try {
			Group group = new Group(id);
			groupDao.create(group);
		} catch (Exception ex) {
			return "Error creating the group: " + ex.toString();
		}
		return "Group succesfully created!";
	}
	
	/**
	 * Delete the identified group.
	 */
	@RequestMapping(value = "/groups/delete")
	@ResponseBody
	public String delete(Integer id) {
		try {
			Group group = new Group(id);
			groupDao.delete(group);
		} catch (Exception ex) {
			return "Error deleting the group: " + ex.toString();
		}
		return "Group succesfully deleted!";
	}

}
