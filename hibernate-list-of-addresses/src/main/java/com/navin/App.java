package com.navin;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.setCity("Padalse");
        address1.setState("Maharashtra");
        address1.setCountry("India");

        Address address2 = new Address();
        address2.setCity("Bhusawal");
        address2.setState("Maharashtra");
        address2.setCountry("India");

        Address address3 = new Address();
        address3.setCity("Jalgaon");
        address3.setState("Maharashtra");
        address3.setCountry("India");

        Employee employee = new Employee();
        employee.setName("Navin");
        employee.setSalary(15000);
        employee.setAddress(List.of(address1, address2, address3));

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.navin.Employee.class);
        configuration.addAnnotatedClass(com.navin.Address.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee);
        session.save(address1);
        session.save(address2);
        session.save(address3);

        transaction.commit();
        session.close();

        System.out.println("employee saved");


    }
}
