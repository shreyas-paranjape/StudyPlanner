package com.gts.sqlitetutorial;

import android.database.Cursor;

public class Task {

    private Long id;
    private String title;

    public Task() {}

    public Task(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id != null ? id.equals(task.id) : task.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Task fromCursor(Cursor cursor) {
        Task task = new Task();
        task.setId(cursor.getLong(cursor.getColumnIndex("id")));
        task.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        return task;
    }
}
