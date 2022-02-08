package com.u;

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

public class Cartdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cartdelete() {
		super();
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s = request.getSession(false);

		Configuration configuration=new Configuration().configure("aibernate.cfg.xml");
		configuration.addAnnotatedClass(com.u.User.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		Session session =factory.openSession();

		String str2 = request.getHeader("referer");
		String[] arr0 = str2.split("/");

		User u1=session.load(User.class,((User)s.getAttribute("user")).getUsername());

		String[] arr2=u1.getCart().split(" ");
		String str;
		str=arr2[0]+" ";

		try {
		for(int i=0;i<arr2.length;)
		{
			if(request.getParameter("delete").equals(arr2[i])) {

				if(i==0) {

					if(i==(arr2.length-2)) {
						Transaction  transaction = session.beginTransaction();
						u1.setCart(null);
						session.save(u1);
						transaction.commit();
						session.close();
						
					}
				
					i=i+2;
						str=arr2[i]+" ";
						i=i+1;
						for(;i<arr2.length;) {

							if(i==(arr2.length-1)) {

								Transaction  transaction = session.beginTransaction();

								str=str+arr2[i];
								u1.setCart(str);
								session.save(u1);
								transaction.commit();
								session.close();
							
							}
							str=str+arr2[i]+" ";
							i=i+1;
						}
					
				}

				else {
				
				

					if(i==(arr2.length-2)) {
						Transaction  transaction = session.beginTransaction();
						u1.setCart(str);
						session.save(u1);
						transaction.commit();
						session.close();

						
					}
				
					i=i+2;
					str=str+arr2[i]+" ";
					i=i+1;
					for(;i<arr2.length;) {

						if(i==(arr2.length-1)) {

							Transaction  transaction = session.beginTransaction();
							str=str+arr2[i];
							u1.setCart(str);
							session.save(u1);
							transaction.commit();
							session.close();
							s.setAttribute("user",(Object)u1);

						


						}
						str=str+arr2[i]+" ";
						i=i+1;
					}
				
				}
			}
		

				if(i==0) {
					i=i+1;
				}

				if(i==(arr2.length-1)) {

					str=str+arr2[i];

				}else {

					str=str+arr2[i]+" ";
					i=i+1;

				}
			
			

		}
		}catch(Exception e) {
	    System.out.println(e.getMessage());
		s.setAttribute("user",(Object)u1);
		factory.close();
		response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);
		}


	}

}
