package com.gts.planner.model;
import android.database.Cursor;

public class Course {

    private Long id;
    private String title;
    private Long Day;
    private Long time;
    private String Prof;
    private String Location;

    public Course() {}

    public Course(Long id, Long Day, Long time, String prof, String Location ) {
        this.id = id;
        this.Day = Day;
        this.time = time;
        this.Prof = prof;
        this.Location = Location;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' + ", Day=" + Day +
                ", time=" + time + ", Prof='" + Prof +
                ", Location=' " + Location +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id != null ? id.equals(course.id) : course.id == null;
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

    public Long getDay() {
        return Day;
    }

    public void setDay(Long Day) {
        this.Day = Day;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getProf() {
        return Prof;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setProf(String prof) {
        this.Prof = prof;
    }

    public static Course fromCursor(Cursor cursor) {
        Course assign = new Course();
        assign.setId(cursor.getLong(cursor.getColumnIndex("id")));
        assign.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        assign.setDay(cursor.getLong(cursor.getColumnIndex("Day")));
        assign.setTime(cursor.getLong(cursor.getColumnIndex("time")));
        assign.setProf(cursor.getString(cursor.getColumnIndex("prof")));
        assign.setLocation(cursor.getString(cursor.getColumnIndex("Location")));
        return assign;
    }


}
