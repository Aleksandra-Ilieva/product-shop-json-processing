package com.example.productshopproject.services.impl;


import com.example.productshopproject.entities.products.SoldProductsDto;
import com.example.productshopproject.entities.products.SoldProductsWithCountDto;
import com.example.productshopproject.entities.users.CountOfSellersDto;
import com.example.productshopproject.entities.users.User;
import com.example.productshopproject.entities.users.UserWithSoldProductsDto;
import com.example.productshopproject.entities.users.UsersWithSoldProductsAndCount;
import com.example.productshopproject.repositories.UserRepository;
import com.example.productshopproject.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper mapper;

    private Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

        this.mapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }


    @Override
    @Transactional
    public String getSoldProducts() {

        List<User> user = this.userRepository.findAllWithSoldProducts();

        List<UserWithSoldProductsDto> userWithSoldProductsDtoList = user.stream().map(user1 -> mapper.map(user1, UserWithSoldProductsDto.class)).collect(Collectors.toList());


        String json = this.gson.toJson(userWithSoldProductsDtoList);


        return json;
    }

    @Transactional
    @Override
    public String getUsersAndProducts() {
        List<User> user = this.userRepository.findAllWithSoldProducts();


        CountOfSellersDto mainDto = new CountOfSellersDto();

        List<UsersWithSoldProductsAndCount> usersWithSoldProductsAndCountList = user.stream().map(user1 -> {
            UsersWithSoldProductsAndCount usersWithSoldProductsAndCount = mapper.map(user1, UsersWithSoldProductsAndCount.class);


            List<SoldProductsDto> soldProductsDtos = user1.getSoldProducts().stream().map(product -> mapper.map(product, SoldProductsDto.class)).collect(Collectors.toList());

            SoldProductsWithCountDto soldProductsWithCountDto = new SoldProductsWithCountDto();

            soldProductsWithCountDto.setSoldProductsDtos(soldProductsDtos);
            soldProductsWithCountDto.setCount(soldProductsDtos.size());



            usersWithSoldProductsAndCount.setSoldProductsCount(soldProductsWithCountDto);




            return usersWithSoldProductsAndCount;

        }).sorted(Comparator.comparing(usersWithSoldProductsAndCount -> usersWithSoldProductsAndCount.getSoldProductsCount().getCount(),Comparator.reverseOrder()))
                .collect(Collectors.toList());


        mainDto.setUsers(usersWithSoldProductsAndCountList);
        mainDto.setCount(usersWithSoldProductsAndCountList.size());



        String json = gson.toJson(mainDto);


        return json;
    }
}
