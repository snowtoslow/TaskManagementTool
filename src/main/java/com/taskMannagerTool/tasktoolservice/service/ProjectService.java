package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    ResponseEntity<Object> createProject(Project project);//C

    List<Project> readAllProjects();//R

    Project readAProjectById(int ProjectId);//R

    ResponseEntity<Object> updateProject(Project project, int ProjectId);//U !!!!!пересмотреть в имплементэйшне!!!

    void deleteProject(int projectId);//D
}
