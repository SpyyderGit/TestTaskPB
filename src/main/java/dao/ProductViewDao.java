package dao;

import model.Product;
import model.ProductType;
import model.ProductView;

import java.util.List;

/**
 * Created by User on 18.05.2017.
 */
public interface ProductViewDao {

    void addProductView(ProductView product);

    void deleteProductView(ProductView product);

    void updateProductView(ProductView product);

    ProductType getById(int id);

    List<ProductType> getByName(String name);

    List<ProductType> getAllName(String name);

}
