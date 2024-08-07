package com.hibernateDemo;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateApp {

	public static void main(String[] args) {
		StudentDB st = new StudentDB();
		
		try {
        st.setId(3);
//        st.setName("ishita");
        st.setColor("pink");
        }
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Items already exists");
//			System.out.println(e);
		}

        Configuration cf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentDB.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cf.getProperties()).build();
        
        SessionFactory sf = cf.buildSessionFactory(reg);

        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(st);
        
        tx.commit();
	}
}
