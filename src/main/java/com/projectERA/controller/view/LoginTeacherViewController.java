package com.projectERA.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectERA.dao.TeacherDao;
import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Teacher;

@Controller
public class LoginTeacherViewController {

	protected ITeacherDao teacherDao;

	@Autowired
	public LoginTeacherViewController(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

@RequestMapping(method= RequestMethod.GET, path = "/teachers/login")
public String login(Model model) {
	return "loginTeacher";
}

@RequestMapping(method = RequestMethod.POST, path= "/teachers/checkLogin")
public String checkLogin(
		@RequestParam(value = "email", required = false)
		String email,
		@RequestParam(value = "password", required = false)
		String password,
		Model model){
	
	Teacher teacher = this.teacherDao.getByEmail(email);
	
	if (teacher != null && 
			teacher.getPassword().equals(password)) {
			model.addAttribute("email", email);
			return "homeTeacher";
		}
			model.addAttribute("fail", true);
			return "loginTeacher";
}


}
