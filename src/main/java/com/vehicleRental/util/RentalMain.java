package com.vehicleRental.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import vehiclerental.model.Rental;
import vehiclerental.model.Vehicle;
import vehiclerental.model.Customer;
import java.util.Date;

public class RentalMain {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Rental.class);
        config.addAnnotatedClass(Vehicle.class);
        config.addAnnotatedClass(Customer.class);
        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();

        // Fetch existing vehicle and customer
        Vehicle vehicle = session.get(Vehicle.class, 1); // Assuming vehicle ID = 1
        Customer customer = session.get(Customer.class, 1); // Assuming customer ID = 1

        if (vehicle != null && customer != null && vehicle.isAvailable()) {
            // Calculate total cost (e.g., for 3 days)
            double totalCost = vehicle.getPricePerDay() * 3;

            // Create Rental object
            Rental rental = new Rental(vehicle, customer, new Date(), new Date(), totalCost);
            vehicle.setAvailable(false); // Mark vehicle as rented

            session.beginTransaction();
            session.save(rental);
            session.update(vehicle);
            session.getTransaction().commit();

            System.out.println("Rental Created Successfully!");
        } else {
            System.out.println("Vehicle Not Available or Invalid ID!");
        }

        session.close();
        factory.close();
    }
}
