package com.taskMannagerTool.tasktoolservice.controllers;


import com.taskMannagerTool.tasktoolservice.models.Comment;
import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.repository.CommentRepository;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
public class CommentController extends CommentServiceImpl {

    @Autowired
    private CommentServiceImpl commentServiceImpl;






    @PostMapping("/comments/{id}/create")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment,@PathVariable int id,Principal principal) {
        return commentServiceImpl.createComment(comment,principal,id);
    }

    @DeleteMapping("/comments/delete/{commentId}")
    public void deleteComment(@PathVariable int commentId) {
        commentServiceImpl.deleteComment(commentId);
    }

    /*@GetMapping("/comments/{username}")
    public Optional<Comment> findCommentByUsername(@PathVariable String username){
        return commentServiceImpl.findCommentByUsername(username);
    }

    @GetMapping("/comments/{taskTitle}")
    public Optional<Comment> findCommentsByTaskTitle(@PathVariable String taskTitle){
        return commentServiceImpl.findCommentsByTaskTitle(taskTitle);

    }*/

    @GetMapping("/comments")
    public List<Comment> findAll(){
        return commentServiceImpl.findAllComments();
    }

    @GetMapping("/comments/{id}/task")
    public List<Comment> getCommentByTaskId(@PathVariable int id){
        return commentServiceImpl.getCommentByTaskId(id);
    }





}
