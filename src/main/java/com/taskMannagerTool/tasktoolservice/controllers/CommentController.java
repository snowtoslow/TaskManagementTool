package com.taskMannagerTool.tasktoolservice.controllers;


import com.taskMannagerTool.tasktoolservice.models.Comment;
import com.taskMannagerTool.tasktoolservice.service.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController extends CommentServiceImpl {

    @Autowired
    private CommentServiceImpl commentServiceImpl;


    @PostMapping("/comments/create")
    public ResponseEntity<Object> createComment(@RequestBody Comment comment) {
        return commentServiceImpl.createComment(comment);
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


}
