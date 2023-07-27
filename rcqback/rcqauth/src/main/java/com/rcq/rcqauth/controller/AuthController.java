package com.rcq.rcqauth.controller;

import com.rcq.rcqauth.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {


    @GetMapping("/user/login")
    @ResponseBody
    public int emailDuplicateCheck(@RequestParam("email") String email){
        int isDupli= AuthService


        return false;
    }
}
