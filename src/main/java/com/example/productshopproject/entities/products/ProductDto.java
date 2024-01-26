package com.example.productshopproject.entities.products;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
