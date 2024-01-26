package com.example.productshopproject.services;

import java.io.FileNotFoundException;

public interface SeedDataService {
    void seedUser() throws FileNotFoundException;

    void seedProducts() throws FileNotFoundException;

    void seedCategories() throws FileNotFoundException;


}
