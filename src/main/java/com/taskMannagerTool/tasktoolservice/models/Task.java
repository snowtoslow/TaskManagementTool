package com.taskMannagerTool.tasktoolservice.models;



import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "tasks"/*,schema = "justfortest"*/)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "task_priority")
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;

    @Column(name = "task_state")
    @Enumerated(EnumType.STRING)
    private State taskState;

    @CreatedDate
    @Column(name = "start_date")
    private Date StartDate;


    @Column(name = "due_date")
    private Date DueDate;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User senderId;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiverId;







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

    public User getSenderId() {
        return senderId;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }




}
