package com.deletion;

import com.controller.Medicinal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.SQLGrammarException;

public class Del extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
    public Del() {super(); }
    
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLGrammarException {
		try {
       
		Configuration configuration=new Configuration().configure("cfg.xml");	    
		configuration.addAnnotatedClass(com.controller.Medicinal.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    SessionFactory factory=configuration.buildSessionFactory(builder.build());
	    Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		
	    Medicinal medicinal = session.load(Medicinal.class, request.getParameter("product1"));
		session.delete(medicinal);
	    transaction.commit();
	    session.close();
	    response.sendRedirect(request.getContextPath() + "/AdminDatabase.jsp");
	
    }catch(Exception e) {
		System.out.println(e.getMessage()); }
	}
}
