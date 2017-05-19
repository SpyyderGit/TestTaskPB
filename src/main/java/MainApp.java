import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import org.apache.log4j.Logger;

import java.sql.*;

/**
 * Created by User on 18.05.2017.
 */
public class MainApp {
    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Shop";
        String name = "root";
        String pass = "290731";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
            ProductDao productDao = new ProductDaoImpl(connection);

            productDao.addProduct("Saturn", 20, "SVC", "Y", 3, 3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
