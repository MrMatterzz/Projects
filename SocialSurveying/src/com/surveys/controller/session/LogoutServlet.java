package com.surveys.controller.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     Cookie[] cookies = request.getCookies();
     if(cookies != null){
     for(Cookie cookie : cookies){
      if(cookie.getName().equals("JSESSIONID")){
       System.out.println("JSESSIONID="+cookie.getValue());
       break;
      }
     }
     }
     //invalidate the session if exists
     HttpSession session = request.getSession(false);
     if(session != null){
    	 session.invalidate();
     }
     response.sendRedirect("/SocialSurveying/");
    }
}

