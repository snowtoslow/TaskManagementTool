package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Comment;
import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.repository.CommentRepository;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.Optional;


public interface CommentService {

    void deleteComment(int id);

    ResponseEntity<Object> createComment(Comment comment, Principal principal,int id);





}
