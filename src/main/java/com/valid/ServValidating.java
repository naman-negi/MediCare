package com.valid;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.exception.SQLGrammarException;


import org.hibernate.cfg.Configuration;

public class ServValidating extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServValidating() {super(); }
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLGrammarException {
		try {
			Configuration configuration=new Configuration().configure("cfg.xml");	
    	    HttpSession s=request.getSession(false);

		     if(request.getParameter("username").equalsIgnoreCase(configuration.getProperty("hibernate.connection.username"))&&request.getParameter("password").equalsIgnoreCase((configuration.getProperty("hibernate.connection.password")))) 
		     {
		    		s.setAttribute("username",(Object)request.getParameter("username") );
					s.setAttribute("password",(Object)request.getParameter("password") );
				
					response.sendRedirect(request.getContextPath() + "/AdminDatabase.jsp");  
 
			 } 
		     
			 else {
				 PrintWriter pwriter=null;
				 pwriter=response.getWriter();       
				 RequestDispatcher dis=request.getRequestDispatcher("LoginAdmin.jsp");
				 dis.include(request, response);
		         pwriter.print("User name or password is incorrect!");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()); } } }

