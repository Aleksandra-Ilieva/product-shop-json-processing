package com.example.productshopproject.repositories;


import com.example.productshopproject.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u" +
            " JOIN u.soldProducts p" +
            " WHERE p.buyer IS NOT NULL")
    List<User> findAllWithSoldProducts();
}
