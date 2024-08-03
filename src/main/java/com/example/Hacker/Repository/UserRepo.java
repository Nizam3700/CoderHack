package com.example.Hacker.Repository;

import com.example.Hacker.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
