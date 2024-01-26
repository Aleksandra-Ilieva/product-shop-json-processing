package com.example.productshopproject.entities.users;

import java.util.List;

public class CountOfSellersDto {
 private    int count;

 private    List<UsersWithSoldProductsAndCount> users;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UsersWithSoldProductsAndCount> getUsers() {
        return users;
    }

    public void setUsers(List<UsersWithSoldProductsAndCount> users) {
        this.users = users;
    }

    public CountOfSellersDto() {

    }
}
