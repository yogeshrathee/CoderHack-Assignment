package com.example.coderhack.service;

import com.example.coderhack.exception.UserNotFoundException;
import com.example.coderhack.model.User;
import com.example.coderhack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .sorted((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore()))
                .collect(Collectors.toList());
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public User registerUser(User user) {
        user.setScore(0);
        user.setBadges(List.of());
        return userRepository.save(user);
    }

    public User updateUserScore(String userId, int score) {
        User user = getUserById(userId);
        user.setScore(score);
        updateBadges(user);
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        User user = getUserById(userId);
        userRepository.delete(user);
    }

    private void updateBadges(User user) {
        int score = user.getScore();
        if (score >= 1 && score < 30) {
            user.setBadges(List.of("Code Ninja"));
        } else if (score >= 30 && score < 60) {
            user.setBadges(List.of("Code Ninja", "Code Champ"));
        } else if (score >= 60 && score <= 100) {
            user.setBadges(List.of("Code Ninja", "Code Champ", "Code Master"));
        }
    }
}
