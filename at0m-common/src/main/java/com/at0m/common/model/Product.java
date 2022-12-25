package com.at0m.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "product")
public class Product {

    private String productName;
    private String price;
    private boolean availability;
    @Transient
    private int quantityAvailable;
    @Transient
    private String description;
    private Date lastModified;
}
