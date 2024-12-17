package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
   
  // custom query to search in contact
  List<Users> findByFirstnameContaining(String text);
   
  // custom query to find a User with email & password
  Users findByEmailAndPassword(String email, String password);
}