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
import com.vforum.model.PostQuestionModel;
import com.vforum.service.PostQuestionService;

/**
 * Servlet implementation class PostQuestionController
 */
@WebServlet("/postquestion")
public class PostQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostQuestionService postQuestionService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostQuestionController() {
        super();
        this.postQuestionService=FactoryEmployeeDB.createQuestionService();
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
		String question=request.getParameter("textarea");
		String title=request.getParameter("category");
		PostQuestionModel postQuestionModel=new PostQuestionModel();
		postQuestionModel.setPost(question);
		postQuestionModel.setTitle(title);
		String username=(String)request.getAttribute("username");
		
		response.getWriter().print(username);
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String name=(String)session.getAttribute("username");
			response.getWriter().print(name);
			postQuestionModel.setUserId(name);
		}
		try {
			String outcome=postQuestionService.postQuestion(postQuestionModel);
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
