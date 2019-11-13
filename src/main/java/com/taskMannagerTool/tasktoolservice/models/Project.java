package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Project")
    private int projectId;

    @Column(name = "Project_Name")
    private String projectName;

    @Column(name = "Project_Description")
    private String projectDescription;

    @Column(name = "Project_State")
    @Enumerated(EnumType.STRING)
    private State projectState;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Project",referencedColumnName = "Id_Project")
    private List<Task> tasksList;

    @OneToMany(cascade = CascadeType.ALL)//под вопрссом
    @JoinColumn(name = "Id_Project",referencedColumnName = "Id_Project")
    private List<User> userList;



    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public State getProjectState() {
        return projectState;
    }

    public void setProjectState(State projectState) {
        this.projectState = projectState;
    }

    public List<Task> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Task> tasksList) {
        this.tasksList = tasksList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
