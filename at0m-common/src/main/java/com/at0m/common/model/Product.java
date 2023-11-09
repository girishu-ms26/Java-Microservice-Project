package com.at0m.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
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
}
