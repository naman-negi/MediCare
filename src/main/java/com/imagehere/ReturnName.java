package com.imagehere;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.controller.Medicinal;

/**
 * Servlet implementation class ReturnName
 */
public class ReturnName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    Configuration configuration=new Configuration().configure("cfg.xml");	    
		
		    HttpSession s=request.getSession(false);
		    
			configuration.addAnnotatedClass(com.controller.Medicinal.class);

			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			Session session =factory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Medicinal medicinal = session.load(Medicinal.class, (String) s.getAttribute("productid6"));
			
			medicinal.setImgurl((String) s.getAttribute("filename"));
			
			session.save(medicinal);
			
			transaction.commit();
			
			session.close();
			factory.close();
			
		    response.sendRedirect(request.getContextPath() + "/AdminDatabase.jsp");  


		
	}

}
