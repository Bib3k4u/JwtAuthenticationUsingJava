package com.jwtauthentication.demo.repository;

import com.jwtauthentication.demo.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
        Optional<UserInfo> findByName(String name);
        Optional<UserInfo> findByEmail(String email); // Add this line
}
