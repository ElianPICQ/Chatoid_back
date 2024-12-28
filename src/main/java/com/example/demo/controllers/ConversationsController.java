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
import com.example.demo.models.Messages;
import com.example.demo.models.Users;
import com.example.demo.repositories.ConversationsRepository;
import com.example.demo.repositories.MessagesRepository;
import com.example.demo.repositories.UsersRepository;

@RestController
@RequestMapping("api")
public class ConversationsController {
  
  @Autowired
  private ConversationsRepository repository;
  @Autowired
  private UsersRepository usersRepository;
  @Autowired
  private MessagesRepository messagesRepository;

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
      Messages lastMessage = messagesRepository.getLastMessage(maConversation.getId_conversation());
      Users otherUser = usersRepository.getOtherUser(userId, maConversation.getId_conversation());
      
      if (lastMessage != null && otherUser != null) {
        mesConversationCards.add(new ConversationCard(maConversation.getId_conversation(), lastMessage.getDateCreated(), lastMessage.getMessage(), otherUser.getFirstname()));
      }
    }

    return mesConversationCards;
  }
}
