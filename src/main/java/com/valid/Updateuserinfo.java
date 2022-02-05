package com.valid;

import com.u.*;

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

public class Updateuserinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Updateuserinfo() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Configuration configuration=new Configuration().configure("aibernate.cfg.xml");
    configuration.addAnnotatedClass(com.u.User.class);
	StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	SessionFactory factory=configuration.buildSessionFactory(builder.build());
	Session session =factory.openSession();
		
    User md=new User();

	Transaction transaction = session.beginTransaction();
    md.setUsername(request.getParameter("username")); 
    md.setPassword(request.getParameter("password")); 
    md.setAddress(request.getParameter("address")); 
    md.setCarddetail(request.getParameter("carddetail")); 
    md.setDateofpurchase(request.getParameter("dateofpuchase")); 
    md.setCart(request.getParameter("cart")); 
    md.setPurchase(request.getParameter("purchase")); 
    
    session.save(md);
    transaction.commit();
    session.close();
    response.sendRedirect(request.getContextPath() + "/LoginUser.jsp");  
	}

}
