package com.projectERA.manager;

import org.springframework.stereotype.Service;

import com.projectERA.manager.base.BaseManager;
import com.projectERA.manager.interfaces.IStudentManager;
import com.projectERA.model.Student;

@Service
public class StudentManager extends BaseManager<Student> implements IStudentManager  {

}
