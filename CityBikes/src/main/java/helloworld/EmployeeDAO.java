package helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
 
public class EmployeeDAO {
    @SuppressWarnings("unused")
    private static SessionFactory sessionFactory;
    Session entityManager;

    public void read() {
        System.out.println("Inside EmployeeDAO read() method successfully");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("EmployeeDAO read() - Session Factory created successfully");
        Session session = sessionFactory.openSession();
        System.out.println("Obtained handle to a Employee DAO read() session successfully" + session.toString());
	
        List employees = session.createQuery("FROM Employee").list(); 
        for (Iterator iterator = employees.iterator(); iterator.hasNext();){
           Employee txn = (Employee) iterator.next(); 
           System.out.print("EmployeeDAO read() Employee First Name: " + txn.getFirstName()); 
        }  
        System.out.println("EmployeeDAO read() list size = "+employees.size());
        session.close();
    }
    
    public void add(Employee emp) throws ParseException {
        Integer txnID = null;
        System.out.println("Inside EmployeeDAO add() method successfully");
        System.out.println("EmployeeDAO add(): First Name = "+ emp.getFirstName());
        try {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
        	System.out.println("Session Factory Initialization Exception details "+ e.getMessage());
        }
        System.out.println("EmployeeDAO add() - Session Factory created successfully");
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        System.out.println("EmployeeDAO add() Obtained handle to session successfully" + session.toString());
        tx = session.beginTransaction();

        txnID = (Integer) session.save(emp);
        tx.commit();
        System.out.println("EmployeeDAO Add() txnId = " + txnID);
        session.close();   
    }
}