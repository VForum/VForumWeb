package com.vforum.helper;
import org.apache.log4j.Logger;

//used as abstraction for admin operations
import com.vforum.dao.AdminDAO;
import com.vforum.dao.AdminDAOImpl;
import com.vforum.service.AdminService;
import com.vforum.service.AdminServiceImpl;

public class FactoryAdminDB {
	static Logger logger=Logger.getLogger(FactoryAdminDB.class.getName());

	public static AdminDAO createAdminDAO(){
		logger.info("---- In FactoryAdminDB createAdminDAO method called---- ");
		AdminDAO adminDAO=new AdminDAOImpl();
		logger.info("---- In FactoryAdminDB createAdminDAO method completed---- ");
		return adminDAO;
		
	}
	public static AdminService createAdminService(){
		logger.info("---- In FactoryAdminDB createAdminService method called---- ");
		AdminService adminService=new AdminServiceImpl();
		logger.info("---- In FactoryAdminDB createAdminService method completed---- ");
		return adminService;
	}
	
}
