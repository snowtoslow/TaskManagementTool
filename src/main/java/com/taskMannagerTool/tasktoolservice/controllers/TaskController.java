package com.taskMannagerTool.tasktoolservice.controllers;



import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class TaskController implements TaskService {

    @Autowired
    private TaskService taskService;


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

    @PutMapping("/tasks/update")
    public ResponseEntity<Object> updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable int taskId) {
        taskService.deleteTask(taskId);
    }





}
