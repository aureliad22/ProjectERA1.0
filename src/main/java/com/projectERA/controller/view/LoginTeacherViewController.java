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

//@RequestMapping(method=RequestMethod.GET, path="/teachers/login")
//public String loginEnseignant (Model model){
//	return "loginTeacher";
//}

@RequestMapping(method= RequestMethod.GET, path = "/teachers/home")
public String loginTeacher(Model model) {
	return "homeTeacher";
}

@RequestMapping(method = RequestMethod.POST, path= "/teachers/checkLogin")
public String checkLogin(
		@RequestParam(value = "login", required = false)
		String login,
		@RequestParam(value = "password", required = false)
		String password,
		Model model){
	
	Teacher teacher = this.teacherDao.getByLogin(login);
	
	if (teacher != null && 
			teacher.getPassword().equals(password)) {
			model.addAttribute("login", login);
			return "homeTeacher";
		}
			model.addAttribute("fail", true);
			return "loginTeacher";
}



}
