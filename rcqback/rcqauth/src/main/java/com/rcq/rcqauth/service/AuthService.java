package com.rcq.rcqauth.service;

import com.rcq.rcqauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public int emailCheck(String email){
        userRepository.findByUserEmail(email);
    }

}
