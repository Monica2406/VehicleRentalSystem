package com.vehicleRental.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vehiclerental.model.Customer;

public class CustomerMain {
	public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Customer.class);
        SessionFactory factory = config.buildSessionFactory();
        
        Session session = factory.openSession();

        // Creating a new customer
        Customer customer = new Customer("John Doe", "john@example.com", "9876543210");

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        
        session.close();
        factory.close();
        
        System.out.println("Customer Added Successfully!");
    }
}
