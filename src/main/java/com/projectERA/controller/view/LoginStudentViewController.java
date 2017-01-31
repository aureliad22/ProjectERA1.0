mpackage com.projectERA.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.model.Student;

@Controller
public class LoginStudentViewController {

	protected IStudentDao studentDao;

	public LoginStudentViewController(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/students/login")
	public String login(Model model) {
		return "loginStudent";
	}
	
	@RequestMapping(method= RequestMethod.GET, path = "/students/home")
	public String loginStudent(Model model) {
		return "homeStudent";
	}


	@RequestMapping(method = RequestMethod.POST, path = "/students/checkLogin")
	public String checkLogin(
			@RequestParam(value = "login", required = false) 
			String login,
			@RequestParam(value = "password", required = false) 
			String password, 
			Model model) {
		Student student = this.studentDao.getByLogin(login);

		if (student != null && student.getPassword().equals(password)) {
			model.addAttribute("login", login);
			return "homeStudent";

		}
		
		model.addAttribute("fail",true);
		return "loginStudent";

	}

}
