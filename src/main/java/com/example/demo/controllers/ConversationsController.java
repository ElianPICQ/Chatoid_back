package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ConversationCard;
import com.example.demo.models.Conversations;
import com.example.demo.repositories.ConversationsRepository;

@RestController
@RequestMapping("api")
public class ConversationsController {
  
  @Autowired
  private ConversationsRepository repository;

  // Get all Conversations of a user
/*   @GetMapping("/{id}/accueill")
  public List<Conversations> findAllUserConversations(@PathVariable String id) {
    int userId = Integer.parseInt(id);
    return repository.findAllUserConversations(userId);
  } */

  @GetMapping("/{id}/accueil")
  public List<ConversationCard> findAllUserConversations2(@PathVariable String id) {
    int userId = Integer.parseInt(id);

    // Get all conversations of a user
    List<Conversations> mesConversations = repository.findAllUserConversations(userId);
    List<ConversationCard> mesConversationCards = new ArrayList<>();

    for (Conversations maConversation : mesConversations)
    {
      System.out.println("Conversationnnnnnnn");
      ConversationCard maConversationCard = repository.findUserConversation(userId, maConversation.getId_conversation());
      
    }

    return mesConversationCards;
  }
}
