package com.surveys.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveys.dao.SurveyDAO;
import com.surveys.dao.SurveyDAOImpl;
import com.surveys.domain.Survey;

@WebServlet( urlPatterns = "/submission-record")
@SuppressWarnings("serial")
public class SurveyRecordServlet extends HttpServlet {
  	     
	 SurveyDAO surveyDAO = new SurveyDAOImpl();
	
		    @Override 
		    protected void doGet(
		      
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		       		 
			        RequestDispatcher dispatcher = request.getRequestDispatcher(
			          "/WEB-INF/jsp/submissions.jsp");
			        dispatcher.forward(request, response);		 		        
		    }		 
		  //insert or edit row
		    @Override 
		    protected void doPost(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    	
		       // Connection con = (Connection) getServletContext().getAttribute("DBConnection");
			 // final BookDAO bookDAO = new BookDAOImpl(con);
		     request.setCharacterEncoding("UTF-8");
		     String userEmail =  request.getParameter("email");
		     SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
			 String submissionDate = formatter.format(new Date());
			 String userAgePar = request.getParameter("age");
			 System.out.println(userAgePar);
			 int userAge =(int) Integer.parseInt(userAgePar);
			 String userRegion =  request.getParameter("region");
			 String answers = request.getParameter("Q1ans") + ", " + request.getParameter("Q2ans") + ", " + request.getParameter("Q3ans") + ", " + request.getParameter("Q4ans") + ", " +
					 request.getParameter("Q5ans") + ", " + request.getParameter("Q6ans") + ", " + request.getParameter("Q7ans") + ", " + request.getParameter("Q8ans") + ", " + 
					 request.getParameter("Q9ans") + ", " + request.getParameter("Q10ans");
			 if(!surveyDAO.getAllSubmissions().equals(null)) {
				 //insert
				 Survey surveyNew = new Survey(userEmail, submissionDate, userAge, userRegion, answers);				 
				 surveyDAO.insertSubmission(surveyNew);
			 }	 		
			 response.sendRedirect("/SocialSurveying/");
		    }		    		   
}
