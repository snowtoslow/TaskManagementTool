package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<Object> createTask(Task task){//добавить респонс бади
        Task savedTask = taskRepository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}")
                .build(savedTask.getTaskId());

        return ResponseEntity.created(location).build();
    }


    public List<Task> readAllTasks(){
        return taskRepository.findAll();
    }

    public Task readATaskById(int taskId){
        Optional<Task> task = taskRepository.findById(taskId);//костыль надо поменять

        if (!task.isPresent()) {
            System.out.println("There is no task with such id: " + taskId);
        }
        return task.get();
    }


    public ResponseEntity<Object> updateTask(Task task,int taskId){
        Optional<Task> taskOptional = taskRepository.findById(taskId);

        if(!taskOptional.isPresent())
            return ResponseEntity.notFound().build();
        task.setTaskTd(taskId);
        taskRepository.save(task);
        return ResponseEntity.noContent().build();
    }

    public void deleteTask(int taskId){
        taskRepository.deleteById(taskId);
    }


}
