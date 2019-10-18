package com.vforum.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;
import com.vforum.service.PostAnswerService;


/**
 * Servlet implementation class PostAnswerController
 */
@WebServlet("/postanswer")
public class PostAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostAnswerService postAnswerService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnswerController() {
        super();
        // TODO Auto-generated constructor stub
        this.postAnswerService=FactoryEmployeeDB.createAnswerService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postid=Integer.parseInt(request.getParameter("postid"));
		String answer=request.getParameter("textarea");
		PostAnswerModel postAnswerModel=new PostAnswerModel();
		
		postAnswerModel.setPostId(postid);
		postAnswerModel.setAnswer(answer);
		String username=(String)request.getAttribute("username");
		
		response.getWriter().print(username);
		HttpSession session=request.getSession(false);
		LoginModel loginModel=new LoginModel();
		if(session!=null) {
			String name=(String)session.getAttribute("username");
			response.getWriter().print(name);
			loginModel.setUserId(name);
		}
		try {
			String outcome=postAnswerService.postAnswer(postAnswerModel,loginModel);
			if(outcome.contentEquals("success")) {
				RequestDispatcher dispatcher1=
						request.getRequestDispatcher("employee.jsp");
				dispatcher1.forward(request,response);
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

