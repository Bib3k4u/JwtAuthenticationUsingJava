package com.jwtauthentication.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "todos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @Id
    private String id;
    private String userId; // To associate with the user
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

}
