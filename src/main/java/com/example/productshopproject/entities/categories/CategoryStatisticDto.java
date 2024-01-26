package com.example.productshopproject.entities.categories;

import java.math.BigDecimal;

public class CategoryStatisticDto {

    private String categoryName;

    private long productsCount;


    private double averagePrice;

    private BigDecimal totalRevenue;

    public CategoryStatisticDto(String categoryName, long productsCount, double averagePrice, BigDecimal totalRevenue) {
        this.categoryName = categoryName;
        this.productsCount = productsCount;
        this.averagePrice = averagePrice;
        this.totalRevenue = totalRevenue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(long productsCount) {
        this.productsCount = productsCount;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}