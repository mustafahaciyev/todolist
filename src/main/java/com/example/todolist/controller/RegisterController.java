package com.example.todolist.controller;

import com.example.todolist.dto.RegisterDto;
import com.example.todolist.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<String> saveRegister(@RequestBody RegisterDto registerDto){
        try {
            registerService.saveRegister(registerDto);
            return ResponseEntity.ok("Kayıt başarılı!");
        } catch (Exception e) {
            // Hata durumunda
            String errorMessage = "Kayıt başarısız: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
