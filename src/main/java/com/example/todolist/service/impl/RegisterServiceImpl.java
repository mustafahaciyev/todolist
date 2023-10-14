package com.example.todolist.service.impl;

import com.example.todolist.config.Mapper;
import com.example.todolist.dto.RegisterDto;
import com.example.todolist.entity.Register;
import com.example.todolist.repos.RegisterRepository;
import com.example.todolist.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
    private final Mapper mapper;
    @Override
    public void saveRegister(RegisterDto registerDto) {
        Register map = mapper.getMapper().map(registerDto, Register.class);
        registerRepository.save(map);

    }
}
