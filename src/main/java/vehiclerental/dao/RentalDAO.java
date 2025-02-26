package vehiclerental.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import vehiclerental.model.Rental;
import vehiclerental.util.HibernateUtil;
import java.util.List;

public class RentalDAO {
    // Save Rental
    public void saveRental(Rental rental) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(rental);
            transaction.commit();
            System.out.println("✅ Rental saved successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Get Rental by ID
    public Rental getRentalById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Rental.class, id);
        }
    }

    // Get All Rentals
    public List<Rental> getAllRentals() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Rental", Rental.class).list();
        }
    }

    // Update Rental
    public void updateRental(Rental rental) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(rental);
            transaction.commit();
            System.out.println("Rental updated successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete Rental
    public void deleteRental(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Rental rental = session.get(Rental.class, id);
            if (rental != null) {
                session.delete(rental);
                System.out.println("Rental deleted successfully!");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
