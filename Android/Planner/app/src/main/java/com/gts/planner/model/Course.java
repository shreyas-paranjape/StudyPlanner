package com.gts.planner.model;
import android.database.Cursor;

public class Course {

    private Long id;
    private String title;
    private Long sdate;
    private Long edate;
    private String status;

    public Course() {}

    public Course(Long id, Long sdate, Long edate, String status ) {
        this.id = id;
        this.sdate = sdate;
        this.edate = edate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' + ", StartDate=" + sdate +
                ", EndDate=" + edate + ", Status='" + status + '\'' +
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

    public Long getSdate() {
        return sdate;
    }

    public void setSdate(Long sdate) {
        this.sdate = sdate;
    }

    public Long getEdate() {
        return edate;
    }

    public void setEdate(Long edate) {
        this.edate = edate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Course fromCursor(Cursor cursor) {
        Course assign = new Course();
        assign.setId(cursor.getLong(cursor.getColumnIndex("id")));
        assign.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        assign.setSdate(cursor.getLong(cursor.getColumnIndex("sdate")));
        assign.setEdate(cursor.getLong(cursor.getColumnIndex("edate")));
        assign.setStatus(cursor.getString(cursor.getColumnIndex("status")));
        return assign;
    }
}
