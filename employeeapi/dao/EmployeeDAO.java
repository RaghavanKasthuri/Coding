package employeeapi.dao;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import employeeapi.entity.Employee;
 
public class EmployeeDAO {

	@SuppressWarnings("unused")
    private static SessionFactory sessionFactory;

    public void add(Employee emp) throws ParseException {
        Integer txnID = null;
        System.out.println("Inside EmployeeDAO add() method successfully");
        System.out.println("Are we here inside add as new configuration() is getting printed");
        System.out.println("EmployeeDAO add(): First Name = "+ emp.getFirstName());
       
		try {
        System.out.println("Going to instantiate configuration()");
        Configuration configuration = new Configuration();
        configuration = configuration.configure( "hibernate.cfg.xml" );
        System.out.println("configure hibernate.cfg.xml");
        //configuration.addAnnotatedClass(Employee.class);
        //
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory();

        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("EmployeeDAO add() - Session Factory created successfully");
        } catch (Exception e) {
        System.out.println("Session Factory Initialization Exception details "+ e.getMessage());
        }
        Session session = sessionFactory.openSession();
        System.out.println("EmployeeDAO add() - Open Session successfully");
        Transaction tx = null;
        tx = session.beginTransaction();
        System.out.println("Add(): Begin transaction");
        System.out.println("EmployeeDAO add() Obtained handle to session successfully" + session.toString());
        System.out.println("Session.beginTransaction()");

        txnID = (Integer) session.save(emp);
        tx.commit();
        System.out.println("EmployeeDAO Add() txnId = " + txnID);
        session.close();
    }
             
    public void read() {
        System.out.println("Inside EmployeeDAO read() method successfully");
        //sessionFactory = new Configuration().configure().buildSessionFactory();

    	Configuration configuration = new Configuration();
    	System.out.println("new configuration()");
    	configuration = configuration.configure( "hibernate.cfg.xml" );
    	System.out.println("configure hibernate.cfg.xml");
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("EmployeeDAO read() - Session Factory created successfully");
        Session session = sessionFactory.openSession();
        System.out.println("Obtained handle to a Employee DAO read() session successfully" + session.toString());
	
        List employees = session.createQuery("FROM Employee").list(); 
        for (Iterator iterator = employees.iterator(); iterator.hasNext();){
           Employee txn = (Employee) iterator.next(); 
           System.out.print("EmployeeDAO read() EmployeeId's: " + txn.getId()); 
        }  
        System.out.println("EmployeeDAO read() list size = "+employees.size());
        session.close();
    }
    
    }