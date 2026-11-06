package com.example.UrbanCart.service;

import com.example.UrbanCart.Exception.ProductNotFoundException;
import com.example.UrbanCart.Mapper.ProductMapping;
import com.example.UrbanCart.dto.ProductRequestDTO;
import com.example.UrbanCart.dto.ProductResponeDTO;
import com.example.UrbanCart.entity.Product;
import com.example.UrbanCart.repository.ProductRepostiory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    public final  ProductMapping productMapping;

    public final ProductRepostiory productRepostiory;

    public ProductService(ProductMapping productMapping, ProductRepostiory productRepostiory) {
        this.productMapping = productMapping;
        this.productRepostiory = productRepostiory;
    }

    public ProductResponeDTO addProduct(ProductRequestDTO productRequestDTO) {
        Product product= productMapping.toProduct(productRequestDTO);
        Product prod=productRepostiory.save(product);
        return productMapping.toProductResponseDTO(product);
    }

    public List<ProductResponeDTO> getAllProducts() {
      List<Product>products= productRepostiory.findAll();
      List<ProductResponeDTO> allProducts = products.stream().map(productMapping::toProductResponseDTO).toList();
      return allProducts;
    }


    public  ProductResponeDTO findProductById(Long id) {
        Product product=productRepostiory.findById(id).orElseThrow(()->new ProductNotFoundException("product not found exception"));
        ProductResponeDTO productResponseDTO = productMapping.toProductResponseDTO(product);
        return productResponseDTO;
    }

    @Transactional
    public void deleteByProductId(Long id) {
        Product p=productRepostiory.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found"));
        productRepostiory.deleteById(id);
        return ;
    }

    @Transactional
    public ProductResponeDTO updateProductById(Long id,ProductRequestDTO productRequestDTO) {
         Product product=productRepostiory.findById(id).orElseThrow(()->new ProductNotFoundException("Product not found exception"));
         product.setDescription(productRequestDTO.getDescription());
         product.setStockQuantity(productRequestDTO.getStockQuantity());
         product.setPrice(productRequestDTO.getPrice());
         product.setCategory(productRequestDTO.getCategory());
         product.setImageUrl(product.getImageUrl());

         productRepostiory.save(product);

         return productMapping.toProductResponseDTO(product);
    }
}
