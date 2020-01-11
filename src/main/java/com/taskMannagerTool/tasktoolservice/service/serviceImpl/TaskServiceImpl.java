package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.Priority;
import com.taskMannagerTool.tasktoolservice.models.State;
import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

import static com.taskMannagerTool.tasktoolservice.models.Priority.*;
import static com.taskMannagerTool.tasktoolservice.models.State.*;

@Service
public class TaskServiceImpl implements TaskService {

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




    public void deleteTask(int taskId){
        taskRepository.deleteById(taskId);
    }



    public ResponseEntity<Object> updateTask(Task task, int id) {

        Optional<Task> taskOptional = taskRepository.findById(id);

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        task.setTaskId(id);

        taskRepository.save(task);

        return ResponseEntity.noContent().build();
    }

}
