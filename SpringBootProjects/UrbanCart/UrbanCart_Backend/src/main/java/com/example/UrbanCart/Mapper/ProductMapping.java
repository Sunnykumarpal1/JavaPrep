package com.example.UrbanCart.Mapper;

import com.example.UrbanCart.dto.ProductRequestDTO;
import com.example.UrbanCart.dto.ProductResponeDTO;
import com.example.UrbanCart.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapping {
    public ProductResponeDTO toProductResponseDTO(Product product){
        ProductResponeDTO productResponeDTO=new ProductResponeDTO(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getImageUrl(),product.getCategory(),product.getStockQuantity());
        return productResponeDTO;
    }

    public Product toProduct(ProductRequestDTO productRequestDTO){
        Product product=new Product();
        product.setName(productRequestDTO.getName());
        product.setCategory(productRequestDTO.getCategory());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageUrl(productRequestDTO.getImageUrl());
        product.setStockQuantity(productRequestDTO.getStockQuantity());
        product.setDescription(productRequestDTO.getDescription());
        return product;
    }
}
