package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conversations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_conversation;
  
  private Boolean is_group;
  private String title;
  private Integer id_admin;

  public Conversations() {
  }

  public Conversations(int id_conversation, Boolean is_group, String title, Integer id_admin) {
    this.id_conversation = id_conversation;
    this.is_group = is_group;
    this.title = title;
    this.id_admin = id_admin;
  }

  public Conversations(Boolean is_group, String title, Integer id_admin) {
    this.is_group = is_group;
    this.title = title;
    this.id_admin = id_admin;
  }

  public int getId_conversation() {
    return id_conversation;
  }

  public void setId_conversation(int id_conversation) {
    this.id_conversation = id_conversation;
  }

  public Boolean getIs_group() {
    return is_group;
  }

  public void setIs_group(Boolean is_group) {
    this.is_group = is_group;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getId_admin() {
    return id_admin;
  }

  public void setId_admin(Integer id_admin) {
    this.id_admin = id_admin;
  }
}