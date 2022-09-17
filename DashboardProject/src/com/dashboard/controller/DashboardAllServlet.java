package com.dashboard.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dashboard.dao.DashboardDAO;
import com.dashboard.dao.DashboardDAOImpl;
import com.dashboard.domain.Course;

@WebServlet( urlPatterns = "/courses")
@SuppressWarnings("serial")
public class DashboardAllServlet extends HttpServlet {
		 
	       DashboardDAO courseDAO = new DashboardDAOImpl();
	       private static String COURSES = "/WEB-INF/jsp/courses.jsp";	       
	       private static String COURSE_RECORD =  "/WEB-INF/jsp/course-record.jsp";	    
		 
		    //all
		    @Override 
		    protected void doGet(
		      HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
		    	   HttpSession session=request.getSession(false);
			       request.setAttribute("session",session);
		    	   String accountType="";
		    	   String id="";
		    	   String login="";
			       Cookie[] cookies=request.getCookies();			       
			       if(cookies!=null)
			       for(Cookie cookie: cookies) {
			    	   if(cookie.getName().equals("accountType")) accountType=cookie.getValue();
			    	   if(cookie.getName().equals("asCrsId")) id=cookie.getValue();
			    	   if(cookie.getName().equals("loginName")) login=cookie.getValue();
			       }
			       String forward="";
			       String action = request.getParameter("action");	
			       request.setAttribute("UserName", login);
			        if (action == null) {
			        	if(accountType.equals("Admin")) {
			        		forward = COURSES;			         
			        		List<Course> courses = courseDAO.getAllCourses();

			        		if (!courses.isEmpty()) {
			        			request.setAttribute("courseAll", courses);				  			    
			        		}
			        	}
			        	else if(accountType.equals("Student") || accountType.equals("Professor")){
			        		forward = COURSES;
			        		List<Course> courses = courseDAO.getCourseByUserCourseId(id);
			        		if (!courses.isEmpty()) {
			        			request.setAttribute("courseAll", courses);
			        		}
			        	}
			        }
			        else {
					        if (action.equalsIgnoreCase("delete")){
					         	String courseId =  request.getParameter("courseID");	
								courseDAO.deleteCourse(courseId);
					            forward = COURSES;
					            List<Course> courses = courseDAO.getAllCourses();
					            if(accountType.equals("Admin")) {
					            courses = courseDAO.getAllCourses();}
					            else {
					            	courses = courseDAO.getAllCoursesById(id);
					            	}						    	
						        if (!courses.isEmpty()) {		
						            request.setAttribute("courseAll", courses);						  			    
						        }
					        } else if (action.equalsIgnoreCase("edit")){
					            forward = COURSE_RECORD;
					            String courseId =  request.getParameter("courseID");	
					            List<Course> course = courseDAO.getCourseByUserCourseId(courseId);
					            request.setAttribute("course", course);		
					        } 
			        }			       
			        RequestDispatcher view = request.getRequestDispatcher(forward);
			        view.forward(request, response);		        
		    }		 		 
}
