package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task){//добавить респонс бади
        Task savedTask = taskRepository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}")
                .build(savedTask.getTaskId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/tasks")//Read
    public List<Task> readAllTasks(){
        return taskRepository.findAll();
    }

    //Read a specific task by Id;
    @GetMapping("/tasks/{taskId}")
    public Task readATaskById(@PathVariable int taskId){
        Optional<Task> task = taskRepository.findById(taskId);//костыль надо поменять

        if (!task.isPresent()){
            System.out.println("There is no task with such id: "+taskId);
        }
        return task.get();
    }


    @PutMapping("/tasks/{taskId}")
    public ResponseEntity<Object> updateTask(@RequestBody Task task, @PathVariable int taskId){
        Optional<Task>  taskOptional = taskRepository.findById(taskId);

        if(!taskOptional.isPresent())
            return ResponseEntity.notFound().build();
        task.setTaskTd(taskId);
        taskRepository.save(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("tasks/{taskId}")
    public void deleteTask(@PathVariable int taskId){
        taskRepository.deleteById(taskId);
    }


}
