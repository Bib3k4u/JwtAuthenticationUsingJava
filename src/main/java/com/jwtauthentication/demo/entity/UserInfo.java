package com.jwtauthentication.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    @Id
    private String id; // Change to String for MongoDB
    private String name;
    private String email;
    private String password;
    private String roles;
}
