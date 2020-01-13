package com.taskMannagerTool.tasktoolservice.models;



import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tasks"/*,schema = "justfortest"*/)
@Data
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


    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreationTimestamp
    private Date StartDate;


    @Column(name = "due_date")
    private Date DueDate;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User senderId;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiverId;



    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Comment> comments;








}
