package com.valid;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Passvalidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Passvalidate() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(!(request.getParameter("password").equals(request.getParameter("password2")))) {
		 PrintWriter pwriter=null;
		 pwriter=response.getWriter();       
		 RequestDispatcher dis=request.getRequestDispatcher("SignupUser.jsp");
		 dis.include(request, response);
         pwriter.print("Password don't match.");
	}
	else {
	    request.getRequestDispatcher("Updateuserinfo").forward(request,response);	}
}
}