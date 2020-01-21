package com.taskMannagerTool.tasktoolservice.service.serviceImpl;

import com.taskMannagerTool.tasktoolservice.models.Project;
import com.taskMannagerTool.tasktoolservice.repository.ProjectRepository;
import com.taskMannagerTool.tasktoolservice.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private  ProjectRepository projectRepository;



    public ResponseEntity<Object> createProject(Project project){//добавить респонс бади
        Project savedProject = projectRepository.save(project);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}")
                .build(savedProject.getProjectId());

        return ResponseEntity.created(location).build();
    }

    public List<Project> readAllProjects(){

        return projectRepository.findAll();
    }

    //Read a specific task by Id;

    public Project readAProjectById(int projectId){
        Optional<Project> project = projectRepository.findById(projectId);//костыль надо поменять

        if (!project.isPresent()){
            System.out.println("There is no project with such id: "+projectId);
        }
        return project.get();
    }


   public ResponseEntity<Object> updateProject(Project project, int id) {

       Optional<Project> taskOptional = projectRepository.findById(id);
       log.info("projectID:{}",projectRepository.findById(id).get().getProjectId());


       if (!taskOptional.isPresent())
           return ResponseEntity.notFound().build();

       project.setProjectId(id);

       projectRepository.save(project);

       return ResponseEntity.noContent().build();
   }


    public void deleteProject( int projectId){
        projectRepository.deleteById(projectId);
    }


}
