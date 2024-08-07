package com.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class NewHibernateApp {
	public static void main(String[] args) {
		
		LaptopDetails lap = new LaptopDetails();
		lap.setId(101);
		lap.setLaptopName("HP");
	
		Configuration cf = new Configuration().configure().addAnnotatedClass(LaptopDetails.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cf.getProperties()).build();
		
		SessionFactory sf = cf.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(lap);
		
		tx.commit();
		
		
	}
}
