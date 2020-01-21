package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import com.taskMannagerTool.tasktoolservice.exceptions.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.*;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;



    public ResponseEntity<Object> createTask(Task task,Principal principal){//добавить респонс бади
        task.setSenderId(userRepository.findUserByUsername(principal.getName()));
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



    public ResponseEntity<Object> updateTask(Task task, int id,Principal principal) {

        Optional<Task> taskOptional = taskRepository.findById(id);
        log.info("TASKID:{}",taskOptional.get().getTaskId());

        if (!taskOptional.isPresent())
            return ResponseEntity.notFound().build();

        task.setTaskId(id);
        task.setSenderId(userRepository.findUserByUsername(principal.getName()));
        task.setStartDate(task.getStartDate());

        taskRepository.save(task);

        return ResponseEntity.noContent().build();
    }


    public List<Task> getTasksByReceiverId(String username) throws UserException{
        User user = userRepository.findUserByUsername(username);
        if (user == null){
            throw new UserException("There is no user with such Username!");
        }

        return taskRepository.findTaskByReceiverId(user);

    }

    public List<Task> getTaskBySenderId(Principal principal) throws UserException {
        User user = userRepository.findUserByUsername(principal.getName());
        if (user == null){
            throw new UserException("There is nu user with such username!" + principal.getName());
        }
        return taskRepository.findTaskByReceiverId(user);
    }

}
