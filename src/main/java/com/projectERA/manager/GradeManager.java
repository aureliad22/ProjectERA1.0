package com.projectERA.manager;

import org.springframework.stereotype.Service;

import com.projectERA.manager.base.BaseManager;
import com.projectERA.manager.interfaces.IGradeManager;
import com.projectERA.model.Grade;

@Service
public class GradeManager extends BaseManager<Grade> implements IGradeManager  {

}
