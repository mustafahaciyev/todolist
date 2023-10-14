package com.example.todolist.service;

import com.example.todolist.dto.LoginDto;

public interface LoginService {
    boolean auth(LoginDto loginDto);
}
