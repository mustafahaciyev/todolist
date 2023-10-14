package com.example.todolist.service.impl;

import com.example.todolist.config.Mapper;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.entity.Task;
import com.example.todolist.repos.TaskRepository;
import com.example.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Mapper mapper;


    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task taskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Task not found"));
    }

    @Override
    public void saveTask(TaskDto taskDto) {
        Task task = mapper.getMapper().map(taskDto, Task.class);
        taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
       if (taskRepository.existsById(id)){
           task.setId(id);
           taskRepository.save(task);
       }
       return null;
    }

    @Override
    public void deleteTask(Long id) {
         taskRepository.deleteById(id);
    }
}
