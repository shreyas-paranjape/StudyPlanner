package com.gts.planner.model;
import android.database.Cursor;

public class Event {

    public Event() {

    }

    public static Event fromCursor(Cursor eventCursor) {
        return new Event();
    }

    private String title;

    public Event(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
