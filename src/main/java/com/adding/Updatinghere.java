package com.adding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.SQLGrammarException;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.controller.Medicinal;

import org.hibernate.cfg.Configuration;

public class Updatinghere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Updatinghere() {
    	super(); 
    	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLGrammarException {
		try {
			Configuration configuration=new Configuration().configure("cfg.xml");	

    	    		
		
				 configuration.addAnnotatedClass(com.controller.Medicinal.class);
				 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				 SessionFactory factory=configuration.buildSessionFactory(builder.build());
				 Session session =factory.openSession();
				 Transaction transaction = null;
				  
			     HttpSession s2=request.getSession(false);

			     String md0=(String)s2.getAttribute("Check");
			         
				 if (!(md0.equals(request.getParameter("productid2")))) {
			     Medicinal md=new Medicinal();
			     transaction = session.beginTransaction(); 
			     md= session.load(Medicinal.class, md0);
			     session.delete(md);
				 transaction.commit();
				 
				
				
				 transaction = session.beginTransaction();


				 md.setProductid(request.getParameter("productid2"));
			     md.setCompany(request.getParameter("company2")); 
			     md.setMedicine_name(request.getParameter("medicine_name2")); 
			     md.setExpiry_date(request.getParameter("expiry_date2" )); 
			     md.setCategory(request.getParameter("category2" )); 
			     md.setDescription(request.getParameter("description2")); 
			     md.setQuantity(request.getParameter("quantity2")); 
			     md.setPrice(request.getParameter("price2")); 
			     md.setImgurl(request.getParameter("imgurl2"));
			     
			     session.save(md); 
				 transaction.commit();
				 session.close();
				 
				 }
				 else {
					 transaction = session.beginTransaction();
					 Medicinal md3=new Medicinal();
				     md3= session.load(Medicinal.class, md0);

				     md3.setCompany(request.getParameter("company2")); 
				     md3.setMedicine_name(request.getParameter("medicine_name2")); 
				     md3.setExpiry_date(request.getParameter("expiry_date2" )); 
				     md3.setCategory(request.getParameter("category2" )); 
				     md3.setDescription(request.getParameter("description2")); 
				     md3.setQuantity(request.getParameter("quantity2")); 
				     md3.setPrice(request.getParameter("price2")); 
				     md3.setImgurl(request.getParameter("imgurl2"));
				     session.save(md3); 
					 transaction.commit();
					 session.close();
				   
					 
				 }
				
				
			     response.sendRedirect(request.getContextPath() + "/AdminDatabase.jsp");  				 
    	    	
			 }	catch(Exception e) {
					System.out.println(e.getMessage()); } 
			 } 
}