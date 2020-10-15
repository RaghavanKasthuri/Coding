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
import org.junit.Test;
 
public class Runner {
    @SuppressWarnings("unused")
    private static SessionFactory sessionFactory;
    Session entityManager;

    @Test
    public void crud() {
        System.out.println("Inside crud() method successfully");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("Session Factory created successfully");
        Session session = sessionFactory.openSession();
        System.out.println("Obtained handle to a session successfully" + session.toString());
	
        List transactionHistory = session.createQuery("FROM TransactionHistory").list(); 
        for (Iterator iterator = transactionHistory.iterator(); iterator.hasNext();){
           TransactionHistory txn = (TransactionHistory) iterator.next(); 
           System.out.print("Search Date: " + txn.getSearchDate()); 
        }  
        System.out.println("CreateQuery worked fine and list of results created = "+transactionHistory.size());
        session.close();
    }
    
    @Test
    public void add() throws ParseException {
        Integer txnID = null;
        System.out.println("Inside add() method successfully");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println("Session Factory add() created successfully");
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        System.out.println("Obtained handle to a add() session successfully" + session.toString());
        tx = session.beginTransaction();

        TransactionHistory th = new TransactionHistory();
        th.setId(3);
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        th.setSearchDate(date1);
        txnID = (Integer) session.save(th);
        tx.commit();
        System.out.println("Add Transaction ID = " + txnID);
        session.close();
        //return txnID;
    }
}