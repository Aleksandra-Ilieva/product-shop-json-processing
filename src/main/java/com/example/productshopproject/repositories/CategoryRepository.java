package com.example.productshopproject.repositories;


import com.example.productshopproject.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
