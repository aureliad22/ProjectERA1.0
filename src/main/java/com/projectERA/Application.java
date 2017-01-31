package com.projectERA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.projectERA.dao.AdministratorDao;
import com.projectERA.dao.GradeDao;
import com.projectERA.dao.GroupDao;
import com.projectERA.dao.HomeworkDao;
import com.projectERA.dao.StudentDao;
import com.projectERA.dao.SubjectDao;
import com.projectERA.dao.TeacherDao;
import com.projectERA.dao.interfaces.IAdministratorDao;
import com.projectERA.dao.interfaces.IGradeDao;
import com.projectERA.dao.interfaces.IGroupDao;
import com.projectERA.dao.interfaces.IHomeworkDao;
import com.projectERA.dao.interfaces.IStudentDao;
import com.projectERA.dao.interfaces.ISubjectDao;
import com.projectERA.dao.interfaces.ITeacherDao;
import com.projectERA.model.Grade;
import com.projectERA.model.Student;
import com.projectERA.model.Teacher;
import com.projectERA.storage.StorageProperties;
import com.projectERA.storage.StorageService;
import com.projectERA.utils.JsonManager;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application implements CommandLineRunner {

//	private static List<Teacher> teachers=JsonManager.getInstance().readJsonFile("./src/main/resources/static/json/", "dumpTeachers.json", Teacher.class);
	private static List<Grade> grades=JsonManager.getInstance().readJsonFile("./src/main/resources/static/json/", "dumpGrades.json", Grade.class);
//	private static List<Student> students=JsonManager.getInstance().readJsonFile("./src/main/resources/static/json/", "dumpStudents.json", Student.class);
//
//	@Autowired
//	private ITeacherDao teacherDao;
//	
//	@Autowired
//	private IGradeDao gradeDao;

//	@Autowired
//	private IStudentDao studentDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
/*		User user = new User("Toto", "toto22");
		user.setFirstName("Administrator");

		this.repository.save(user);*/
//		for (Teacher teacher : teachers) {
//			teacherDao.create(teacher);
//		}
//		
//		for (Grade grade : grades) {
//			gradeDao.create(grade);
//		}
		
//		for (Student student : students) {
//			studentDao.create(student);
//		}
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
            storageService.deleteAll();
            storageService.init();
		};
	}
	
	@Bean
	public ITeacherDao getTeacherDao() {
		return new TeacherDao();
	}

	@Bean
	public IStudentDao getStudentDao() {
		return new StudentDao();
	}

	@Bean
	public IGradeDao getGradeDao() {
		return new GradeDao();
	}
	
	@Bean
	public IAdministratorDao getAdministratorDao(){
		return new AdministratorDao();
	}

	@Bean
	public IHomeworkDao getHomeworkDao() {
		return new HomeworkDao();
	}
	
	@Bean
	public IGroupDao getGroupDao(){
		return new GroupDao();
	}
	
	@Bean
	public ISubjectDao getSubjectDao(){
		return new SubjectDao();
	}
		
}