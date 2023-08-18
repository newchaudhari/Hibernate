package com.navin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class SaveEmployee {
    public static void main(String[] args) {


    Employee employee = Employee.builder()
            .employeeName("Navin")
            .employeeSalary(20000)
            .skills(List.of("Core Java", "Advance Java", "Hibernate", "Spring", "SQL"))
            .build();

    Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.navin.Employee.class);//class & table mapping
        configuration.configure();// hibernate configuration: hibernate.cfg.xml

    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();

        System.out.println("Employee object saved");
    }

}
