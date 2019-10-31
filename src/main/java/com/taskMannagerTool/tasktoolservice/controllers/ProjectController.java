package com.taskMannagerTool.tasktoolservice.controllers;

import com.taskMannagerTool.tasktoolservice.models.Project;
import com.taskMannagerTool.tasktoolservice.service.ProjectService;
import com.taskMannagerTool.tasktoolservice.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController implements ProjectService {
    @Autowired
    ProjectServiceImpl projectService = new ProjectServiceImpl();

    @PostMapping("/projects")
    public ResponseEntity<Object> createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("/projects")
    public List<Project> readAllProjects() {
        return projectService.readAllProjects();
    }

    @GetMapping("/projects/{projectId}")
    public Project readAProjectById(@PathVariable int projectId) {
        return projectService.readAProjectById(projectId);
    }

    @PutMapping("/projects/{projectId}")
    public ResponseEntity<Object> updateProject(Project project, int projectId) {
        return projectService.updateProject(project,projectId);
    }

    @DeleteMapping("/projects/{projectId}")
    public void deleteProject(int projectId) {
        projectService.deleteProject(projectId);
    }
}
