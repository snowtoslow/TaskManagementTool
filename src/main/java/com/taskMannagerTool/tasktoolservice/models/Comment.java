package com.taskMannagerTool.tasktoolservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@Data
@JsonIgnoreProperties(value = {"setCreateAt(Date createAt)"})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    @JsonIgnore
    private int commentId;

    @Column(name = "comment_content")
    private String commentContent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "task_id")
    @JsonIgnore
    private int taskId;

    @Column(name = "create_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreationTimestamp
    @JsonIgnore
    private Date createAt;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    @JsonIgnore
    public User getUser() {
        return user;
    }
    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }
    @JsonIgnore
    public int getTaskId() {
        return taskId;
    }
    @JsonIgnore
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    @JsonIgnore
    public Date getCreateAt() {
        return createAt;
    }
    @JsonIgnore
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
