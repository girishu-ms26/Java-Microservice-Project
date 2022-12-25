package com.at0m.common.util;

import com.at0m.common.model.Product;
import com.at0m.common.model.ProductResponseResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductUtil {

    public List<ProductResponseResource> productTransformerSuccessful(List<Product> products){
        List<ProductResponseResource> productResponseResources = new ArrayList<>();
        for(int i=0;i<products.size();i++){
            ProductResponseResource productResponseResource = new ProductResponseResource();
            productResponseResource.setSuccessful(true);
            productResponseResource.setProductName(products.get(i).getProductName());
            productResponseResource.setPrice(products.get(i).getPrice());
            if(products.get(i).getQuantityAvailable() != 0) {
                productResponseResource.setQuantityAvailable(products.get(i).getQuantityAvailable());
            }
            productResponseResource.setLastModified(new Date());
            productResponseResources.add(productResponseResource);
        }
        return productResponseResources;
    }

    public List<ProductResponseResource> productTransformerFail(List<Product> products){
        List<ProductResponseResource> productResponseResources = new ArrayList<>();
        for(int i=0;i<products.size();i++){
            ProductResponseResource productResponseResource = new ProductResponseResource();
            productResponseResource.setSuccessful(false);
            productResponseResource.setProductName(products.get(i).getProductName());
            productResponseResources.add(productResponseResource);
        }
        return productResponseResources;
    }

    public void removeDuplicatesFromList(List<Product> products){
        Set<Product> setOfProducts = new HashSet<>(products);
        products.clear();
        products.addAll(setOfProducts);
    }

    public Query createQuery(String productName){
        return Query.query(Criteria.where("productName").is(productName));
    }

    public Update createUpdateQuery(Product product){
        Update update = (new Update()
                .set("productName",product.getProductName())
                .set("price",product.getPrice()));
        return update;
    }
}

