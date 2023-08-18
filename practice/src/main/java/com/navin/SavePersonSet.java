package com.navin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class SavePersonSet {
    public static void main(String[] args) {
        Person person=new Person();
        person.setName("Viraj");
        person.setPhoneNumber(Set.of(123456,456879,97969968,475892));

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(com.navin.Person.class);
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
        System.out.println("Person added");
    }
}
