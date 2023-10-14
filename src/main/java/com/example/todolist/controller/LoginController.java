package com.example.todolist.controller;

import com.example.todolist.dto.LoginDto;
import com.example.todolist.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<String> authenticate(@RequestBody LoginDto loginDto){
        boolean ifTrue = loginService.auth(loginDto);
        if (ifTrue){
           return ResponseEntity.ok("Login successfully!");
        }else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }


}
