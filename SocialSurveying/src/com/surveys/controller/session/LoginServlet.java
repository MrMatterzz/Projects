package com.surveys.controller.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet( urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(
		          "login.html");
		        dispatcher.forward(request, response);
    }
    

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        
        if(login.contentEquals("Admin") && pwd.contentEquals("Admin1234")){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            Cookie loginName = new Cookie("loginName", login);
            loginName.setMaxAge(30*60);
            response.addCookie(loginName);
            response.sendRedirect("/SocialSurveying/submissions");
        }else{
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
        	PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            dispatcher.include(request, response);
        }

    }

}
