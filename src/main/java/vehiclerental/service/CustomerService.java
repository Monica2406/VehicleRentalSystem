package vehiclerental.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vehiclerental.model.Customer;
import vehiclerental.util.HibernateUtil;

import java.util.List;

public class CustomerService {
	    private SessionFactory sessionFactory;

	    public CustomerService() {
	        this.sessionFactory = HibernateUtil.getSessionFactory();
	    }

	    public void addCustomer(Customer customer) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(customer);
	        transaction.commit();
	        session.close();
	        System.out.println("Customer added successfully!");
	    }

	    public List<Customer> getAllCustomers() {
	        Session session = sessionFactory.openSession();
	        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
	        session.close();
	        return customers;
	    }

	    public Customer getCustomerById(int id) {
	        Session session = sessionFactory.openSession();
	        Customer customer = session.get(Customer.class, id);
	        session.close();
	        return customer;
	    }

	    public void updateCustomer(Customer customer) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(customer);
	        transaction.commit();
	        session.close();
	        System.out.println("Customer updated successfully!");
	    }

	    public void deleteCustomer(int id) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        Customer customer = session.get(Customer.class, id);
	        if (customer != null) {
	            session.delete(customer);
	            transaction.commit();
	            System.out.println("Customer deleted successfully!");
	        }
	        session.close();
	    }
	}



