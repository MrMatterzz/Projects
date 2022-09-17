package com.dashboard.controller.session;

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

import com.dashboard.dao.UserDAO;
import com.dashboard.dao.UserDAOImpl;
import com.dashboard.domain.User;


@WebServlet( urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAOImpl();
    
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
        
        User userDB = userDAO.getUserByNameAndPassword(login, pwd);
        
        if(userDB != null){       	
            String accountType=userDB.getAccountType();
            String asCourseID=userDB.getAssignedCourse();
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            Cookie accountName = new Cookie("accountType", accountType);
            Cookie courseID = new Cookie("asCrsId", asCourseID);
            Cookie loginName = new Cookie("loginName", login);
            accountName.setMaxAge(30*60);
            courseID.setMaxAge(30*60);
            response.addCookie(accountName);
            response.addCookie(courseID);
            response.addCookie(loginName);
            response.sendRedirect("/DashboardProject/courses");
        }else{
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
        	PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            dispatcher.include(request, response);
        }
    }
}
