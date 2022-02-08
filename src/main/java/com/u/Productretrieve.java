package com.u;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



import com.controller.Medicinal;

public class Productretrieve {

    private static SessionFactory factory;
    static {
          factory = new Configuration().configure("cfg.xml").buildSessionFactory();
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

    	 ls= new ArrayList<Medicinal>();
    	 ls = session.createQuery("from Medicinal").list();
    	 doWork();
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



