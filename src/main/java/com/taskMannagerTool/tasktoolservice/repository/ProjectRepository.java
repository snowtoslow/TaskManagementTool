package com.taskMannagerTool.tasktoolservice.repository;

import com.taskMannagerTool.tasktoolservice.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository  extends JpaRepository<Project, Integer> {
}
