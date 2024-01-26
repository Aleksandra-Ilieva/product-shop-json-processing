package com.example.productshopproject.entities.products;

import java.math.BigDecimal;
import java.util.List;

public class SoldProductsWithCountDto {


   private Integer count;

   private List<SoldProductsDto> soldProductsDtos;

    public SoldProductsWithCountDto() {

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<SoldProductsDto> getSoldProductsDtos() {
        return soldProductsDtos;
    }

    public void setSoldProductsDtos(List<SoldProductsDto> soldProductsDtos) {
        this.soldProductsDtos = soldProductsDtos;
    }
}
