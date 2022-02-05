

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
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Cartupdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cartupdate2() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession s=request.getSession(false);

		String str2 = request.getHeader("referer");
		String[] arr0 = str2.split("/");


		if((User)s.getAttribute("user")!=null){
			Configuration configuration=new Configuration().configure("aibernate.cfg.xml");
			configuration.addAnnotatedClass(com.u.User.class);
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			Session session =factory.openSession();


			User u1=session.load(User.class,((User)s.getAttribute("user")).getUsername());



			if (u1.getCart()==null) {
				Transaction transaction = session.beginTransaction();
				u1.setCart(request.getParameter("productid5")+" "+ "1");
				session.save(u1);
				transaction.commit();
				session.close();
				s.setAttribute("user",(Object)u1);
				response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);

			}

			else {


				String[] arr2=u1.getCart().split(" ");
				int n =arr2.length;
				String str=arr2[0]+" ";
				int i=0;


				while((String)s.getAttribute("Done")==null) {

					if(i!=n) {
						if(request.getParameter("productid5").equals(arr2[i])) {
							if(((i==0)&&i==(n-2))&&(String)s.getAttribute("Done")==null) {
								i=i+1;

								Transaction  transaction = session.beginTransaction();
								str=str+Integer.toString((1+Integer.parseInt(arr2[i])));
								u1.setCart(str);   
								session.save(u1);
								transaction.commit();
								session.close();
								s.setAttribute("user",(Object)u1);
								s.setAttribute("Done", (Object)"Done");

							}							
							if(i==0&&i!=(n-2)) {


								i=i+1;
								str=str+Integer.toString((1+Integer.parseInt(arr2[i])))+" ";

								i=i+1;

								while((String)s.getAttribute("Done")==null) {

									if(i==(n-1)) 


									{
										Transaction  transaction = session.beginTransaction();
										str=str+arr2[i];
										u1.setCart(str);   
										session.save(u1);
										transaction.commit();
										session.close();
										s.setAttribute("user",(Object)u1);
										s.setAttribute("Done", (Object)"Done");
										break;
									}

									str=str+arr2[i]+" ";  
									i=i+1;   

								}


							}
							if(i!=0&&i<(n-2)) {
								int m=1;
								while(((String)s.getAttribute("Done")==null)) {
									str=str+arr2[m]+" ";
									m=m+1;

									if(m==i) {
										str=str+arr2[i]+" ";
										i=i+1;

										str=str+Integer.toString((1+Integer.parseInt(arr2[i])))+" ";

										i=i+1;
										while((String)s.getAttribute("Done")==null) {

											if(i==(n-1)) 


											{
												Transaction  transaction = session.beginTransaction();
												str=str+arr2[i];
												u1.setCart(str);   
												session.save(u1);
												transaction.commit();
												session.close();
												s.setAttribute("user",(Object)u1);
												s.setAttribute("Done", (Object)"Done");
												break;

											}

											str=str+arr2[i]+" ";  
											i=i+1; 

										}
									}
								}

							}			

							else{
								int m=1;
								while(((String)s.getAttribute("Done")==null)) {
									str=str+arr2[m]+" ";
									m=m+1;
									if(m==(n-2)) {
										Transaction  transaction = session.beginTransaction();
										str=str+arr2[i]+" ";
										i=i+1;
										str=str+Integer.toString((1+Integer.parseInt(arr2[i])));
										u1.setCart(str);   
										session.save(u1);
										transaction.commit();
										session.close();
										s.setAttribute("user",(Object)u1);
										s.setAttribute("Done", (Object)"Done");
									}
								}
							}
						}

					}
					else{

						int m=1;
						String str3=arr2[0]+" ";
						if(i==n) {
							while(((String)s.getAttribute("Done")==null)) {
								str3=str3+arr2[m]+" ";
								m=m+1;
								if(m==n) {
									Transaction  transaction = session.beginTransaction();
									str3=str3+request.getParameter("productid5")+" "+"1";
									u1.setCart(str3);   
									session.save(u1);
									transaction.commit();
									session.close();
									s.setAttribute("user",(Object)u1);
									s.setAttribute("Done", (Object)"Done");

								}
							}
						}



					}



					if(((String)s.getAttribute("Done"))!=null){
						break;
					}

					i=i+1;

				}


				s.removeAttribute("Done");
				response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);

			}

		}else {

			PrintWriter pwriter=null;
			pwriter=response.getWriter();       
			RequestDispatcher dis=request.getRequestDispatcher("LoginUser.jsp");
			dis.include(request, response);
			pwriter.print("In order to add to cart you have to login.");

		}
	}
}








