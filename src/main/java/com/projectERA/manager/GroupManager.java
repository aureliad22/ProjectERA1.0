package com.projectERA.manager;

import org.springframework.stereotype.Service;

import com.projectERA.manager.base.BaseManager;
import com.projectERA.manager.interfaces.IGroupManager;
import com.projectERA.model.Group;

@Service
public class GroupManager extends BaseManager<Group> implements IGroupManager{

}
