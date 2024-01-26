package com.example.productshopproject;


import com.example.productshopproject.services.ProductService;
import com.example.productshopproject.services.SeedDataService;
import com.example.productshopproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private SeedDataService seedDataService;

    private ProductService productService;

    private UserService userService;




    @Autowired
    public Runner(SeedDataService seedDataService, ProductService productService, UserService userService) {
        this.seedDataService = seedDataService;
        this.productService = productService;

        this.userService = userService;

    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedDataService.seedUser();
//        this.seedDataService.seedCategories();
//        this.seedDataService.seedProducts();


//       String json= this.productService.getAllProductsWithPriceInRangeWithoutBuyer(500,1000);
//        System.out.println(json);
//
//
//   String json=     this.userService.getSoldProducts();
//       System.out.println(json);
//
//        String json = this.productService.getAllCategories();
//        System.out.println(json);



      String json=  this.userService.getUsersAndProducts();

        System.out.println(json);









    }
}
