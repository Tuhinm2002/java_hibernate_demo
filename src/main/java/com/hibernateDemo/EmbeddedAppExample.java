package com.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class EmbeddedAppExample {

	public static void main(String[] args) {
		
		StudentName stName = new StudentName();
		stName.setFirstName("Tuhin");
		stName.setLastName("Mondal");
		
		LaptopDetails lap = new LaptopDetails();
		lap.setId(101);
		lap.setLaptopName("HP");
		
		StudentDB stdb = new StudentDB();
		stdb.setColor("sky");
		stdb.setName(stName);
		stdb.setId(1);
		stdb.setLaptopDetails(lap);
		
		
		Configuration cf = new Configuration().configure().addAnnotatedClass(StudentDB.class).addAnnotatedClass(LaptopDetails.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cf.getProperties()).build();
		
		SessionFactory sf = cf.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(lap);
		session.save(stdb);
		
		tx.commit();
		
		StudentDB val = (StudentDB)session.get(StudentDB.class, 1);
		
		System.out.println("Value entered");
		System.out.println(val.toString());	
		
		
	}
}
