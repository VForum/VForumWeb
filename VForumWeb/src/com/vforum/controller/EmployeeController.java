package com.vforum.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.service.EmployeesService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeesService employeeService=null;
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user_name");
		String password=request.getParameter("password");
		String firstName=request.getParameter("user_name");
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
