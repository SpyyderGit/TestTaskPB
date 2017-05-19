package dao;

import model.Product;
import model.ProductType;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductTypeDao {

    void addProductType(Product product);

    void deleteProductType(Product product);

    void updateProductType(Product product);

    ProductType getById(int id);

    List<ProductType> getByName(String name);

    List<ProductType> getAllName(String name);
}
