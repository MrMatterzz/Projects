package com.dashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dashboard.dao.DashboardDAO;
import com.dashboard.dao.DashboardDAOImpl;
import com.dashboard.domain.Course;

@WebServlet( urlPatterns = "/course-record")
@SuppressWarnings("serial")
public class DashboardRecordServlet extends HttpServlet {
  	     
	 DashboardDAO dashboardDAO = new DashboardDAOImpl();
	
		    @Override 
		    protected void doGet(
		      
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		       		 
			        RequestDispatcher dispatcher = request.getRequestDispatcher(
			          "/WEB-INF/jsp/course-record.jsp");
			        dispatcher.forward(request, response);		 		        
		    }		 
		  //insert or edit row
		    @Override 
		    protected void doPost(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    	
		     String courseId =  request.getParameter("courseID");
		     String title =  request.getParameter("title");
			 String professor =  request.getParameter("professor");
			 String description =  request.getParameter("description");
			 if(!dashboardDAO.getAllCoursesById(courseId).equals(null)) {
				 //insert
				 Course courseNew = new Course(courseId, title, professor, description);				 
				 dashboardDAO.insertCourse(courseNew);
			 }else {
				 //update
				 Course courseEdit = new Course(courseId, title, professor, description);				 
				 dashboardDAO.updateCourse(courseEdit);
			 }			 		
			 response.sendRedirect("/DashboardProject/courses");
		    }		    		   
}
