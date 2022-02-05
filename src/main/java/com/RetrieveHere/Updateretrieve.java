package com.RetrieveHere;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.controller.Medicinal;

public class Updateretrieve {
	public Medicinal dataretrieve(String str) {
		
		Transaction transaction=null;
		Session s1=null;
		
		Medicinal md=new Medicinal();
		try{
		Configuration configuration=new Configuration().configure("cfg.xml");
		 configuration.addAnnotatedClass(com.controller.Medicinal.class);
		 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		 SessionFactory factory=configuration.buildSessionFactory(builder.build());
		 s1 =factory.openSession();
		 transaction = s1.beginTransaction();
		 
		 md= s1.load(Medicinal.class, str);
		
		} catch (Exception e) {
	       if (transaction != null) {
	           transaction.rollback();
	       }
	       e.printStackTrace();
	   } 
		return md;
	}
}
