package com.example.chat.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
public class Session {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String clientId;

    private String currentManagerId;

    @OneToMany(mappedBy = "session")
    private List<Message> messages;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Type type;

    @CreatedDate
    private Date createdAt;

    public enum Status {
        WAITING, ACTIVE, CLOSED
    }

    enum Type {
        CREDIT,
        MORTGAGE,
        DEPOSITS,
        INSURANCE
    }
}

