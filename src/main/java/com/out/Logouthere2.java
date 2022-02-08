package com.out;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.RetrieveHere.Retrieve;


public class Logouthere2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logouthere2() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    Retrieve.close();    
		response.sendRedirect(request.getContextPath() + "/LoginAdmin.jsp");
	        
	}

}
