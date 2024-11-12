package dev.pravallika.product.service;

import dev.pravallika.product.dto.FakeStoreProductDto;
import dev.pravallika.product.model.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProduct(long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDto =
                restTemplate.exchange("https://fakestoreapi.com/products/" + id,
                        HttpMethod.GET, null,
                        FakeStoreProductDto.class

                );

        if (fakeStoreProductDto.hasBody())
            return fakeStoreProductDto.getBody().toProduct();

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
//        ResponseEntity<FakeStoreProductDto[]> listResponseEntity = restTemplate.exchange(
//                "https://fakestoreapi.com/products",
//                HttpMethod.GET,
//                null,
//              FakeStoreProductDto[].class);
//        List<Product> products = new ArrayList<>();
//        for(FakeStoreProductDto fakeStoreProductDto : listResponseEntity.getBody()){
//            products.add(fakeStoreProductDto.toProduct());
//        }

        ResponseEntity<List<FakeStoreProductDto>> listResponseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeStoreProductDto>>() {
                }
        );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : listResponseEntity.getBody()) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public List<Product> getLimitedProducts() {
        ResponseEntity<List<FakeStoreProductDto>> listResponseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products?limit=5",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeStoreProductDto>>() {
                }
        );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : listResponseEntity.getBody()) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public List<Product> getSortedProducts() {
        ResponseEntity<List<FakeStoreProductDto>> listResponseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products?sort=desc",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeStoreProductDto>>() {
                }
        );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : listResponseEntity.getBody()) {
            products.add(fakeStoreProductDto.toProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(String title, double price, String description, String imageUrl, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImageUrl(imageUrl);
        fakeStoreProductDto.setCategory(category);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FakeStoreProductDto> requestEntity = new HttpEntity<>(fakeStoreProductDto, headers);

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.POST,
                requestEntity,         //it requires body with headers
                FakeStoreProductDto.class
        );

        return responseEntity.getBody().toProduct();
    }

    @Override
    public Product deleteProduct(long id) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.exchange(
                           "https://fakestoreapi.com/products/"+ id ,
                           HttpMethod.DELETE,
                            null,
                            FakeStoreProductDto.class
                           );
        return fakeStoreProductDtoResponseEntity.getBody().toProduct();
    }




}
