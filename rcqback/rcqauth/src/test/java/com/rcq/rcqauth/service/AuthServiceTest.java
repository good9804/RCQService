package com.rcq.rcqauth.service;

import com.rcq.rcqauth.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AuthServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthService authService;
    @Test
    void mailCheck() {

    }

    @Test
    void saveUser() {
        authService.saveUser("sdsd@naver.com","1234");
        assertThat(userRepository).isNotNull();
        assertThat(authService.mailCheck("sdsd@naver.com")).isEqualTo("0");
    }
}