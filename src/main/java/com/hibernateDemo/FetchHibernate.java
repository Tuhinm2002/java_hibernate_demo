package com.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class FetchHibernate {

	public static void main(String[] args) {
		
		StudentDB tuhin = new StudentDB();
		
		Configuration con = new Configuration().configure().addAnnotatedClass(StudentDB.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		tuhin = (StudentDB)session.get(StudentDB.class, 1);
		
		tx.commit();
		
		System.out.println(tuhin);
	}
}
