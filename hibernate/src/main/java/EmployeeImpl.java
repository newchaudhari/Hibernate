import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class EmployeeImpl {
    public static void main(String[] args) {

        Employee employee=new Employee(1,"abc",20000);

        FileInputStream fileInputStream=null;
        Properties properties=null;

        try {
           fileInputStream =new FileInputStream("src\\main\\resources\\application.properties");
           properties =new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password= properties.getProperty("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql="INSERT INTO employee values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2,"abc");
            preparedStatement.setInt(3,10000);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

}
