package com.example.product.controllers;

import com.example.product.dtos.EmailDTOSD;
import com.example.product.dtos.ProductRequestDTOSD;
import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductWrapper;
import com.example.product.exceptions.ProductDoesNotExistException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.models.User;
import com.example.product.services.IProductService;
import com.example.product.exceptions.InvalidProductIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;


    @Qualifier("selfProductService")
    @Autowired
    private IProductService productService;


//    @Autowired
//    public ProductController(@Qualifier("selfProductService") IProductService productService, FakeStoreProductService fakeStoreProductService){
//        this.productService = productService;
//    }

    // Get all the products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/search")
    public Page<Product> getAllProductsContaining(@RequestParam(name="text") String name,@RequestParam(name="pageNo") int pageNo,@RequestParam(name="pageSize") int size){

        return productService.getAllProductsContainingName(name,pageNo,size);

    }

    // Get a product with Id
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductWrapper> getSingleProduct(@PathVariable("id") Long id) throws InvalidProductIdException {

        ResponseEntity<ProductWrapper> response;
        Product singleProduct = productService.getSingleProduct(id);

        ProductWrapper productWrapper = new ProductWrapper(singleProduct, "Successfully retried the data");
        response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        return response;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImage(productRequestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDto.getCategory());

        Product savedProduct = productService.addProduct(product);
        return savedProduct;
    }

    @PostMapping("/products/addThroughSD")
    public ResponseEntity<Product> addProductSD(@RequestBody ProductRequestDTOSD productRequestDTOSD){
        Product product = new Product();
        product.setName(productRequestDTOSD.getTitle());
        product.setDescription(productRequestDTOSD.getDescription());
        product.setPrice(productRequestDTOSD.getPrice());
        product.setImage(productRequestDTOSD.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDTOSD.getCategory());



        EmailDTOSD emailDTOSD = new EmailDTOSD();
        emailDTOSD.setEmail(productRequestDTOSD.getEmail());

                Optional<User> userName = restTemplate.postForObject("http://192.168.1.15/findUser",emailDTOSD, Optional.class);

                if(userName.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                else{
                    Product savedProduct = productService.addProduct(product);
                    ResponseEntity<Product> productResponseEntity = new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
//                    productResponseEntity.

                    return productResponseEntity;

                }


    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                 @RequestBody ProductRequestDto productRequestDto) throws ProductDoesNotExistException {

        Product product = new Product();
        product.setId(id);
        product.setName(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setImage(productRequestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDto.getCategory());

        return productService.updateProduct(id, product);
    }


    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id) {
        return true;
    }

    @GetMapping("/products/nishant")
    public String getDetailsP(){
        return "Nishant";
    }


}
