package com.vforum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.PostModel;
import com.vforum.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		 this.adminService=FactoryAdminDB.createAdminService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.contentEquals("viewemployees")) {
		List<EmployeeModel> employeesModelList=adminService.retrieveEmployees();
		request.setAttribute("employeesModelList", employeesModelList);
		
		if(!employeesModelList.isEmpty()) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("viewemployees.jsp");
			dispatcher.forward(request,response);
		}else {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("noemployeedetails.jsp");
			dispatcher.forward(request,response);
		}
		}
		if(action.contentEquals("viewposts"))
		{
			List<PostModel> postModelList=adminService.retrievePosts();
			request.setAttribute("postModelList", postModelList);
			if(!postModelList.isEmpty()) {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("viewposts.jsp");
			
				dispatcher.forward(request,response);
			}else {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("noposts.jsp");
				dispatcher.forward(request,response);
			}
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			int postId=Integer.parseInt(request.getParameter("post_id"));
			
			String outcome=adminService.deleteQuestion(postId);
			request.setAttribute("outcome",outcome);
			if(outcome.contentEquals("success")) {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("viewposts.jsp");
				
			
				dispatcher.forward(request,response);
			}else {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("noposts.jsp");
				dispatcher.forward(request,response);
			}
			}
	}


