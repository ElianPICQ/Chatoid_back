package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;

@RestController
@RequestMapping("api")
public class UsersController {
   
  @Autowired
  private UsersRepository repository;

  // Get all Users
  @GetMapping("/users")
  public List<Users> index(){
      return repository.findAll();
  }

  // User connection
  @PostMapping("/connexion")
  public Users search(@RequestBody Map<String, String> body){
    String email = body.get("email");
    String password = body.get("password");
    return repository.findByEmailAndPassword(email, password);
  }
}
