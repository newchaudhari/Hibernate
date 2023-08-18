package com.navin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.setName("Navin");

        PermanentEmployee permanentEmployee=new PermanentEmployee();
        permanentEmployee.setName("Bhavesh");
        permanentEmployee.setSalary(100000);

        ContractEmployee contractEmployee=new ContractEmployee();
        contractEmployee.setName("Vinit");
        contractEmployee.setRatePerHour(1000);

        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(com.navin.Employee.class);
        configuration.addAnnotatedClass(com.navin.PermanentEmployee.class);
        configuration.addAnnotatedClass(com.navin.ContractEmployee.class);
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(permanentEmployee);
        session.save(contractEmployee);

        transaction.commit();
        session.close();

        System.out.println("object saved");
    }
}
