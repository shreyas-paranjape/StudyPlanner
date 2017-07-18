package com.gts.planner.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Exam {
    private Long person;
    private String paper;
    private String examDesc;
    private Long sDate;
    private Long time;
    private String Status;
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Exam(){
        this.Status = " ";
    }
    public Exam(Long person){
        this.person = person;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Long getsDate() {
        return sDate;
    }

    public void setsDate(Long sDate) {
        this.sDate = sDate;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString(){
        return "Exam{"+ " person="+ person+ ", paper='"+ paper + '\'' + ", start date=' " + sDate + '\''
                + ", end date=' " + time + '\'' + 
                " Status ='" + Status + '\'' + '}';
    }
    @Override
    public boolean equals (Object o){
        if (this ==o) return true;
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Exam exam = (Exam)o;
        return person != null ? person.equals(exam.person): exam.person == null;
    }
    @Override
    public int hashCode(){
        return person!= null ? person.hashCode():0;
    }
    public static Exam fromCursor (Cursor cursor){
        Exam exam = new Exam();
        exam.setPerson(cursor.getLong(cursor.getColumnIndex("Person")));
        exam.setPaper(cursor.getString(cursor.getColumnIndex("Paper")));
        exam.setsDate(cursor.getLong(cursor.getColumnIndex("sDate")));
        exam.setTime(cursor.getLong(cursor.getColumnIndex("time")));
        exam.setStatus(cursor.getString(cursor.getColumnIndex("Status")));
        return exam;

    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues();
        values.put("ID", getId());
        values.put("Name", getPaper());
        values.put("desc", getExamDesc());
        values.put("Date", getsDate());
        return values;
    }
    public String getExamDesc() {
        return examDesc;
    }

    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }
}