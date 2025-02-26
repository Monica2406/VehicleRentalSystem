package com.vehicleRental.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vehiclerental.model.Vehicle;

public class Main {
    public static void main(String[] args) {
        // Load Hibernate Configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Vehicle.class); // Add annotated class
        SessionFactory factory = config.buildSessionFactory();
        
        // Open Session
        Session session = factory.openSession();
        
        // Create Vehicle object
        Vehicle vehicle = new Vehicle("Toyota Corolla", "Toyota", 2500.0, true); // Using constructor

        // Start Transaction
        session.beginTransaction();
        
        // Save Vehicle to DB
        session.save(vehicle);
        
        // Commit Transaction
        session.getTransaction().commit();
        
        // Close Session
        session.close();
        factory.close();
        
        System.out.println("Record Saved Successfully!!");
    }
}
