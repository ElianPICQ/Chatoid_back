package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Messages;
import com.example.demo.repositories.MessagesRepository;

@RestController
@RequestMapping("api")
public class MessagesController {

  @Autowired
  private MessagesRepository repository;

  @GetMapping("/{id}/messages")
  public List<Messages> index(@PathVariable String id){
    int conversationId = Integer.parseInt(id);
    return repository.getMessagesConversation(conversationId);
  }

  @PostMapping("/messages")
  public Messages create(@RequestBody Map<String, String> body){
    
    String conversationIdString = body.get("id_conversation");
    String userIdString = body.get("id_user");
    String message = body.get("message");

    int conversationId = Integer.parseInt(conversationIdString);
    int userId = Integer.parseInt(userIdString);

    LocalDateTime date_created = LocalDateTime.now();
    LocalDateTime date_updated = LocalDateTime.now();

    return repository.save(new Messages(message, date_created, date_updated, userId, conversationId));
  }

  @PutMapping("/messages/update")
  public Messages updateMessage(@RequestBody Map<String, String> body){
    
    String MessageIdString = body.get("id_message");
    int MessageId = Integer.parseInt(MessageIdString);

    Messages monMessage = repository.findById(MessageId).get();

    monMessage.setMessage(body.get("message"));
    monMessage.setDateUpdated(LocalDateTime.now());

    return repository.save(monMessage);
  }
  

  @DeleteMapping("/messages/delete/{id}")
  public boolean deleteMessage(@PathVariable String id){
      int messageId = Integer.parseInt(id);
      repository.deleteById(messageId);
      return true;
  }
}