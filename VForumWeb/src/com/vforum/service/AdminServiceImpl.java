package com.vforum.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vforum.dao.AdminDAO;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.PostModel;


public class AdminServiceImpl implements AdminService {
             private AdminDAO adminDAO;
             Logger logger=Logger.getLogger(AdminServiceImpl.class.getName());
	
	public AdminServiceImpl() {
		this.adminDAO=FactoryAdminDB.createAdminDAO();
		
	}

	@Override
	public List<EmployeeModel> retrieveEmployees() {
		// TODO Auto-generated method stub
		logger.info("---- In AdminServiceImpl retrieveEmployees method started ---- ");
		List<EmployeeModel> employeesModelList=new ArrayList<>();
		
			List<Employees> employeesList;
			try {
				employeesList = adminDAO.getEmployeeDetails();
			
			for(Employees employees:employeesList)
			{
				EmployeeModel employeesModel=new EmployeeModel();
				employeesModel.setEmployeeUid(employees.getEmployeeUid());
				employeesModel.setFirstName(employees.getFirstName());
				employeesModel.setLastName(employees.getLastName());
				employeesModel.setEmail(employees.getEmail());
				employeesModel.setPhoneNumber(employees.getPhoneNumber());
				employeesModel.setDesignation(employees.getDesignation());
				employeesModel.setDob(employees.getDob());
				employeesModelList.add(employeesModel);
			}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			logger.info("---- In AdminServiceImpl retrieveEmployees method completed ---- ");
		return employeesModelList;
	}
	@Override
	public List<PostModel> retrievePosts() {
		// TODO Auto-generated method stub
		logger.info("---- In AdminServiceImpl retrievePosts method started ---- ");
		List<PostModel> postModelList=new ArrayList<>();
		try {
			List<Posts> postsList=adminDAO.getAllQuestions();
			for(Posts posts:postsList) {
				
				PostModel postModel=new PostModel();
				postModel.setPostId(posts.getPostId());
				postModel.setUserId(posts.getUserId());
				postModel.setPost(posts.getPost());
				postModel.setCategory(posts.getCategory());
				postModelList.add(postModel);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("---- In AdminServiceImpl retrievePosts method completed ---- ");
		return postModelList;
	}

	@Override
	public String deleteQuestion(int postId) {
		logger.info("---- In AdminServiceImpl deleteQuestion method started ---- ");
		System.out.print("input"+postId);
		String result="fail";
		try {
			boolean stored=adminDAO.deleteQuestion(postId);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[deletion failed because of internal issues...]");
		}
		logger.info("---- In AdminServiceImpl deleteQuestion method completed ---- ");
		return result;
}
}
