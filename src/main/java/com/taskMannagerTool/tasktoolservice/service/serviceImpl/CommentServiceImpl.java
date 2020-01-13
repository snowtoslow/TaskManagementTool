package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.Comment;
import com.taskMannagerTool.tasktoolservice.repository.CommentRepository;
import com.taskMannagerTool.tasktoolservice.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;



    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> createComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{commentId}")
                .build(savedComment.getCommentId());
        log.info("Comment:{} and URI:{}",savedComment,location);
        return ResponseEntity.created(location).build();
    }

   /* @Override
    public Optional<Comment> findCommentByUsername(String username){
        Optional<Comment> existingComment = Optional.ofNullable(commentRepository.findCommentsByUser_Username(username));
        log.info("Comment:{}", existingComment);

        if (!existingComment.isPresent()) {
            System.out.println("There is no such comment!");
        }
        return existingComment;
    }

    @Override
    public Optional<Comment> findCommentsByTaskTitle(String taskTitle) {
        Optional<Comment> existingComment = Optional.ofNullable(commentRepository.findCommentsByTask_taskTitle(taskTitle));
        log.info("Comment:{}", existingComment);

        if (!existingComment.isPresent()) {
            System.out.println("There is no such comment!");
        }
        return existingComment;
    }*/
   public List<Comment> findAllComments(){

       return commentRepository.findAll();
   }
}
