package vehiclerental.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vehiclerental.model.Rental;
import vehiclerental.model.Vehicle;
import vehiclerental.util.HibernateUtil;

import java.util.List;

public class RentalService {
	    private SessionFactory sessionFactory;

	    public RentalService() {
	        this.sessionFactory = HibernateUtil.getSessionFactory();
	    }

	    public void addRental(Rental rental) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        // Check if vehicle is available
	        Vehicle vehicle = rental.getVehicle();
	        if (!vehicle.isAvailable()) {
	            System.out.println("Vehicle is not available for rent!");
	            return;
	        }

	        vehicle.setAvailable(false); // Mark vehicle as rented
	        session.update(vehicle);
	        session.save(rental);
	        transaction.commit();
	        session.close();
	        System.out.println("Rental recorded successfully!");
	    }

	    public List<Rental> getAllRentals() {
	        Session session = sessionFactory.openSession();
	        List<Rental> rentals = session.createQuery("from Rental", Rental.class).list();
	        session.close();
	        return rentals;
	    }

	    public Rental getRentalById(int id) {
	        Session session = sessionFactory.openSession();
	        Rental rental = session.get(Rental.class, id);
	        session.close();
	        return rental;
	    }

	    public void returnVehicle(int rentalId) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        
	        Rental rental = session.get(Rental.class, rentalId);
	        if (rental != null) {
	            Vehicle vehicle = rental.getVehicle();
	            vehicle.setAvailable(true); // Mark vehicle as available
	            session.update(vehicle);
	            session.delete(rental);
	            transaction.commit();
	            System.out.println("Vehicle returned successfully!");
	        } else {
	            System.out.println("Rental not found!");
	        }
	        session.close();
	    }
	}


