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

public class Cartupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cartupdate() {
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

			if((User)s.getAttribute("user")!=null){

				String[] arr=request.getParameter("quantity").split(" ");

				User u1=session.load(User.class,((User)s.getAttribute("user")).getUsername());


				if (u1.getCart()==null) {
					Transaction transaction = session.beginTransaction();
					u1.setCart(arr[0]+" "+arr[1]);
					session.save(u1);
					transaction.commit();
					session.close();


				}

				else {

					String[] arr2=u1.getCart().split(" ");
					int n =arr2.length;
					String str=null;

					try { 

						for (int i=0; i<=(n-1); ) {

							if (i==0) {
								str=arr2[0]+" ";

								if(arr[0].equals(arr2[i])) {
									i=i+1;	   
									if(i==(n-1)) {

										Transaction  transaction = session.beginTransaction();
										str=str+arr[1];
										u1.setCart(str);   
										session.save(u1);
										transaction.commit();
										session.close();


									}

									str=str+arr[1]+" ";

									i=i+1;

									while(i<n) {

										if(i==(n-1)) 


										{
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
								i=i+1;
							}
							if(arr[0].equals(arr2[i])) {
								str=str+arr2[i]+" ";
								i=i+1;

								if(i==(n-1)) 
								{
									Transaction  transaction = session.beginTransaction();

									str=str+arr[1];

									u1.setCart(str);   
									session.save(u1);
									transaction.commit();
									session.close();


								}

								str=str+arr[1]+" ";
								i=i+1;

								while(i<n) {

									if(i==(n-1)) 


									{
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

							if (i==(n-1)) {

								str=str+arr2[i]+" "+arr[0]+" "+arr[1];
								Transaction  transaction = session.beginTransaction();
								u1.setCart(str);
								session.save(u1);
								transaction.commit();
								session.close();
								s.setAttribute("user",(Object)u1);
								response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);

							}else 

							{
								str=str+arr2[i]+" ";
							}

							i=i+1;




						}
					}catch(Exception e){
						System.out.println(e.getMessage());
						s.setAttribute("user",(Object)u1);
						response.sendRedirect(request.getContextPath()+"/"+arr0[(arr0.length)-1]);  
					}


				}

			}

			else {

				PrintWriter pwriter=null;
				pwriter=response.getWriter();       
				RequestDispatcher dis=request.getRequestDispatcher("LoginUser.jsp");
				dis.include(request, response);
				pwriter.print("In order to add to cart you have to login.");

			}
		
			
		}
	}
