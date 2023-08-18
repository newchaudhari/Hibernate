import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmployeeImpl {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
        properties.load(fileInputStream);

        Configuration configuration=new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Employee.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = Employee.builder()
                .employeeId(1)
                .employeeName("bhavesh")
                .employeeSalary(10000)
                .build();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();
    }
}
