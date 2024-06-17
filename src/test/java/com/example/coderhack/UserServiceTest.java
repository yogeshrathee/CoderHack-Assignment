package com.example.coderhack;

import com.example.coderhack.model.User;
import com.example.coderhack.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setId("testId");
        user.setUsername("testUser");
        User savedUser = userService.registerUser(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getScore()).isEqualTo(0);
        assertThat(savedUser.getBadges()).isEmpty();
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertThat(users).isNotNull();
    }

    @Test
    public void testUpdateUserScore() {
        User user = userService.updateUserScore("testId", 50);
        assertThat(user.getScore()).isEqualTo(50);
        assertThat(user.getBadges()).containsExactly("Code Ninja", "Code Champ");
    }
}
