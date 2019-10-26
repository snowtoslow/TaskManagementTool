package com.taskMannagerTool.tasktoolservice.repository;

import com.taskMannagerTool.tasktoolservice.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository extends JpaRepository<Task, String> {

}