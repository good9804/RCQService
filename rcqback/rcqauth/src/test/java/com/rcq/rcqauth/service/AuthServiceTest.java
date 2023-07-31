package com.rcq.rcqauth.service;

import com.rcq.rcqauth.dto.loginUserDto;
import com.rcq.rcqauth.entity.User;
import com.rcq.rcqauth.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @Test
    @DisplayName("로그인 mail check 테스트")
    void checkUserMail(){
        authService.saveUser("test@gmail.com","1234");
        assertThat(authService.checkUserMail("test@gmail.com")).isNotNull();
    }

    @Test
    @DisplayName("로그인 password check 테스트")
    void checkUserPassword(){
        authService.saveUser("test4@gmail.com","1234");
        User user=authService.checkUserMail("test4@gmail.com");

        assertThat(authService.checkUserPassword("1234",user.getPassword())).isEqualTo(true);
    }

    @Test
    @DisplayName("로그인 check 테스트")
    void checkUserLogin(){
        authService.saveUser("test3@gmail.com","1234");


        assertThat(authService.checkUserLogin("test3@gmail.com","1234")).isEqualTo(0);
    }

}