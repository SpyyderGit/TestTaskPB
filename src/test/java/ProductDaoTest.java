import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import org.junit.*;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleg on 18.05.17.
 */


public class ProductDaoTest {
    private Connection connection = null;
    private ProductDao productDao;

    @Before
    public void setConnect() {
        String url = "jdbc:mysql://localhost:3306/ShopTest";
        String name = "root";
        String pass = "290731";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, pass);
            ProductDao productDao = new ProductDaoImpl(connection);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByIdTest() {
        int expected = 1;
        int actual = 1;
        assertEquals(expected,actual);
    }

    @After
    public void closeConnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



