package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.Comment;
import com.taskMannagerTool.tasktoolservice.models.Task;
import com.taskMannagerTool.tasktoolservice.models.User;
import com.taskMannagerTool.tasktoolservice.repository.CommentRepository;
import com.taskMannagerTool.tasktoolservice.repository.TaskRepository;
import com.taskMannagerTool.tasktoolservice.repository.UserRepository;
import com.taskMannagerTool.tasktoolservice.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> createComment(Comment comment, Principal principal,int id) {
        comment.setUser(userRepository.findUserByUsername(principal.getName()));
        String sql = "SELECT public.comments.task_id FROM public.comments WHERE public.comments.comment_id = ?";
        comment.setTaskId(jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class));
        log.info("USER:{}",userRepository.findUserByUsername(principal.getName()).getUsername());
        Comment savedComment = commentRepository.save(comment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{commentId}")
                .build(savedComment.getCommentId());
        log.info("Comment:{} and URI:{}",savedComment,location);
        return ResponseEntity.created(location).build();
    }


   public List<Comment> findAllComments(){

       return commentRepository.findAll();
   }

    //get comments by taskID;

    public List<Comment> getCommentByTaskId(int id){

        String  query = "SELECT * FROM public.comments WHERE public.comments.task_id = ?";
        log.info("COMMENTS:{}",jdbcTemplate.queryForObject(query, new Object[]{id}, List.class));

        return jdbcTemplate.queryForObject(query, new Object[]{id}, List.class);

    }



}
