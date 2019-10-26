package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Task")
    private int taskTd;

    @Column(name = "Task_Name")
    private String taskTitle;

    //@Column(name = "")
    //private String taskDate; //smthn with local date time

    //@Column(name = "Id_User")
    //private User reporter;

    //@Column(name = "")
    //private User reciever;

    @Column(name = "Description")
    private String taskDescription;

    @Column(name = "Priority")
    private Priority taskPriority;

    public int getTaskTd() {
        return taskTd;
    }

    public void setTaskTd(int taskTd) {
        this.taskTd = taskTd;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }


    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }
}
