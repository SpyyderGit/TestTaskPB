package dao.impl;

import dao.ProductDao;
import model.Product;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public class ProductDaoImpl implements ProductDao {

    private static final Logger log = Logger.getLogger(ProductDaoImpl.class);
    private Connection connection;
    private PreparedStatement statement = null;
    private Product product = null;

    public ProductDaoImpl(Connection connection) {

        this.connection = connection;
    }

    public void addProduct(String productName, double productPrice, String productRemark,
                           String sklad, int mrIdFk, int typeIdFk) throws SQLException {
        try {
            statement = connection.prepareStatement("INSERT INTO product(name,price,remark," +
                    "sklad,fk_id_mr," +
                    "fk_id_type) " +
                    "VALUES(?,?,?,?,?,?)");
            statement.setString(1, productName);
            statement.setDouble(2, productPrice);
            statement.setString(3, productRemark);
            statement.setString(4, sklad);
            statement.setInt(5, mrIdFk);
            statement.setInt(6, typeIdFk);
            statement.executeUpdate();


            log.info("Add product " + productName + " successfull");

        } catch (SQLException e) {
            log.error("Product isn't add\n");
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public void deleteProduct(Product product) {

    }

    public void updateProduct(Product product) {

    }

    public Product getById(int id) throws SQLException {
        try {
            statement = connection.prepareStatement("SELECT * FROM product WHERE product_id = ?");
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            set.next();
            product = new Product(set.getInt("product_id"), set.getString("name"),
                    set.getDouble("price"), set.getString("remark"),
                    set.getString("sklad"), set.getInt("fk_id_mr"),
                    set.getInt("fk_id_type"));

            log.info("Product with id " + product.getProductId() + " finded");

        } catch (SQLException e) {
            log.error("Product isn't find");
        } finally {
            connection.close();
        }

        return product;
    }

    public Product getByName(String name) throws SQLException {

        try {
            statement = connection.prepareStatement("SELECT * FROM product WHERE name = ?");
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();
            set.next();
            product = new Product(set.getInt("product_id"), set.getString("name"),
                    set.getDouble("price"), set.getString("remark"),
                    set.getString("sklad"), set.getInt("fk_id_mr"),
                    set.getInt("fk_id_type"));
            log.info("Product " + product + " is find");
        } catch (SQLException e) {
            log.error("Product " + name + " isn't find");
        } finally {
            connection.close();
        }

        return product;
    }

    public List<Product> getByPrice(double price) {
        List<Product> productList = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM product WHERE price = ?");
            statement.setDouble(1, price);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                productList.add(new Product(set.getInt("product_id"), set.getString("name"),
                        set.getDouble("price"), set.getString("remark"),
                        set.getString("sklad"), set.getInt("fk_id_mr"),
                        set.getInt("fk_id_type")));
            }
            log.info("Price:  " + price + " finded " + productList.size() + " products");
        } catch (SQLException e) {
            log.error("Products with price:  " + price + " isn't find");
        }

        return productList;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                productList.add(new Product(set.getInt("product_id"), set.getString("name"),
                        set.getDouble("price"), set.getString("remark"),
                        set.getString("sklad"), set.getInt("fk_id_mr"),
                        set.getInt("fk_id_type")));
            }
            log.info(productList.size() + " products finded");
        } catch (SQLException e) {
            log.error("is empty");
        }

        return productList;
    }
}
