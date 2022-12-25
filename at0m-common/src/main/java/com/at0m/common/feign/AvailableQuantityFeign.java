package com.at0m.common.feign;

import com.at0m.common.model.ProductAvailableQuantity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="AT0M-AVAILABLE-QUANTITY-API")
public interface AvailableQuantityFeign {

    @GetMapping("/api/quantities")
    List<ProductAvailableQuantity> getAllAvailableQuantities();

    @GetMapping("/api/quantities/{productName}")
    ProductAvailableQuantity getByProductname(@PathVariable String productName);

    @PostMapping("/api/quantities/")
    List<ProductAvailableQuantity> saveListOfQuantities(List<ProductAvailableQuantity> availableQuantities);

    @PostMapping("/api/quantities")
    ProductAvailableQuantity saveQuantity(ProductAvailableQuantity productAvailableQuantity);
}
