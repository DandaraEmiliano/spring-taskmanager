package com.dandara.taskmanager.controller;

import com.dandara.taskmanager.dto.TaskDTO;
import com.dandara.taskmanager.entity.Task;
import com.dandara.taskmanager.exception.NotFoundException;
import com.dandara.taskmanager.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Operation(summary = "Get all tasks")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Operation(summary = "Create a new task")
    @PostMapping
    public Task createTask(@RequestBody TaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.loadCreatedAt();
        return taskRepository.save(task);

    }
    @Operation(summary = "Get a task by ID")
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    }
    @Operation(summary = "Update a task by ID")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskDTO dto) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return taskRepository.save(task);
    }
    @Operation(summary = "Delete a task by ID")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
