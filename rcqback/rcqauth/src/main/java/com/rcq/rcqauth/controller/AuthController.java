package com.rcq.rcqauth.controller;

import com.rcq.rcqauth.dto.apiResponseDto;
import com.rcq.rcqauth.dto.signUpUserDto;
import com.rcq.rcqauth.entity.Response;
import com.rcq.rcqauth.entity.User;
import com.rcq.rcqauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/user/signup/check")
    public ResponseEntity<Response> emailDuplicateCheck(@RequestParam("mail") String mail){
        Response response=new Response();
        if(authService.mailCheck(mail)==0){
            response=Response.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("중복 없음")
                    .result(Collections.emptyList())
                    .count(0).build();
       }else{
            response=Response.builder()
                    .code(HttpStatus.NOT_IMPLEMENTED.value())
                    .httpStatus(HttpStatus.NOT_IMPLEMENTED)
                    .message("중복 존재")
                    .result(Collections.emptyList())
                    .count(0).build();
        } return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping(value = "/user/signup" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> signUpUser(@RequestBody signUpUserDto signupuserdto) {
        Response response=new Response();
     authService.saveUser(signupuserdto.getUsermail(), signupuserdto.getPassword());
        response=Response.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("회원가입 성공")
                .result(null)
                .count(0).build();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
