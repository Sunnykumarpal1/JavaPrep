package com.example.UrbanCart.controller;

import com.example.UrbanCart.dto.ProductRequestDTO;
import com.example.UrbanCart.dto.ProductResponeDTO;
import com.example.UrbanCart.entity.Product;
import com.example.UrbanCart.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
   private ProductResponeDTO addProduct(@Valid  @RequestBody ProductRequestDTO productRequestDTO){
       return   productService.addProduct(productRequestDTO);
    }

    @GetMapping
   private List<ProductResponeDTO>getAllProducts(){
        List<ProductResponeDTO>products=productService.getAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    private ProductResponeDTO getProductById(@PathVariable("id") Long id){
      return   productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProductById(@PathVariable("id") Long id){
        productService.deleteByProductId(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<ProductResponeDTO>updateProductById(@PathVariable("id") Long id,@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponeDTO  updateProduct= productService.updateProductById(id,productRequestDTO);
        return ResponseEntity.ok(updateProduct);
    }


}
