package com.example.Hacker.Service;

import com.example.Hacker.Entity.User;
import com.example.Hacker.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getUserById(String userId){
        return userRepo.findById(userId).orElse(null);
    }

    public User registerUser(User user) {
        user.setScore(0);
        user.setBadges(new ArrayList<>());
        return userRepo.save(user);
    }

    public User updateUserScore(String userId, int score) {
        User user = getUserById(userId);
        if (user != null) {
            user.setScore(score);
            updateBadges(user);
            userRepo.save(user);
        }
        return user;
    }

    public void deleteUser(String userId) {
        userRepo.deleteById(userId);
    }

    private void updateBadges(User user) {
        List<String> badges = new ArrayList<>();
        if (user.getScore() >= 1 && user.getScore() < 30) {
            badges.add("Code Ninja");
        }
        if (user.getScore() >= 30 && user.getScore() < 60) {
            badges.add("Code Champ");
        }
        if (user.getScore() >= 60 && user.getScore() <= 100) {
            badges.add("Code Master");
        }
        user.setBadges(badges);
    }

}
