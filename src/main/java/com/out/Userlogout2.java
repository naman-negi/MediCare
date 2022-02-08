package com.out;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.u.Productretrieve;

public class Userlogout2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Userlogout2() {
        super();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		    Productretrieve.close();
	        response.sendRedirect(request.getContextPath() + "/LoginAdmin.jsp");
	        
	        
	}

}
