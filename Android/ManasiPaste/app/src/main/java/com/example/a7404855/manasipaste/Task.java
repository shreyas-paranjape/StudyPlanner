package com.example.a7404855.manasipaste;

import android.database.Cursor;



public class Task {

    private long id;
    private String title;


    public Task() {
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
    public String toString()
    {
        return "Task{" + "id="+ id+ ", title=' "+ title+ '\'' +'}';
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

    public static Task fromCursor (Cursor cursor)
    {
        Task task = new Task();
        task.setId(cursor.getLong (cursor.getColumnIndex("id")));
        task.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        return task;
    }
}
