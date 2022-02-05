package com.imagehere;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.controller.Medicinal;



public class ReturnName {
	public ReturnName(String str,String str2) {


		Configuration configuration=new Configuration().configure("cfg.xml");	
		configuration.addAnnotatedClass(com.controller.Medicinal.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		Session session =factory.openSession();
		Transaction transaction = session.beginTransaction();
		Medicinal medicinal = session.load(Medicinal.class, str2);
		medicinal.setImgurl(str);
		session.save(medicinal);
		transaction.commit();
		session.close();

	}
}

