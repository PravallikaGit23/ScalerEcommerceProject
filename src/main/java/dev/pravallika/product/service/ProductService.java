package dev.pravallika.product.service;

import dev.pravallika.product.model.Category;
import dev.pravallika.product.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(long id);

    List<Product> getAllProducts();

    List<Product> getLimitedProducts();

    List<Product> getSortedProducts();

    Product createProduct(String title, double price, String description, String imageUrl, String category);

    Product deleteProduct(long id);
}
