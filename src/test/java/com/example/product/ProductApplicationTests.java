package com.example.product;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void getSomeData(){
//		Optional<Product> productOptional = productRepository.findByName("iphone");
//		if(productOptional.isEmpty()){
//			return;
//		}
//		Product product = productOptional.get();
//		System.out.println(product.getId() + " " + product.getPrice());
//	}
//
//	@Test
//	public void getSomeDataWithConditions(){
//		List<Product> productList = productRepository.findByNameAndDescriptionAndPriceGreaterThan("Macbook", "laptop", 50000);
//		for(Product product: productList){
//			System.out.println(product.getName() + " " + product.getDescription());
//		}
//	}
//
//	@Test
//	public void getSomeListData(){
//		List<Product> productList = productRepository.findTop5DistinctProductByName("Macbook");
//		for(Product product: productList){
//			System.out.printf(product.getName() + " " + product.getDescription());
//		}
//	}
//
//	@Test
//	public void deleteProduct(){
//		productRepository.deleteById(2L);
//	}
}
