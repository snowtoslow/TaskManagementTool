package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.Project;
import com.taskMannagerTool.tasktoolservice.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProjectController extends ProjectServiceImpl {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;





    @PostMapping("/projects")
    public ResponseEntity<Object> createProject(@RequestBody Project project) {

        return projectServiceImpl.createProject(project);
    }

    @GetMapping("/projects")
    public List<Project> readAllProjects() {

        return projectServiceImpl.readAllProjects();
    }

    @GetMapping("/projects/{projectId}")
    public Project readAProjectById(@PathVariable int projectId) {
        return projectServiceImpl.readAProjectById(projectId);
    }

    @PutMapping("/projects/update/{projectId}")
    public ResponseEntity<Object> updateProject(@RequestBody Project project,@PathVariable int projectId) {
        return projectServiceImpl.updateProject(project,projectId);
    }

    @DeleteMapping("/projects/{projectId}")
    public void deleteProject(@PathVariable int projectId) {
        projectServiceImpl.deleteProject(projectId);
    }
}
