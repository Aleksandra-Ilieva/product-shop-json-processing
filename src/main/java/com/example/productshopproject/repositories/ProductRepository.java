package com.example.productshopproject.repositories;


import com.example.productshopproject.entities.categories.CategoryStatisticDto;
import com.example.productshopproject.entities.products.Product;
import com.example.productshopproject.entities.products.ProductWithoutBuyerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {


    @Query("SELECT new com.example.productshopproject.entities.products.ProductWithoutBuyerDto (" +
            "p.name,p.price,p.seller.firstName,p.seller.lastName) from Product p " +
            " where p.price > :actualLowerBound and p.price<:actualHighestBound and p.buyer is null " +
            " order by p.price asc ")
    List<ProductWithoutBuyerDto> findAllByPriceBetweenAndBuyerIsNull(BigDecimal actualLowerBound, BigDecimal actualHighestBound);

    @Query("SELECT new  com.example.productshopproject.entities.categories.CategoryStatisticDto (" +
            "c.name,count(p.id),avg(p.price),sum(p.price) ) FROM Product p " +
            " join p.categories c" +
            " group by c.id" +
            " order by count(p.id)")
    List<CategoryStatisticDto> selectAllCategories();
}
