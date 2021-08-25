package com.solution.test;

import com.solution.test.config.ConnectionInfo;
import com.solution.test.dao.TransactionDao;
import com.solution.test.model.Customers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.*;
import java.util.HashMap;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class TestApplication {

    public static HashMap<String, Customers> customers = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //I created the temp users data here based on the names in the transaction table. Its just an alternative to the properties file option given
        customers.put("Andrzej", new Customers(1L, "Andrzej", "Andrzejowski", "andrzej", "andrzej123"));
        customers.put("Anna", new Customers(2L, "Anna", "Zaradna", "anna", "anna123"));
        customers.put("Micha", new Customers(3L, "Micha?", "Micha?owski", "micha", "micha123"));
        customers.put("Jakub", new Customers(4L, "Jakub", "Jakubowski", "jakub", "jakub123"));
        customers.put("Jacek", new Customers(5L, "Jacek", "Jackowski", "jacek", "jacek123"));

        ConnectionInfo connectionInfo = new ConnectionInfo();
        //create the given data on startup if not exist
        try {
            Connection conn = connectionInfo.getConnectionInfo();
            if (conn != null) {
                TransactionDao.createRecords();
            } else {
                throw new SQLException("Error connecting to DB");
            }
        } catch (SQLException ex) {
            throw new SQLException("Error connecting to DB");
        }
        SpringApplication.run(TestApplication.class, args);
    }

}

