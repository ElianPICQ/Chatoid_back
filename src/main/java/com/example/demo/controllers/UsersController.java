package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  // User connection
  @PostMapping("/connexion")
  public Users search(@RequestBody Map<String, String> body){
    String email = body.get("email");
    String password = body.get("password");
    return repository.findByEmailAndPassword(email, password);
  }

  // Get all Users except connected
  @GetMapping("/{id}/rechercher")
  public List<Users> findAllOtherUsers(@PathVariable String id) {
    int userId = Integer.parseInt(id);
    return repository.findAllOtherUsers(userId);
  }

  // Get user infos
  @PostMapping("/profil")
  public Users getUser(@RequestBody Map<String, String> body){
    String idUserString = body.get("id_user");
    int idUser = Integer.parseInt(idUserString);

    return repository.findUserById(idUser);
  }

  // Update user infos
  @PutMapping("/profil/update")
  public Users updateUser(@RequestBody Map<String, String> body){
    String idUserString = body.get("id_user");
    int idUser = Integer.parseInt(idUserString);

    Users user = repository.findById(idUser).get();

    user.setPhone(body.get("phone"));
    user.setJob(body.get("job"));

    return repository.save(user);
  }
}
