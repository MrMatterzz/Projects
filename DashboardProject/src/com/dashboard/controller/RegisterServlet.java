package com.dashboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dashboard.dao.UserDAO;
import com.dashboard.dao.UserDAOImpl;
import com.dashboard.domain.User;

@WebServlet( urlPatterns = "/registerServlet")
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
  	     
	 UserDAO userDAO = new UserDAOImpl();
		    @Override 
		    protected void doGet(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
			        RequestDispatcher dispatcher = request.getRequestDispatcher(
			          "/WEB-INF/jsp/register.jsp");
			        dispatcher.forward(request, response);
		    }
		 
		  //insert or edit row
		    @Override 
		    protected void doPost(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    	
		       // Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			 // final BookDAO bookDAO = new BookDAOImpl(con);
		    	
		     String id =  request.getParameter("id");
		     String login =  request.getParameter("login");
			 String pwd =  request.getParameter("pwd");
			 String accountType = request.getParameter("accountcode");
			 String assignedCourseID = request.getParameter("assignedCourseID");
			 System.out.println(id);
			 if(accountType.equals("STDInV2019")) {
				 accountType = "Student";
				 System.out.println(accountType);
			 }
			 else if(accountType.equals("PrOFInV2019")) {
				 accountType = "Professor";
			 }
			 else if(accountType.equals("DshBPrJAdMMNN")) {
				 accountType = "Admin";
			 }			 
			 if(id == null || id.length() == 0) {
				 //insert
				 System.out.println(id);
				 User userNew = new User(login, pwd, accountType, assignedCourseID);				 
				 userDAO.insertUser(userNew);
			 }			 
			response.sendRedirect("index.html");		     
		    }
}
