package com.taskMannagerTool.tasktoolservice.Models;

public class task {

    private int id;

    private String title;

    private String date; //smthn with local date time

    private user reporter;

    private user reciever;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public user getReporter() {
        return reporter;
    }

    public void setReporter(user reporter) {
        this.reporter = reporter;
    }

    public user getReciever() {
        return reciever;
    }

    public void setReciever(user reciever) {
        this.reciever = reciever;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
