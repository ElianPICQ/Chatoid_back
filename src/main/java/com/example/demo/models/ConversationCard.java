package com.example.demo.models;

import java.time.LocalDateTime;

public class ConversationCard {

  private String title;
  private String message;
  private LocalDateTime date_created;

  public ConversationCard() {
  }

  public ConversationCard(LocalDateTime date_created, String message, String title) {
      this.date_created = date_created;
      this.message = message;
      this.title = title;
  }

  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }

  public LocalDateTime getDate_created() {
      return date_created;
  }

  public void setDate_created(LocalDateTime date_created) {
      this.date_created = date_created;
  }
}