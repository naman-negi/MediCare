package com.u;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Existinguser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Existinguser() {
        super();
       }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Configuration configuration=new Configuration().configure("aibernate.cfg.xml");
	    configuration.addAnnotatedClass(com.u.User.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		Session session =factory.openSession();
		
	    User u=session.load(User.class, request.getParameter("username"));
	    
	    try {
	    String str=u.getPassword();
		if(!(str.equalsIgnoreCase(request.getParameter("password")))){
			 session.close();
			 PrintWriter pwriter=null;
			 pwriter=response.getWriter();       
			 RequestDispatcher dis=request.getRequestDispatcher("LoginUser.jsp");
			 dis.include(request, response);
	         pwriter.print("Password don't match.");
		}else {
			HttpSession s=request.getSession(false);
			s.setAttribute("user", u);
			response.sendRedirect(request.getContextPath() + "/Generalhome.jsp");  		
			}
	    }
	    catch(Exception e) {
			System.out.println(e.getMessage());
			session.close();
	    	 PrintWriter pwriter=null;
			 pwriter=response.getWriter();       
			 RequestDispatcher dis=request.getRequestDispatcher("LoginUser.jsp");
			 dis.include(request, response);
	         pwriter.print("Sorry Username doesnt exist."); 
			} 
	    
	}
}
