package com.at0m.productmanagement.controller;

import com.at0m.common.model.Product;
import com.at0m.common.model.ProductResponseResource;
import com.at0m.common.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    private Environment environment;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/data")
    public String getBookData() {
        return "Product-Service, Running on port: "
                +environment.getProperty("local.server.port");
    }

    @GetMapping("/products")
    public List<ProductResponseResource> getAllProductsList(){
        return productService.getAllProductsList();
    }

    @GetMapping("/products/{productName}")
    public ProductResponseResource getProductByproductName(@PathVariable String productName){
        return productService.getProductByproductName(productName);
    }

    @PostMapping("/product")
    public List<ProductResponseResource> saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/products")
    public List<ProductResponseResource> saveListOfProducts(@RequestBody List<Product> products){
        return productService.saveListOfProducts(products);
    }

    @DeleteMapping("/products")
    public List<ProductResponseResource> deleteAllProducts(){
        return productService.deleteAll();
    }

     @PutMapping("/products")
    public ProductResponseResource updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{productName}")
    public void deleteProduct(@PathVariable String productName){
        productService.deleteProduct(productName);
    }
}