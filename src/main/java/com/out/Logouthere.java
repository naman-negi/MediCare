package com.out;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logouthere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Logouthere() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession s3=request.getSession(false);
		if(s3.getAttribute("username")!=null) {
		
		    request.getSession().invalidate();
		
	        response.sendRedirect(request.getContextPath() + "/LoginAdmin.jsp");
	        }
	}

}
