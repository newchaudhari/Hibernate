package com.navin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class SaveDerived {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.setBaseName("Base");
        derived.setDerivedName("Derived");
        derived.setDerivedId(1);

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Derived.class);//class & table mapping

        configuration.configure();// hibernate configuration: hibernate.cfg.xml

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(derived);
        transaction.commit();
        session.close();

        System.out.println("Derived object saved");


    }
}
