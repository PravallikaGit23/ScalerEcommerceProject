package dev.pravallika.product.dto;

import dev.pravallika.product.model.Category;
import dev.pravallika.product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImageUrl());

        Category category1 = new Category();
        category1.setCategory(getCategory());
        product.setCategory(category1);

     return product;
    }
}
