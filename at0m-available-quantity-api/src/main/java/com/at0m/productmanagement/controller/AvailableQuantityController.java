package com.at0m.productmanagement.controller;

import com.at0m.common.model.ProductAvailableQuantity;
import com.at0m.common.service.AvailableQuantityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AvailableQuantityController {

    private final AvailableQuantityService availableQuantityService;

    public AvailableQuantityController(AvailableQuantityService availableQuantityService) {
        this.availableQuantityService = availableQuantityService;
    }

    @GetMapping("/quantities")
    public List<ProductAvailableQuantity> getAllAvailableQuantity(){
        return availableQuantityService.getAllList();
    }

    @GetMapping("/quantities/{productName}")
    public ProductAvailableQuantity getByProductname(@PathVariable String productName){
        return availableQuantityService.getByProductName(productName);
    }

    @PostMapping("/quantities/")
    public List<ProductAvailableQuantity> saveListOfQuantities(@RequestBody List<ProductAvailableQuantity> quantityWithProducts){
        return availableQuantityService.saveAll(quantityWithProducts);
    }

    @PostMapping("/quantities")
    public ProductAvailableQuantity saveQuantity(@RequestBody ProductAvailableQuantity productAvailableQuantity){
        return availableQuantityService.saveAvailableQuantity(productAvailableQuantity);
    }
}
