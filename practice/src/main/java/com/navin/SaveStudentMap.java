package com.navin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class SaveStudentMap {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("Shree");
        student.setAddress("padalse");
        student.setMarks(Map.of("Math",95,"English",87,"Science",72));

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(com.navin.Student.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        System.out.println("Student added");
    }
}
