package com.list.listview;

/**
 * Created by 7405148 on 6/1/2017.
 */

public class Todo {
    private String taskName;
    private String location;
    private String description;
    //time
    private String time;

    //constructor


    public Todo(String taskName, String location, String description,
                String time) {
        this.taskName = taskName;
        this.location = location;
        this.description = description;
        this.time = time;
    }

    //getter setter

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
