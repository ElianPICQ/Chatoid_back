package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Messages;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
   
  @Query(value = "SELECT m.* FROM Users u, Messages m, Conversations c " +
        "WHERE c.id_conversation = m.id_conversation AND m.id_user = u.id_user AND c.id_conversation = ?1" +
        "ORDER BY date_created ASC;", nativeQuery = true)
  List<Messages> getMessagesConversation(int conversationId);


  @Query(value="SELECT m.* FROM Messages m WHERE m.id_conversation = ?1 ORDER BY m.date_created DESC LIMIT 1;", nativeQuery = true)
  Messages getLastMessage(int conversationId);


}