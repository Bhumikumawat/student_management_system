package com.bhumi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestConnection {
    public static void main(String[] args) {
        try {
            // Create a SessionFactory
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            // Open a session
            Session session = sessionFactory.openSession();
            System.out.println("Connection to database established successfully!");
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}