package com.example.chat.model;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="session_id", nullable=false)
    private Session session;

    @Column(nullable = false)
    private String managerId;

    @Column(nullable = false)
    private String clientId;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    private Date createdAt;

}
