package com.example.a7404855.manasipaste;

import java.io.Serializable;


public class Task implements Serializable {

    public static long serialVersionUID = 1L;

    private long id;
    private String title;


    public Task() {
        this.title ="need a name";
    }

    public Task(long id,String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
