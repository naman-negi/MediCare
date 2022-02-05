package com.RetrieveHere;
import com.controller.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Retrieve {

	
@SuppressWarnings("unchecked")
public List<Medicinal> retrievedata() {
	
	Transaction transaction=null;
	Session session=null;
	List<Medicinal> ls=new ArrayList<Medicinal>();
	try {
	 Configuration configuration=new Configuration().configure("cfg.xml");
	 configuration.addAnnotatedClass(com.controller.Medicinal.class);
	 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	 SessionFactory factory=configuration.buildSessionFactory(builder.build());
	 session =factory.openSession();
	 transaction = session.beginTransaction();
	 ls= new ArrayList<Medicinal>();
	 ls = session.createQuery("from Medicinal").list();
	} catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
return ls;
}

}
