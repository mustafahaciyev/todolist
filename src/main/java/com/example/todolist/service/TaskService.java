package com.example.todolist.service;

import com.example.todolist.dto.TaskDto;
import com.example.todolist.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task taskById(Long id);

    void saveTask(TaskDto taskDto);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}
