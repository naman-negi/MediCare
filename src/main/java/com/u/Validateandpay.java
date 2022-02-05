package com.u;

import java.io.IOException;

import java.util.Date;

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

public class Validateandpay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Validateandpay() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(false);
		
		Configuration configuration=new Configuration().configure("aibernate.cfg.xml");
		configuration.addAnnotatedClass(com.u.User.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		Session session =factory.openSession();

		
		User u=session.load(User.class,((User) s.getAttribute("user")).getUsername());

		if(u.getPurchase()==null) {
			String[] arr2=u.getCart().split(" ");
			
			for(int i=0;i<arr2.length;) {
				Configuration configuration1=new Configuration().configure("cfg.xml");
				configuration1.addAnnotatedClass(com.controller.Medicinal.class);
				StandardServiceRegistryBuilder builder1=new StandardServiceRegistryBuilder().applySettings(configuration1.getProperties());
				SessionFactory factory1=configuration1.buildSessionFactory(builder1.build());
				Session session1 =factory1.openSession();
				Transaction  transaction1 = session1.beginTransaction();

				Medicinal md=session1.load(Medicinal.class,arr2[i]);
				int n=Integer.parseInt(md.getQuantity())-Integer.parseInt(arr2[i+1]);
				md.setQuantity(Integer.toString(n));
				session1.save(md);
				
				transaction1.commit();
				session1.close();
				i=i+2;
				

			}
			Transaction  transaction = session.beginTransaction();

			u.setPurchase(u.getCart());
			u.setCart(null);
			u.setAddress(request.getParameter("address"));
			u.setCarddetail(request.getParameter("cardnumber"));
			Date dt=new Date();
			String str=dt.toString();  
			u.setDateofpurchase(str); 
			session.save(u);
			s.setAttribute("user",(Object)u);
			transaction.commit();
			session.close();
		
			response.sendRedirect(request.getContextPath()+"/ReturnHome.jsp");
		}else {
			
			String[] arr2=u.getCart().split(" ");
			
			for(int i=0;i<arr2.length;) {
				Configuration configuration1=new Configuration().configure("cfg.xml");
				configuration1.addAnnotatedClass(com.controller.Medicinal.class);
				StandardServiceRegistryBuilder builder1=new StandardServiceRegistryBuilder().applySettings(configuration1.getProperties());
				SessionFactory factory1=configuration1.buildSessionFactory(builder1.build());
				Session session1 =factory1.openSession();
				Transaction  transaction1 = session1.beginTransaction();

				Medicinal md=session1.load(Medicinal.class,arr2[i]);
				int n=Integer.parseInt(md.getQuantity())-Integer.parseInt(arr2[i+1]);
				md.setQuantity(Integer.toString(n));
				session1.save(md);
				
				transaction1.commit();
				session1.close();
				i=i+2;
			}
			Transaction  transaction = session.beginTransaction();

			u.setPurchase(u.getPurchase()+" "+u.getCart());
			u.setCart(null);
			u.setAddress(request.getParameter("address"));
			u.setCarddetail(request.getParameter("cardnumber"));
			Date dt=new Date();
			String str=dt.toString();  
			u.setDateofpurchase(str); 
			session.save(u);
			s.setAttribute("user",(Object)u);
			transaction.commit();
			session.close();
			
			response.sendRedirect(request.getContextPath()+"/ReturnHome.jsp"); 
			
		}
	}

}
