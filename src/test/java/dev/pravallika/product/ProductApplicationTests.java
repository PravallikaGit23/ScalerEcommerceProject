package dev.pravallika.product;

import dev.pravallika.product.model.Category;
import dev.pravallika.product.model.Product;
import dev.pravallika.product.projections.ProductTiltleAndDescription;
import dev.pravallika.product.repository.CategoryRepository;
import dev.pravallika.product.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductApplicationTests {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepository categoryRepository;
 //   @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void testFindByIdAndTitle() {
//        Optional<Product> product = Optional.ofNullable((productRepo.findByIdAndTitle(52, "'biba product'")));
//        System.out.println(product.get().getTitle() + " " + product.get().getPrice());
//    }
//    @Test
//    public void test() {
//        Optional<Product> productOptional = Optional.ofNullable(productRepo
//                .findByTitleAndCategory_name("iphone15 pro product", "phones"));
//
//
//        System.out.println(productOptional.get().getTitle());
//    }
//    @Test
//    public void testHQL() {
//        List<Product> productList = (productRepo
//                .getProductDataByCategory("phones"));
//
//    for(Product product : productList) {
//        System.out.println(product.getTitle());
//    }
//    }
//    @Test
//    public void testNativeQuery() {
//        List<Product> productList = (productRepo
//                .getProductDataAndLimit());
//
//        for(Product product : productList) {
//            System.out.println(product.getTitle());
//        }
//    }
//    @Test
//    public void testSortedQuery() {
//        List<Product> productList = (productRepo
//                .getSortedProductsByTitle());
//
//        for(Product product : productList) {
//            System.out.println(product.getId() +" --> "+product.getTitle()+"--> "+product.getPrice());
//        }
//    }
//
//    @Test
//    public void testProjection() {
//        ProductTiltleAndDescription product =  productRepo
//                .ProjectionById(53L);
//
//            System.out.println(product.getDescription() +" --> "+product.getTitle()+"--> "+product.getPrice());
//
//    }
//
//    @Test
//    @Transactional
//    public void fetchTypeExample(){
//        Optional<Category> category = categoryRepository.findById(1L);
//        System.out.println("lazy loading");
//        if(category.isPresent()){
//            List<Product> products =category.get().getProducts();
//            for(Product product : products) {
//                System.out.println(product.getTitle());
//            }
//        }
//
//    }
//
////    @Test
////    @Transactional
////    public void nplus1Probem(){
////        List<Category> categories = categoryRepository.findAll();
////        for(Category category : categories) {
////            for(Product product : category.getProducts()) {
////                System.out.println(product.getTitle());
////            }
////        }
////    }


}
