package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Project")
    private int projectId;

    @Column(name = "Project_Name")
    private String projectName;

    @Column(name = "Project_Discription")
    private String projectDiscription;


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

    public String getProjectDiscription() {
        return projectDiscription;
    }

    public void setProjectDiscription(String projectDiscription) {
        this.projectDiscription = projectDiscription;
    }

}
