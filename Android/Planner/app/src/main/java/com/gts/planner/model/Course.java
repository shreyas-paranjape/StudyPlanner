package com.gts.planner.model;
import android.content.ContentValues;
import android.database.Cursor;

public class Course {

    private Long id;
    private String title;
    private String Day;
    private Long sTime;
    private Long eTime;
    private String Prof;
    private String Location;
    private String Desc;

    public Course() {}

    public Course(Long id, String Day, Long sTime, Long eTime, String prof, String Location, String Desc ) {
        this.id = id;
        this.Day = Day;
        this.sTime = sTime;
        this.eTime = eTime;
        this.Prof = prof;
        this.Location = Location;
        this.Desc = Desc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' + ", Day=" + Day +
                ", sTime=" + sTime + ", eTime=" + eTime + ", Prof='" + Prof +
                ", Location=' " + Location + ", Description=' " + Desc + '\'' +
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

    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public Long getsTime() {
        return sTime;
    }

    public void setsTime(Long sTime) {
        this.sTime = sTime;
    }

    public Long geteTime() {
        return eTime;
    }

    public void seteTime(Long eTime) {
        this.eTime = eTime;
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

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setProf(String prof) {
        this.Prof = prof;

    }

    public static Course fromCursor(Cursor cursor) {
        Course assign = new Course();
        assign.setId(cursor.getLong(cursor.getColumnIndex("id")));
        assign.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        assign.setDay(cursor.getString(cursor.getColumnIndex("Day")));
        assign.setsTime(cursor.getLong(cursor.getColumnIndex("sTime")));
        assign.seteTime(cursor.getLong(cursor.getColumnIndex("eTime")));
        assign.setProf(cursor.getString(cursor.getColumnIndex("prof")));
        assign.setLocation(cursor.getString(cursor.getColumnIndex("Location")));
        assign.setDesc(cursor.getString(cursor.getColumnIndex("Desc")));
        return assign;
    }

}
