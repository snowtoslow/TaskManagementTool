package com.taskMannagerTool.tasktoolservice.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table (name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    private String surname;
    private String username;
    private String jobTitle;
    private String team; //no need of team

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    public User(){
    }
    public User(String name, String surname, String username, String jobTitle, String team){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.jobTitle = jobTitle;
        this.team = team;
        tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        task.setReciever(this);
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getJobTitle() {
        return jobTitle;
    }
    public void setjobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getTeam(){
        return team;
    }
    public void setTeam(String team){
        this.team = team;
    }

    public List<Task> getTask(){
        return tasks;
    }
    public void setTask(List<Task> tasks){
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "tasks.User{" +
                "id= " + id +
                ", name =" + name +
                ", surname =" + surname +
                ", username =" + username +
                ", job title =" + jobTitle +
                ", team =" + team + '}';
    }

}
