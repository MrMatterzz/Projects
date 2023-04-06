package com.surveys.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext context;
    
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        
        HttpSession session = req.getSession(false);
        
        if(session == null && !(uri.endsWith("html") || uri.endsWith("loginServlet"))){   
            this.context.log("Unauthorized access request");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
        	PrintWriter out= response.getWriter();
            out.println("<font color=red>Unauthorized access request.</font> Please enter your user name and password.");
            dispatcher.include(request, response);            
          //  res.sendRedirect("login.html");   
        }
        else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }      
    }
    public void destroy() {
        //close any resources here
    }
}

