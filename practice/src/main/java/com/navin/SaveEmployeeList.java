package com.navin;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SaveEmployeeList
{
    public static void main( String[] args ) {
        Employee employee=new Employee();
        employee.setName("Bhavesh");
        employee.setSalary(20000);
        employee.setAddress(List.of("Mumbai","Delhi","Vapi"));

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        System.out.println("Employee added successfully");
    }
}
