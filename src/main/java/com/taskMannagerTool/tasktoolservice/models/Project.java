package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Project")
    private int Id;

    @Column(name = "Project_Name")
    private String projectName;

    @Column(name = "Project_Discription")
    private String projectDiscription;

    //@Column(name = "")
    //private State projectState;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
