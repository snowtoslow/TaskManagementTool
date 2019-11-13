package com.taskMannagerTool.tasktoolservice.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Task")
    private int taskId;

    @Column(name = "Task_Name")
    private String taskTitle;

    @Column(name = "Task_Description")
    private String taskDescription;

    @Column(name = "Task_Priority")
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;

    @Column(name = "Task_State")
    @Enumerated(EnumType.STRING)
    private State taskState;

    @Column(name = "Task_StartDate")
    private Date StartDate;

    @Column(name = "Task_DueDate")
    private Date DueDate;

    @Column(name = "Id_Sender")
    private int senderId;

    @Column(name = "Id_Receiver")
    private int receiverId;


    public int getTaskId() {
        return taskId;
    }

    public void setTaskTd(int taskTd) {
        this.taskId = taskTd;
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

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public State getTaskState() {
        return taskState;
    }

    public void setTaskState(State taskState) {
        this.taskState = taskState;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }
}
