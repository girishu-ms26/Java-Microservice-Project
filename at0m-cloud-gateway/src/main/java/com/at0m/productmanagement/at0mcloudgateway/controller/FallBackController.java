package com.at0m.productmanagement.at0mcloudgateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/api/produ**/**")
    public Mono<String> productApiFallBack(){
        return Mono.just("Product API is down, Please try after sometime");
    }

    @RequestMapping("/api/quant**/**")
    public Mono<String> availableQuantityFallBack(){
        return Mono.just("Available Quantity API is down, Please try after sometime");
    }
}
