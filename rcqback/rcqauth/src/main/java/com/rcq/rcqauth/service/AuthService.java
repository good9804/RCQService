package com.rcq.rcqauth.service;

import com.rcq.rcqauth.entity.User;
import com.rcq.rcqauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public int mailCheck(String mail){
        User user = userRepository.findByusermail(mail);
        if(user != null) {
            // 이메일이 이미 존재하는 경우
            return 0;
        } else {
            // 이메일이 존재하지 않는 경우
            return 1;
        }
    }

    @Transactional
    public User saveUser(String useremail, String password) {
        // 새로운 사용자 객체 생성
        User user = new User();
        user.setUsermail(useremail);
        user.setPassword(password);

        // 사용자 저장
        return userRepository.save(user);
    }

}
