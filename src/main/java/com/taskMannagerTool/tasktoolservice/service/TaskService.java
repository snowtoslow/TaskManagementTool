package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//@RestController
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    //если будут ошибки глянуть еще раз код чела из гайда
    public ResponseEntity<Object> createTask(Task task){//добавить респонс бади
        Task savedTask = taskRepository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}")
                .build(savedTask.getTaskId());

        return ResponseEntity.created(location).build();
    }

    //@GetMapping("/user")//Read
    public List<Task> readAllTasks(){
        return taskRepository.findAll();
    }

    //Read a specific task by Id;
    //@GetMapping("/user/{id}")
    public Task readATaskById(int id){
        Optional<Task> task = taskRepository.findById(id);//костыль надо поменять

        if (!task.isPresent()){
            System.out.println("There is not task with such id: "+id);
        }
        return task.get();
    }

}
