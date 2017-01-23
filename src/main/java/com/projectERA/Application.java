package com.projectERA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projectERA.dao.StudentDao;
import com.projectERA.dao.TeacherDao;
import com.projectERA.dao.UserDao;
import com.projectERA.model.User;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private StudentDao studentDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		//ajouter le main pour le ldap
//		ActiveDirectory ad = new ActiveDirectory();
//		ad.connect();
//		students = ad.requestAll(Student.class);
//		teachers = ad.requestAll(Teacher.class);
//		promotions= ad.getPromos();
	}
	
	@Override
	public void run (String...args) throws Exception{
		User user = new User("Toto", "toto22");
		user.setFirstName("Administrator");		
		this.userDao.save(user);
		
		for (User user1 : userDao.findAll()) {
//			userRepo.create(user1);
            System.out.println(user1.toString());
        }
		
//		for (Student student : studentDao.findAll()) {
//			studentDao.create(student);
//            System.out.println(student.toString());
//        }
//		
//		for (Teacher teacher : teacherDao.findAll()) {
//			teacherDao.create(teacher);
//            System.out.println(teacher.toString());
//        }
	}
	
	@Bean
	public StudentDao getStudentDao(){
		return new StudentDao();
	}
	
	@Bean
	public TeacherDao getTeacherDao(){
		return new TeacherDao();
	}
	
	@Bean
	public UserDao getUserDao(){
		return new UserDao();
	}

}
