package com.example.todolist.service.impl;

import com.example.todolist.dto.LoginDto;
import com.example.todolist.entity.Register;
import com.example.todolist.repos.RegisterRepository;
import com.example.todolist.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RegisterRepository registerRepository;
    @Override
    public boolean auth(LoginDto loginDto) {
        Register register = registerRepository.findByEmail(loginDto.getEmail());
        if (register != null && register.getPassword().equals(loginDto.getPassword())) {
            return true;
        }else {
            return false;
        }
    }


}
