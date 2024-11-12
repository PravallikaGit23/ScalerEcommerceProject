package dev.pravallika.product.controller;

import dev.pravallika.product.dto.RequestDto;
import dev.pravallika.product.model.Product;
import dev.pravallika.product.service.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController{

    private final ProductService productService;
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {

        return new ResponseEntity<>(productService.getProduct(id), HttpStatusCode.valueOf(200));
   }

   @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatusCode.valueOf(200));
   }

    @GetMapping("/limitedproducts")
    public ResponseEntity<List<Product>> getlimitedProducts() {
        List<Product> productList = productService.getLimitedProducts();
        return new ResponseEntity<>(productList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/sortedProducts")
    public ResponseEntity<List<Product>> getSortedProducts() {
        List<Product> productList = productService.getSortedProducts();
        return new ResponseEntity<>(productList, HttpStatusCode.valueOf(200));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody RequestDto requestDto) {
      Product product =  productService.createProduct(
                requestDto.getTitle(),
                requestDto.getPrice(),
                requestDto.getDescription() ,
                requestDto.getImage() ,
                requestDto.getCategory()
        );

        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        Product product= productService.deleteProduct(id);
        return new ResponseEntity<>(productService.getProduct(id), HttpStatusCode.valueOf(200));
    }

}
