package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Messages {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_message;

  private String message;
  private LocalDateTime dateCreated;
  private LocalDateTime dateUpdated;
  
  private int id_user;
  private int id_conversation;

  public Messages() {
  }

  public Messages(int id_message, String message, LocalDateTime dateCreated, LocalDateTime dateUpdated, int id_user, int id_conversation) {
    this.id_message = id_message;
    this.message = message;
    this.dateUpdated = dateUpdated;
    this.id_user = id_user;
    this.id_conversation = id_conversation;
  }

  public Messages(String message, LocalDateTime dateCreated, LocalDateTime dateUpdated, int id_user, int id_conversation) {
    this.message = message;
    this.dateUpdated = dateUpdated;
    this.dateCreated = dateCreated;
    this.id_user = id_user;
    this.id_conversation = id_conversation;
  }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_conversation() {
        return id_conversation;
    }

    public void setId_conversation(int id_conversation) {
        this.id_conversation = id_conversation;
    }


}
