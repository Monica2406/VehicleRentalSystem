package vehiclerental.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vehiclerental.model.Vehicle;
import vehiclerental.util.HibernateUtil;
import java.util.List;

public class VehicleService {

	    private SessionFactory sessionFactory;

	    public VehicleService() {
	        this.sessionFactory = HibernateUtil.getSessionFactory();
	    }

	    public void addVehicle(Vehicle vehicle) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(vehicle);
	        transaction.commit();
	        session.close();
	        System.out.println("Vehicle added successfully!");
	    }

	    public List<Vehicle> getAllVehicles() {
	        Session session = sessionFactory.openSession();
	        List<Vehicle> vehicles = session.createQuery("from Vehicle", Vehicle.class).list();
	        session.close();
	        return vehicles;
	    }

	    public Vehicle getVehicleById(int id) {
	        Session session = sessionFactory.openSession();
	        Vehicle vehicle = session.get(Vehicle.class, id);
	        session.close();
	        return vehicle;
	    }

	    public void updateVehicle(Vehicle vehicle) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(vehicle);
	        transaction.commit();
	        session.close();
	        System.out.println("Vehicle updated successfully!");
	    }

	    public void deleteVehicle(int id) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        Vehicle vehicle = session.get(Vehicle.class, id);
	        if (vehicle != null) {
	            session.delete(vehicle);
	            transaction.commit();
	            System.out.println("Vehicle deleted successfully!");
	        }
	        session.close();
	    }
	}



