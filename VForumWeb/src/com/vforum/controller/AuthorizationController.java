package com.vforum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.service.LoginService;

/**
 * Servlet implementation class AuthorizationController
 */
@WebServlet("/login")
public class AuthorizationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.loginService=FactoryEmployeeDB.createLoginService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("servlet get");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 //PrintWriter out = response.getWriter();
		LoginModel loginModel=new LoginModel();
		loginModel.setUserId(username);
		loginModel.setPassword(password);
	
				String outcome=null;
				try {
					outcome = loginService.userAuthenticationService(loginModel);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(outcome.contentEquals("EMPLOYEE")){
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("employee.html");
					dispatcher.forward(request,response);
				}
				else if(outcome.contentEquals("ADMIN")){
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("admin.html");
					dispatcher.forward(request,response);
				}
				else {
					RequestDispatcher dispatcher=
							request.getRequestDispatcher("error.html");
					dispatcher.forward(request,response);
				}		
		}
	}
	


