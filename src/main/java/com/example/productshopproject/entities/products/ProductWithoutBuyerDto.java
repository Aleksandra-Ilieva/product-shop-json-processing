package com.example.productshopproject.entities.products;

import java.math.BigDecimal;

public class ProductWithoutBuyerDto {

    private String name;
    private BigDecimal price;


    private String sellerFullName;

    public ProductWithoutBuyerDto(String name, BigDecimal price,String firstName,String lastName) {
        this.name = name;
        this.price = price;
        this.sellerFullName=firstName+" "+lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }
}
