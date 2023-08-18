package com.navin;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ){
        Address address=new Address();
        address.setStreet("Vitthal Mandir Road");
        address.setCity("Padalse");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPinCode(425503);

        Employee employee=new Employee();
        employee.setName("Bhavesh");
        employee.setSalary(50000);
        employee.setAddress(address);

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(com.navin.Employee.class);
        configuration.addAnnotatedClass(com.navin.Address.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        System.out.println("Employee Saved");


    }
}
