package com.taskMannagerTool.tasktoolservice.controllers;



import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
public class TaskController extends TaskServiceImpl {

    @Autowired
    private TaskServiceImpl taskServiceImpl;


    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        return taskServiceImpl.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> readAllTasks() {
        return taskServiceImpl.readAllTasks();
    }

    @GetMapping("/tasks/{taskId}")
    public Task readATaskById(@PathVariable int taskId) {
        return taskServiceImpl.readATaskById(taskId);
    }



    @PutMapping("/tasks/update/{taskId}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task,@PathVariable int taskId) {
        return taskServiceImpl.updateTask(task,taskId);
    }

    @DeleteMapping("/tasks/delete/{taskId}")
    public void deleteTask(@PathVariable int taskId) {
        taskServiceImpl.deleteTask(taskId);
    }





}
