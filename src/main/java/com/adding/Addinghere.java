package com.adding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.SQLGrammarException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.controller.Medicinal;

import org.hibernate.cfg.Configuration;

public class Addinghere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Addinghere() {
    	super(); 
    	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLGrammarException {
		try {
			Configuration configuration=new Configuration().configure("cfg.xml");	
		     Medicinal md=new Medicinal();
		     
		     String str2 = request.getHeader("referer");
		     String[] arr0 = str2.split("/");

    	 
    	    		
		
				 configuration.addAnnotatedClass(com.controller.Medicinal.class);
				 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				 SessionFactory factory=configuration.buildSessionFactory(builder.build());
				 Session session =factory.openSession();
				 Transaction transaction = session.beginTransaction();
			     md.setProductid(request.getParameter("productid")); 
			     md.setCompany(request.getParameter("company")); 
			     md.setMedicine_name(request.getParameter("medicine_name")); 
			     md.setExpiry_date(request.getParameter("expiry_date")); 
			     md.setCategory(request.getParameter("category")); 
			     md.setDescription(request.getParameter("description")); 
			     md.setQuantity(request.getParameter("quantity")); 
			     md.setPrice(request.getParameter("price")); 
			     md.setImgurl(null); 

				
				
				 session.save(md); 
				 transaction.commit();
				 session.close();
			
					response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);  
				 
    	    	
			 }	catch(Exception e) {
					System.out.println(e.getMessage()); } 
			 } 
}