package com.taskMannagerTool.tasktoolservice.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "tasks"/*,schema = "justfortest"*/)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    @JsonIgnore
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


    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreationTimestamp
    @JsonIgnore
    private Date StartDate;


    @Column(name = "due_date")
    private Date DueDate;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User senderId;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiverId;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private List<Comment> comments;



    @JsonIgnore
    public int getTaskId() {
        return taskId;
    }
    @JsonProperty
    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public State getTaskState() {
        return taskState;
    }

    public void setTaskState(State taskState) {
        this.taskState = taskState;
    }

    @JsonIgnore
    public Date getStartDate() {
        return StartDate;
    }

    @JsonProperty
    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    @JsonIgnore
    public User getSenderId() {
        return senderId;
    }

    @JsonIgnore
    public void setSenderId(User senderId) {
        this.senderId = senderId;

    }

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
