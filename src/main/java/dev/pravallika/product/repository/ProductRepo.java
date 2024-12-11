package dev.pravallika.product.repository;

import dev.pravallika.product.model.Product;
import dev.pravallika.product.projections.ProductTiltleAndDescription;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

    public Product save(Product product);

    Optional<Product> getById(long id);

    List<Product> findAll();

    Product deleteById(long id);

    Product findByIdAndTitle(long id, String title);

    Product findByTitleAndCategory_name(String title, String category);


    @Query("select p from Product p where p.category.name = :categoryName")
    List<Product> getProductDataByCategory(@Param("categoryName") String categoryName);

    @Query(value = "select * from Product  limit 10",nativeQuery = true)
    List<Product> getProductDataAndLimit();

    @Query("select p from Product p order by p.title ")
    List<Product> getSortedProductsByTitle();

    @Query("select p from Product p where p.id = :id")
    ProductTiltleAndDescription ProjectionById(@Param("id") Long id);

}
