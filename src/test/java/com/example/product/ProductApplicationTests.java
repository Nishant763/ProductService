package com.example.product;

import com.example.product.repositories.ProductWithIdNamePrice;
import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

	@Test
	public void getSomething(){
		Product p = productRepository.something(2L);
		System.out.println(p.getName() + " " + p.getDescription());
	}

	@Test
	public void getSomethingSpecific(){
		ProductWithIdNamePrice p = productRepository.somethingSpecific(2L);
//		System.out.println(p.getDescription());
	}

	@Test
	public void getSomethingFromMYSQL(){
		Product p = productRepository.somethingMySQLQuery(2L);
		System.out.printf(p.getName() + " "  + p.getPrice());
//		System.out.println(p.getDescription());
	}

	@Test
	public void getSomethingFromMYSQLSpec(){
		ProductWithIdNamePrice p = productRepository.somethingMySQLQuerySpecific(2L);
		System.out.printf(p.getTitle() + " "  + p.getvalue());
//		System.out.println(p.getDescription());
	}
}
