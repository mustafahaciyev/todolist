package com.example.todolist.repos;

import com.example.todolist.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Long> {

    Register findByEmail(String email);

}
