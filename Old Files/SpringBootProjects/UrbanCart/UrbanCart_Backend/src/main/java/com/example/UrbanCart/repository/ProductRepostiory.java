package com.example.UrbanCart.repository;

import com.example.UrbanCart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostiory extends JpaRepository<Product,Long> {
}
