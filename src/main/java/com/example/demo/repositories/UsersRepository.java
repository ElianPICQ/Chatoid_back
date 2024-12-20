package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
   
  // custom query to search in contact
  List<Users> findByFirstnameContaining(String text);
   
  // custom query to find a User with email & password
  Users findByEmailAndPassword(String email, String password);

  @Query(value = "SELECT * FROM Users EXCEPT SELECT * FROM Users WHERE id_user = ?1", nativeQuery = true)
  List<Users> findAllOtherUsers(int userId);

  @Query(value = "SELECT * FROM Users WHERE id_user = ?1", nativeQuery = true)
  Users findUserById(int userId);

  
  // Gets the user i'm talking to
  // Needs the conversation id and connected user id
  @Query(value="SELECT u.* " +
        "FROM Users u " +
        "JOIN Participate p ON u.id_user = p.id_user " +
        "JOIN  Conversations c ON p.id_conversation = c.id_conversation " +
        "WHERE  c.id_conversation = 2 " +
        "AND u.id_user <> 2;", nativeQuery = true)
  Users getOtherUser(int userId, int conversationId);

//  void  updateUser(int userId, String phone, String job);
}