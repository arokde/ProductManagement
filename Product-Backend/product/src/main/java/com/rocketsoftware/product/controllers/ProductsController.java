package com.rocketsoftware.product.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocketsoftware.product.models.Product;
import com.rocketsoftware.product.models.Response;
import com.rocketsoftware.product.repositories.ProductRepository;
import com.rocketsoftware.product.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccessService accessService;

    @GetMapping
    public List<Product> list() {

        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = new ArrayList<>();
        try {
            URI url = new URI("http://localhost:7171/demo/Products");
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Product> requestEntity = new HttpEntity<>(null, headers);
            headers.add("Authorization", "Bearer" + accessService.getAccessToken());
            ResponseEntity<Response> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Response.class);
            products = result.getBody().getProducts();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") long id) {

        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = new ArrayList<>();
        try {
            URI url = new URI("http://localhost:7171/demo/Products/"+ id);
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Product> requestEntity = new HttpEntity<>(null, headers);
            headers.add("Authorization", "Bearer" + accessService.getAccessToken());
            ResponseEntity<Product> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product.class);
            return result.getBody();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return new Product();
    }

    public static void main(String[] args) {


        final String productString = "{\"@uri\":\"http://localhost:7171/demo/Products/1\",\"productCode\":\"GDN-011\",\"productId\":\"1\",\"releaseDate\":\"March 19, 2019\",\"price\":\"19.95\",\"imageUrl\":\"assets/images/leaf_rake.png\",\"description\":\"Leaf rake with 48-inch wooden handle.\",\"starRating\":\"3.2\",\"u2version\":\"-7730665939983639862\",\"productName\":\"Leaf Rake\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            //final Product product = mapper.readValue(productString, Product.class);

            Response response = mapper.readValue(new File("c:\\AlphaDemos\\test.json"), Response.class);
            System.out.println(response.getProducts());
        } catch (JsonProcessingException e) {
            System.out.println("error" + e);
        } catch (IOException e) {
            System.out.println("error" + e);
        }
    }


}
