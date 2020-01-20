package com.taskMannagerTool.tasktoolservice.service;



import com.taskMannagerTool.tasktoolservice.models.Task;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;


public interface TaskService{


    ResponseEntity<Object> createTask(Task task, Principal principal);//C

    List<Task> readAllTasks();//R

    Task readATaskById(int taskId);//R

    ResponseEntity<Object> updateTask(Task task,int id,Principal principal);//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteTask(int taskId);//D




}
