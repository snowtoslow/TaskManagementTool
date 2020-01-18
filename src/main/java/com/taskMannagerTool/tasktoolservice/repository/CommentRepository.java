package com.taskMannagerTool.tasktoolservice.repository;

import com.taskMannagerTool.tasktoolservice.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query("SELECT c FROM Comment c WHERE c.taskId = :taskId")
    List<Comment> commentsByTask(@Param("taskId") Integer taskId);

}
