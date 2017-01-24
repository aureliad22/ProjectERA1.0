package com.projectERA.manager;

import org.springframework.stereotype.Service;

import com.projectERA.manager.base.BaseManager;
import com.projectERA.manager.interfaces.ITeacherManager;
import com.projectERA.model.Teacher;

@Service
public class TeacherManager extends BaseManager<Teacher> implements ITeacherManager {

}
