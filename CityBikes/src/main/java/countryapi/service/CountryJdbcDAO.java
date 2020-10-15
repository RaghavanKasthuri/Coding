package countryapi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class CountryJdbcDAO {
    @SuppressWarnings("unused")
    private static SessionFactory sessionFactory;

    public void read() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TransactionHistory", "postgres", "Kmalathi123")) {
 
            System.out.println("Java JDBC PostgreSQL Example");
            
            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading country search history records...");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM postgres.search_history");
            

            //sessionFactory = new Configuration().configure().buildSessionFactory();
            //System.out.println("Session Factory created");
            //Session session = sessionFactory.openSession();
            //session.createQuery("SELECT * FROM search.transactionhistory");
            
            while (resultSet.next()) {
                System.out.printf("%-30.30s", resultSet.getString("search_date"));
            }
 
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

}