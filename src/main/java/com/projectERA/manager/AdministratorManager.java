package com.projectERA.manager;

import org.springframework.stereotype.Service;

import com.projectERA.manager.base.BaseManager;
import com.projectERA.manager.interfaces.IAdministratorManager;
import com.projectERA.model.Administrator;

@Service
public class AdministratorManager extends BaseManager<Administrator> implements IAdministratorManager{

}
