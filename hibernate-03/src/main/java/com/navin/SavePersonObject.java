package com.navin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavePersonObject {
    public static void main(String[] args) {
        Address address = Address.builder()
                .street("Padalse")
                .city("Jalgaon")
                .State("Maharashtra")
                .Country("India")
                .pinCode(425503)
                .build();
        Person person = Person.builder()
                .personName("Navin")
                .address(address)
                .build();

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(com.navin.Address.class);//class & table mapping
        configuration.addAnnotatedClass(com.navin.Person.class);//class & table mapping

        configuration.configure();// hibernate configuration: hibernate.cfg.xml

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        session.save(person);
        transaction.commit();
        session.close();

        System.out.println("Person object saved");

    }

}
