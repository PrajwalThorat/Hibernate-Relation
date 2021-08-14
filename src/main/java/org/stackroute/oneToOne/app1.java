package org.stackroute.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class app1 {

	public static void main(String[] args) {
	
		try {
			
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Employee.class).configure();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setEmployeeId(101);
			employee.setEmployeeName("SuperMan");
			employee.setEmployeeCity("DC");
			
			
			Laptop laptop = new Laptop();
			laptop.setId(1);
			laptop.setModel("vivibook15");
			laptop.setBrand("Asus");
			
			
			employee.setLaptop(laptop);
			laptop.setEmployee(employee);
			
			session.save(laptop);
			session.save(employee);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
