package com.at0m.common.util;

import com.at0m.common.model.ProductAvailableQuantity;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AvailableQuantityUtil {

    public void removeDuplicatesFromList(List<ProductAvailableQuantity> availableQuantity){
        Set<ProductAvailableQuantity> setOfQuantities = new HashSet<>(availableQuantity);
        availableQuantity.clear();
        availableQuantity.addAll(setOfQuantities);
    }

    public Query createQuery(String productName){
        return Query.query(Criteria.where("productName").is(productName));
    }

    public Update createUpdateQuery(ProductAvailableQuantity availableQuantity){
        Update update = (new Update()
                .set("productName",availableQuantity.getProductName())
                .set("quantityAvailable",availableQuantity.getQuantityAvailable())
                .set("modifiedDate",new Date()));
        return update;
    }
}
