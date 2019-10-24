package com.taskMannagerTool.tasktoolservice.Models;
import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "taskTitle")
    private String title;
    private String date; //smthn with local date time
    private User reporter;
    private User reciever;
    private String description;

    public enum State {

        current("Current"),
        finished("Finished");

        private String title;

        State(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "State{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    public enum Priority {

        critical("Critical"),
        significant("Signigficant"),
        major("Major"),
        minor("Minor"),
        trivial("Trivial");

        private String title;

        Priority(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Priority{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Task(){
    }

    public Task(String title, String date, User reporter, User reciever, String description){
        this.title = title;
        this.date = date;
        this.reporter = reporter;
        this.reciever = reciever;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public User getReporter(){
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getReciever(){
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return "Title " + title +
                ", date" + date +
                ", reporter" + reporter +
                ", reciever" + reciever +
                ", description" + description;
    }
}
