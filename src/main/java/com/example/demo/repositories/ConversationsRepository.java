package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ConversationCard;
import com.example.demo.models.Conversations;

@Repository
public interface ConversationsRepository extends JpaRepository<Conversations, Integer> {
   
  // custom query to search in contact
  // List<Conversations> findByTitleContaining(String text);

  // custom query to get all the conversations of a user
  @Query(value = "SELECT c.id_conversation, c.title, c.is_group, c.id_admin FROM Conversations c, Users u, Participate p WHERE u.id_user = p.id_user AND p.id_conversation = c.id_conversation AND u.id_user = ?1", nativeQuery = true)
  List<Conversations> findAllUserConversations(int userId);

  @Query(value =  "SELECT m.message, m.date_created, CONCAT(u.firstname, \" \", u.lastname) AS tite " +
                  "FROM Messages m " +
                  "JOIN Users u ON u.id_user = (" +
              "        SELECT id_user " +
              "        FROM Participate " +
              "        WHERE id_conversation = m.id_conversation AND id_user != ?1 " +
              "        LIMIT 1) " +
                  "WHERE m.id_conversation = ?2 " +
                  "ORDER BY m.date_created DESC " +
                  "LIMIT 1;", nativeQuery = true)
  ConversationCard findUserConversation (int userId, int conversationId);
}