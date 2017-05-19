package dao;

import model.Product;
import model.ProductMr;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductMrDao {
    void addProductMr(ProductMr product);

    void deleteProductMr(ProductMr product);

    void updateProductMr(ProductMr product);

    ProductMr getById(int id);

    List<Product> getByName(String name);

    List<Product> getAllName(String name);

}
