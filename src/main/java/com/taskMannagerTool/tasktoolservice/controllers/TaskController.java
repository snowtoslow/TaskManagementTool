package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.service.TaskService;
import com.taskMannagerTool.tasktoolservice.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController implements TaskService {
    @Autowired
    TaskServiceImpl taskService = new TaskServiceImpl();

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> readAllTasks() {
        return taskService.readAllTasks();
    }

    @GetMapping("/tasks/{taskId}")
    public Task readATaskById(@PathVariable int taskId) {
        return taskService.readATaskById(taskId);
    }

    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Object> updateTask(Task task, int taskId) {
        return taskService.updateTask(task,taskId);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(int taskId) {
        taskService.deleteTask(taskId);
    }
}
