package com.gts.planner.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Task {

    private Long id;
    private Long student_id;
    private String title;
    private Long DueDate;
    private String Description;
    private int Status;

    public Task(){
        this.Status=0;
    }
    public Task(Long Id){
        this.id = Id;
        this.Status=0;
    }


    public Long getId(){
       return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDueDate(Long date){
        this.DueDate = date;
    }
    public Long getDueDate(){
        return this.DueDate;
    }
    public void setId( Long id){
        this.id= id;
    }
    public void setDescription(String Desc){
        this.Description= Desc;
    }
    public String getDescription()
    {
        return this.Description;
    }
    public void setStatus(int x)
    {
        this.Status= x;
    }
    public void setStudent_id(Long studentId)
    {
        this.student_id= studentId;
    }
    public int getStatus()
    {
        return this.Status;
    }
    public Long getStudent_id(){
        return this.student_id;
    }
    @Override
    public String toString(){
        return "Task{"+ " id="+ id+ ", title='"+ title + '\'' +
                " Due Date =" + DueDate+ '}';
    }
    @Override
    public boolean equals (Object o){
        if (this ==o) return true;
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task)o;
        return id != null ? id.equals(task.id): task.id == null;
    }
    @Override
    public int hashCode(){
        return id!= null ? id.hashCode():0;
    }
    public static Task fromCursor (Cursor cursor){
        Task task = new Task();
        task.setId(cursor.getLong(cursor.getColumnIndex("id")));
        task.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        task.setDescription(cursor.getString(cursor.getColumnIndex("Description")));
        task.setDueDate(cursor.getLong(cursor.getColumnIndex("DueDate")));
        return task;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues();
        values.put("id", getId());
        values.put("title", getTitle());
        values.put("Description", getDescription());
        values.put("DuDate", getDueDate());
        return values;
    }
}
