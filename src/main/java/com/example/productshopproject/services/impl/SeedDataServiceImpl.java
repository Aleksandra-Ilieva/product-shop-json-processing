package com.example.productshopproject.services.impl;


import com.example.productshopproject.entities.categories.Category;
import com.example.productshopproject.entities.categories.CategoryDto;
import com.example.productshopproject.entities.products.Product;
import com.example.productshopproject.entities.products.ProductDto;
import com.example.productshopproject.entities.users.User;
import com.example.productshopproject.entities.users.UserDto;
import com.example.productshopproject.repositories.CategoryRepository;
import com.example.productshopproject.repositories.ProductRepository;
import com.example.productshopproject.repositories.UserRepository;
import com.example.productshopproject.services.SeedDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SeedDataServiceImpl implements SeedDataService {

    private static final Path USER_PATH  = Path.of("src","main","resources","users.json");

    private static final Path PRODUCT_PATH  = Path.of("src","main","resources","products.json");
    private static final Path CATEGORY_PATH  = Path.of("src","main","resources","categories.json");
    private UserRepository userRepository;

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    private Gson gson;

    private ModelMapper mapper;


    @Autowired

    public SeedDataServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;


        this.gson=new GsonBuilder().setPrettyPrinting().create();
        this.mapper=new ModelMapper();
    }

    @Override
    public void seedUser() throws FileNotFoundException {
        FileReader reader = new FileReader(USER_PATH.toString());

       UserDto[] userDtos=  this.gson.fromJson(reader, UserDto[].class);

        List<User> userStream = Arrays.stream(userDtos).map(userDto -> mapper.map(userDto, User.class)).collect(Collectors.toList());
        this.userRepository.saveAll(userStream);


    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader reader = new FileReader(PRODUCT_PATH.toString());

       ProductDto[] productDtos= this.gson.fromJson(reader, ProductDto[].class);


        List<Product> products = Arrays.stream(productDtos).map(productDto -> mapper.map(productDto, Product.class))
                .map(this::setRandomSeller).map(this::setRandomBuyer).map(this::setRandomCategories).collect(Collectors.toList());



        this.productRepository.saveAll(products);

    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader reader = new FileReader(CATEGORY_PATH.toString());

        CategoryDto[] categoryDtos = this.gson.fromJson(reader, CategoryDto[].class);

        List<Category> categoryList = Arrays.stream(categoryDtos).map(categoryDto -> mapper.map(categoryDto, Category.class)).collect(Collectors.toList());
        this.categoryRepository.saveAll(categoryList);
    }

    public Product setRandomBuyer(Product product){
        if (product.getPrice().compareTo(BigDecimal.valueOf(700)) > 0) {
            return product;
        }

        Random random = new Random();
        long countUsers = this.userRepository.count();

        int  id = (int) (random.nextLong(countUsers)+1);

        User buyer= this.userRepository.findById(id).get();

        product.setBuyer(buyer);
        return product;

    }

    public Product setRandomCategories(Product product){
        Random random = new Random();



        int countCategories= (int) this.categoryRepository.count();
        int countCategoriesPerProduct=random.nextInt(countCategories);

        for (int i = 0; i < countCategoriesPerProduct; i++) {
            int randomId =random.nextInt(countCategories)+1;

            Category category = this.categoryRepository.findById(randomId).get();
            product.getCategories().add(category);


        }


        return product;

    }

    public Product setRandomSeller(Product product){
        Random random = new Random();
        long countUsers = this.userRepository.count();

        int  id = (int) (random.nextLong(countUsers)+1);

        User seller = this.userRepository.findById(id).get();
        product.setSeller(seller);

        return product;


    }
}
