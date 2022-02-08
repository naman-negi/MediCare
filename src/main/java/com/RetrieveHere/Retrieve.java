package com.RetrieveHere;
import com.controller.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

public class Retrieve {
	private static Configuration configuration= new Configuration().configure("cfg.xml");
	static{
		new Configuration().configure("cfg.xml");
	}
	  private static SessionFactory factory;
	    static {
	          factory =configuration.buildSessionFactory();
	    }
	
	    public Medicinal productretrieve1(String str) {
	    	
	    	 Session session =getSession();
	    	 Medicinal md=new Medicinal();
	    	 md=session.load(Medicinal.class,str);
	    	 doWork();
	    	 return md;
	    	 
	    }
@SuppressWarnings("unchecked")
public List<Medicinal> retrievedata() {
	
	
	Session session =getSession();
	
	List<Medicinal> ls=new ArrayList<Medicinal>();
	
	try {
	
	 configuration.addAnnotatedClass(com.controller.Medicinal.class);
	
	 session =getSession();

	 ls= new ArrayList<Medicinal>();
	 ls = session.createQuery("from Medicinal").list();
	} catch (Exception e) {
   
        e.printStackTrace();
    } finally {
       doWork();
    }
return ls;
}

public Session getSession() {
    return factory.openSession();
}

public void doWork() {
   Session session = getSession();

   session.close();
}

// Call this during shutdown
public static void close() {
  factory.close();
}

}
