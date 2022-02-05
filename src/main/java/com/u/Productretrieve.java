package com.u;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



import com.controller.Medicinal;

public class Productretrieve {

	public Medicinal productretrieve(String str) {
		
	     
	     Medicinal md=new Medicinal();

		 Configuration configuration=new Configuration().configure("cfg.xml");
		 configuration.addAnnotatedClass(com.controller.Medicinal.class);
		 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		 SessionFactory factory=configuration.buildSessionFactory(builder.build());

		 Session session =factory.openSession();
		 md=session.load(Medicinal.class,str);
	return md;
	}
}
