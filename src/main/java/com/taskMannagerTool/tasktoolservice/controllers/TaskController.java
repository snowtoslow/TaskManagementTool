package com.taskMannagerTool.tasktoolservice.controllers;



import com.taskMannagerTool.tasktoolservice.exceptions.UserException;
import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;



@RestController
public class TaskController extends TaskServiceImpl {

    @Autowired
    private TaskServiceImpl taskServiceImpl;




    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task, Principal principal) {
        return taskServiceImpl.createTask(task,principal);
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
    public ResponseEntity<Object> updateTask(@RequestBody Task task,@PathVariable int taskId,Principal principal) {
        return taskServiceImpl.updateTask(task,taskId,principal);
    }

    @DeleteMapping("/tasks/delete/{taskId}")
    public void deleteTask(@PathVariable int taskId) {
        taskServiceImpl.deleteTask(taskId);
    }

    @GetMapping("/tasksByUserId/{username}")
    public List<Task> getTasksByReceiverId(@PathVariable String username) throws UserException {
        return taskServiceImpl.getTasksByReceiverId(username);
    }

    @GetMapping("tasks/logged")
    public List<Task> getTaskBySenderId(Principal principal) throws UserException {
        return taskServiceImpl.getTaskBySenderId(principal);
    }

}
