package com.example.chat.repo;

import com.example.chat.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByClientId(String clientId);
    List<Session> findByCurrentManagerId(String currentManagerId);
}
