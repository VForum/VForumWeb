package com.vforum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.AnswerModel;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.service.EmployeesService;
import com.vforum.service.PostQuestionService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeesService employeeService=null;
	private PostQuestionService postQuestionService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.employeeService=FactoryEmployeeDB.createEmployeesService();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		LoginModel loginModel=new LoginModel();
		if(session!=null) {
			String name=(String)session.getAttribute("username");
			response.getWriter().print(name);
			loginModel.setUserId(name);
		}
		String action=request.getParameter("action");
		if(action.contentEquals("logout"))
		{
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("login.html");
			dispatcher.forward(request,response);
		}
		
		if(action.contentEquals("postquestion")) {
			RequestDispatcher dispatcher1=
					request.getRequestDispatcher("postquestion.jsp");
			dispatcher1.forward(request,response);
		}
		if(action.contentEquals("viewprofile")) {
			List<EmployeeModel> models=employeeService.getProfile(loginModel);
			request.setAttribute("profile",models);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request,response);
		}
		if(action.contentEquals("viewposts"))
		{
			List<PostModel> postModelList=employeeService.retrievePosts();
			request.setAttribute("postModelList", postModelList);
			if(!postModelList.isEmpty()) {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("viewpostsemp.jsp");
			
				dispatcher.forward(request,response);
			}else {
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("noposts.jsp");
				dispatcher.forward(request,response);
			}
		}
			if(action.contentEquals("viewanswers"))
			{
				
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("viewanswers.jsp");
				dispatcher.forward(request,response);
			}
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action=request.getParameter("action");
		
		String username=request.getParameter("user_name");
		String password=request.getParameter("password");
		String firstName=request.getParameter("first_name");
		String lastName=request.getParameter("last_name");
		String phoneNumber=request.getParameter("phone_number");
		String email=request.getParameter("email");
		String designation=request.getParameter("designation");
		String dob=request.getParameter("date");
		RegisterEmployeeModel model=new RegisterEmployeeModel();
		model.setEmployeeUid(username);
		model.setFirstName(firstName);
		model.setPassword(password);
		model.setLastName(lastName);
		model.setEmail(email);
		model.setDob(dob);
		model.setDesignation(designation);
		model.setPhoneNumber(phoneNumber);
		try {
			String outcome=employeeService.registerEmployee(model);
			if(outcome.contentEquals("success")) {
				RequestDispatcher dispatcher=
						request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request,response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
