package dev.pravallika.product.service;

import dev.pravallika.product.ExceptionHandler.ProductNotFound;
import dev.pravallika.product.ExceptionHandler.ProductNotUpdated;
import dev.pravallika.product.dto.RequestDto;
import dev.pravallika.product.model.Category;
import dev.pravallika.product.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProduct(long id) throws ProductNotFound;

    List<Product> getAllProducts() throws ProductNotFound;

    List<Product> getLimitedProducts() throws ProductNotFound;

    List<Product> getSortedProducts() throws ProductNotFound;

    Product createProduct(String title, double price, String description, String imageUrl, String category) throws ProductNotUpdated;

    Product deleteProduct(long id) throws ProductNotUpdated;

    Product updateProductUsingPut(long id, String title, String description, double price, String image, String category) throws ProductNotUpdated, ProductNotFound;

    Product updateProductUsingPatch(long id, String title, String description, double price, String image, String category) throws ProductNotUpdated, ProductNotFound;
}
