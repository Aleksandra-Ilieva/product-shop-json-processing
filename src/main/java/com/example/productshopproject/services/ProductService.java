package com.example.productshopproject.services;

import org.springframework.data.jpa.repository.Query;

public interface ProductService {

   
    String getAllProductsWithPriceInRangeWithoutBuyer(int lower, int highest);

    String getAllCategories();


}
