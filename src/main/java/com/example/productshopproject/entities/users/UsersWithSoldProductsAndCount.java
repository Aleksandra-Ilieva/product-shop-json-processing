package com.example.productshopproject.entities.users;



import com.example.productshopproject.entities.products.SoldProductsWithCountDto;

import java.util.List;

public class UsersWithSoldProductsAndCount {


    private String firstName;

    private String lastName;

    private SoldProductsWithCountDto soldProductsCount;

    public UsersWithSoldProductsAndCount() {

    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SoldProductsWithCountDto getSoldProductsCount() {
        return soldProductsCount;
    }

    public void setSoldProductsCount(SoldProductsWithCountDto soldProductsCount) {
        this.soldProductsCount = soldProductsCount;
    }
}
