package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_User")
    public int userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String userPassword;

    @Column(name = "Speciality")
    private String jobTitle;

    @Column(name = "User_Email")
    private String userEmail;

    @Column(name = "User_Git")
    private String userGit;

    @OneToMany(cascade = CascadeType.ALL)//под вопросом
    @JoinColumn(name = "Id_User",referencedColumnName = "Id_User")
    private List<Task> tasks;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGit() {
        return userGit;
    }

    public void setUserGit(String userGit) {
        this.userGit = userGit;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
