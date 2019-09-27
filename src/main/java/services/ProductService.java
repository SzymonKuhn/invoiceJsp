package services;

import database.EntityDao;
import model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final EntityDao entityDao = new EntityDao();

    public ProductService() {
    }

    public List<Product> getAll () {
        return entityDao.getAll(Product.class);
    }

    public void addProduct (Product product) {
        entityDao.saveOrUpdate(product);
    }

    public Optional<Product> getProduct (long id) {
        return entityDao.getById(Product.class, id);
    }

    public void deleteProduct(Product product) {
        entityDao.delete(product);
    }
}
