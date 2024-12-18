package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id_user;

  private String lastname;
  private String firstname;
  private String email;
  private String phone;
  private String profile_picture;
  private String job;
  private String password;
  private Boolean is_blocked;
  private int id_role;

  public Users() {
  }

  public Users(int id_user, String email, String firstname, Boolean is_blocked, String lastname, String password, String phone, String job, String profile_picture, int id_role) {
    this.id_user = id_user;
    this.email = email;
    this.firstname = firstname;
    this.is_blocked = is_blocked;
    this.lastname = lastname;
    this.password = password;
    this.phone = phone;
    this.job = job;
    this.profile_picture = profile_picture;
    this.id_role = id_role;
  }

  public Users(String email, String firstname, Boolean is_blocked, String lastname, String password, String phone, String job, String profile_picture, int id_role) {
    this.email = email;
    this.firstname = firstname;
    this.is_blocked = is_blocked;
    this.lastname = lastname;
    this.password = password;
    this.phone = phone;
    this.job = job;
    this.profile_picture = profile_picture;
    this.id_role = id_role;
  }

  public Users(int id_user, String email, String firstname, String lastname, String phone, String job, String profile_picture) {
    this.id_user = id_user;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.job = job;
    this.profile_picture = profile_picture;
  }

  public int getId_user() {
      return id_user;
  }

  public void setId_user(int id_user) {
      this.id_user = id_user;
  }

  public String getLastname() {
      return lastname;
  }

  public void setLastname(String lastname) {
      this.lastname = lastname;
  }

  public String getFirstname() {
      return firstname;
  }

  public void setFirstname(String firstname) {
      this.firstname = firstname;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getPhone() {
      return phone;
  }

  public void setPhone(String phone) {
      this.phone = phone;
  }

  public String getJob() {
      return job;
  }

  public void setJob(String job) {
      this.job = job;
  }

  public String getProfile_picture() {
      return profile_picture;
  }

  public void setProfile_picture(String profile_picture) {
      this.profile_picture = profile_picture;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public Boolean getIs_blocked() {
      return is_blocked;
  }

  public void setIs_blocked(Boolean is_blocked) {
      this.is_blocked = is_blocked;
  }

  public int getRole() {
      return id_role;
  }

  public void setRole(int id_role) {
      this.id_role = id_role;
  }
}
