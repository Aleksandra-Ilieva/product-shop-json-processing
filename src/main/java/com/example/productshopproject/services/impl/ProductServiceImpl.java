package com.example.productshopproject.services.impl;


import com.example.productshopproject.entities.categories.CategoryStatisticDto;
import com.example.productshopproject.entities.products.ProductWithoutBuyerDto;
import com.example.productshopproject.repositories.ProductRepository;
import com.example.productshopproject.services.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private Gson gson;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public String getAllProductsWithPriceInRangeWithoutBuyer(int lowerBound, int highestBound) {
        BigDecimal actualLowerBound = BigDecimal.valueOf(lowerBound);
        BigDecimal actualHighestBound = BigDecimal.valueOf(highestBound);

        List<ProductWithoutBuyerDto> productWithoutBuyerDtoList = this.productRepository.findAllByPriceBetweenAndBuyerIsNull(actualLowerBound, actualHighestBound);

        String json   = this.gson.toJson(productWithoutBuyerDtoList);



        return json;
    }

    @Override
    public String getAllCategories() {
     List<CategoryStatisticDto> categoryStatisticDtoList=   this.productRepository.selectAllCategories();

     String json = this.gson.toJson(categoryStatisticDtoList);
        return json;

    }


}
