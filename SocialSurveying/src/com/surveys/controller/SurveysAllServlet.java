package com.surveys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surveys.dao.SurveyDAO;
import com.surveys.dao.SurveyDAOImpl;
import com.surveys.domain.Survey;

@WebServlet( urlPatterns = "/submissions")
@SuppressWarnings("serial")
public class SurveysAllServlet extends HttpServlet {
		 
	       SurveyDAO surveyDAO = new SurveyDAOImpl();
	       private static String SUBMISSIONS = "/WEB-INF/jsp/submissions.jsp";  
		 
		    //all
		    @Override 
		    protected void doGet(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    	   HttpSession session=request.getSession(false);
			       request.setAttribute("session",session);
		    	   String login="";
			       Cookie[] cookies=request.getCookies();			       
			       if(cookies!=null)
			       for(Cookie cookie: cookies) {
			    	   if(cookie.getName().equals("loginName")) login=cookie.getValue();
			       }	
			       request.setAttribute("UserName", login);	 			         
			        		List<Survey> surveys = surveyDAO.getAllSubmissions();

			        		if (!surveys.isEmpty()) {
			        			request.setAttribute("submissionAll", surveys);				  			    
			        		}			  		       
			        RequestDispatcher view = request.getRequestDispatcher(SUBMISSIONS);
			        view.forward(request, response);		        			        		 		 
		    }
}