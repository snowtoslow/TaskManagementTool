package com.taskMannagerTool.tasktoolservice.models;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects"/*,schema = "justfortest"*/)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_state")
    @Enumerated(EnumType.STRING)
    private State projectState;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id",referencedColumnName = "project_id")
    private List<Task> tasksList;

    @OneToMany(cascade = CascadeType.ALL)//под вопрссом
    @JoinColumn(name = "user_id",referencedColumnName = "project_id")
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
