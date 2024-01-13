package com.at0m.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "product")
public class Product {

    @NotNull(message = "productName cannot be null")
    private String productName;
    @NotNull
    private String price;
    @Transient
    private int quantityAvailable;
    private Date modifiedDate;

    public Product(ProductBuilder builder){
        this.productName=builder.productName;
        this.price=builder.price;
        this.quantityAvailable=builder.quantityAvailable;
        this.modifiedDate=builder.modifiedDate;
    }

    public static class ProductBuilder {
        private String productName;
        private String price;
        private int quantityAvailable;
        private Date modifiedDate;
        public ProductBuilder(String productName, String price, int quantityAvailable) {
            this.productName=productName;
            this.price=price;
            this.quantityAvailable=quantityAvailable;
        }

        public ProductBuilder setModifiedDate(Date modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
