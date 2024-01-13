package com.at0m.common.service;

import com.at0m.common.model.Product;
import com.at0m.common.model.ProductAvailableQuantity;
import com.at0m.common.util.AvailableQuantityUtil;
import com.mongodb.MongoBulkWriteException;
import com.mongodb.bulk.BulkWriteError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@Slf4j
public class AvailableQuantityService {
    private final MongoTemplate mongoTemplate;
    private final AvailableQuantityUtil availableQuantityUtil;

    public AvailableQuantityService(MongoTemplate mongoTemplate, AvailableQuantityUtil availableQuantityUtil){
        this.mongoTemplate = mongoTemplate;
        this.availableQuantityUtil = availableQuantityUtil;
    }

    public List<ProductAvailableQuantity> getAllList(){
        return mongoTemplate.findAll(ProductAvailableQuantity.class);
    }

    public List<ProductAvailableQuantity> saveAll(List<ProductAvailableQuantity> quantityWithProducts){
        BulkOperations bulkOps = this.mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, ProductAvailableQuantity.class);
        availableQuantityUtil.removeDuplicatesFromList(quantityWithProducts);
        Iterator iterator = quantityWithProducts.iterator();
        while(iterator.hasNext()){
            ProductAvailableQuantity availableQuantity = (ProductAvailableQuantity) iterator.next();
            Query query = availableQuantityUtil.createQuery(availableQuantity.getProductName());
            Update update = availableQuantityUtil.createUpdateQuery(availableQuantity);
            bulkOps.upsert(query,update);
        }
        try {
            bulkOps.execute();
        } catch(DuplicateKeyException duplicateKeyException) {
            Throwable cause = duplicateKeyException.getCause();
            if(cause instanceof MongoBulkWriteException) {
                MongoBulkWriteException mongoBulkWriteException = (MongoBulkWriteException) cause;
                List<BulkWriteError> bulkWriteErrors = mongoBulkWriteException.getWriteErrors();
                bulkWriteErrors.forEach(bulkWriteError -> {
                    log.info(bulkWriteError.getIndex() + " Is already present in Database");
                });
            }
        }
        return quantityWithProducts;
    }

    public ProductAvailableQuantity getByProductName(String productName) {
        List<ProductAvailableQuantity> availableQuantityByName = mongoTemplate.find(query(where("productName").is(productName)), ProductAvailableQuantity.class);
        if(!availableQuantityByName.isEmpty()){
            return availableQuantityByName.get(0);
        }
        else{
            return null;
        }
    }

    public ProductAvailableQuantity saveAvailableQuantity(ProductAvailableQuantity productAvailableQuantity) {
        if(mongoTemplate.find(query(where("productName").is(productAvailableQuantity.getProductName())), Product.class).size()==0){
            return mongoTemplate.save(productAvailableQuantity);
        } else {
            return null;
        }
    }

    public void deleteAvailableQuantities() {
        try {
            mongoTemplate.dropCollection("productAvailableQuantity");
        } catch (Exception e) {
            log.error("Error deleting Collection");
        }
    }
}
