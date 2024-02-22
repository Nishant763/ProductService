package com.example.product.repositories;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
    Optional<Product> findById(Long id);

//    List<Product> findByNameAndDescriptionAndPriceGreaterThan(String title, String description, int price);
//
//    List<Product> findTop5DistinctProductByName(String name);
//
//    void deleteById(Long id);

    Product save(Product product);

}
