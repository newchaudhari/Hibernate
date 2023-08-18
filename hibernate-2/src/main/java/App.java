import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {

        Properties properties=new Properties();
            FileInputStream fileInputStream=new FileInputStream("src\\main\\resources\\hibernate.cfg.properties");
            properties.load(fileInputStream);
            Employee employee=Employee.builder()
                    .name("admin")
                    .email("admin@gmail.com")
                    .salary(12000)
                    .build();

        Configuration configuration=new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Employee.class);

        StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        SessionFactory sessionFactory=configuration.buildSessionFactory(registryBuilder.build());
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();

    }
}
