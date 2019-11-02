package com.taskMannagerTool.tasktoolservice.service;


import com.taskMannagerTool.tasktoolservice.models.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService{


    ResponseEntity<Object> createTask(Task task);//C

    List<Task> readAllTasks();//R

    Task readATaskById(int taskId);//R

    ResponseEntity<Object> updateTask(Task task);//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteTask(int taskId);//D

}
