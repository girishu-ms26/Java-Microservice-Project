package com.at0m.common.feign;

import com.at0m.common.model.ProductAvailableQuantity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name="AT0M-AVAILABLE-QUANTITY-API")
public interface AvailableQuantityFeign {

    @GetMapping("/api/quantities")
    List<ProductAvailableQuantity> getAllAvailableQuantities();

    @PostMapping("/api/quantities")
    List<ProductAvailableQuantity> saveListOfQuantities(List<ProductAvailableQuantity> availableQuantities);

    @GetMapping("/api/quantity/{productName}")
    ProductAvailableQuantity getByProductname(@PathVariable String productName);
}
