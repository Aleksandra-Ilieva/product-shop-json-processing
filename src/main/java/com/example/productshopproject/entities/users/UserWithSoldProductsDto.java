package com.example.productshopproject.entities.users;



import com.example.productshopproject.entities.products.SoldProductsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserWithSoldProductsDto {

    private String firstName;

    private String lastName;

    private List<SoldProductsDto> soldProducts;





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

    public List<SoldProductsDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductsDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
