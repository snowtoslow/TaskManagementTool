package com.taskMannagerTool.tasktoolservice.service;

import com.taskMannagerTool.tasktoolservice.models.Project;
import com.taskMannagerTool.tasktoolservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/projects")
    public ResponseEntity<Object> createProject(@RequestBody Project project){//добавить респонс бади
        Project savedProject = projectRepository.save(project);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}")
                .build(savedProject.getProjectId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/projects")//Read
    public List<Project> readAllProjects(){
        return projectRepository.findAll();
    }

    //Read a specific task by Id;
    @GetMapping("/projects/{projectId}")
    public Project readAProjectById(@PathVariable int projectId){
        Optional<Project> project = projectRepository.findById(projectId);//костыль надо поменять

        if (!project.isPresent()){
            System.out.println("There is no project with such id: "+projectId);
        }
        return project.get();
    }


    @PutMapping("/projects/{projectId}")
    public ResponseEntity<Object> updateProject(@RequestBody Project project, @PathVariable int projectId){
        Optional<Project>  projectOptional = projectRepository.findById(projectId);

        if(!projectOptional.isPresent())
            return ResponseEntity.notFound().build();
        project.setProjectId(projectId);
        projectRepository.save(project);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("projects/{projectId}")
    public void deleteTask(@PathVariable int projectId){
        projectRepository.deleteById(projectId);
    }

}
