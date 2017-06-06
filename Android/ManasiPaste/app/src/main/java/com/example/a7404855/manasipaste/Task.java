package com.example.a7404855.manasipaste;

import java.io.Serializable;

/**
 * Created by 7404855 on 6/4/2017.
 */

public class Task implements Serializable{

    private String title;

    public Task() {
        this.title ="need a name";
    }

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
