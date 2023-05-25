package com.example.chat.controller;

import com.example.chat.model.Session;
import com.example.chat.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    SessionRepository repo;

    @PostMapping("/{sessionId}/close")
    public ResponseEntity<Void> close(@PathVariable long sessionId) {
        Optional<Session> sessionOpt = repo.findById(sessionId);
        if (sessionOpt.isPresent()) {
            Session session = sessionOpt.get();
            repo.save(session.toBuilder().status(Session.Status.CLOSED).build());
            return ResponseEntity.ok().build();
        } else return ResponseEntity.badRequest().build();
    }

    @GetMapping("clients/{clientId}")
    public ResponseEntity<List<Session>> getByClientId(@PathVariable String clientId) {
        return ResponseEntity.ok(repo.findByClientId(clientId));
    }

    @GetMapping("managers/{currentManagerId}")
    public ResponseEntity<List<Session>> getByManagerId(@PathVariable String currentManagerId) {
        return ResponseEntity.ok(repo.findByCurrentManagerId(currentManagerId));
    }

    @PostMapping("/create")
    public ResponseEntity<Session> create(@RequestBody Session session) {
        return ResponseEntity.ok(repo.save(session));
    }

    @PutMapping("/update")
    public ResponseEntity<Session> update(@RequestBody Session session) {
        return ResponseEntity.ok(repo.save(session));
    }
}
