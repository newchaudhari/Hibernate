package com.navin;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {

        User user= User.builder()
                .name("navin")
                .salary(30000)
                .build();

//        addUser(user);
//        System.out.println(getUser(1));
        deleteUser(52);
    }


    private static void addUser(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
    private static User getUser(int userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, userId);
        session.close();
        return user;
    }
    private static void deleteUser(int userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, userId);
        session.remove(user);
        transaction.commit();
        session.close();
        System.out.println("user deleted");
    }

    private static Session getSession() {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
