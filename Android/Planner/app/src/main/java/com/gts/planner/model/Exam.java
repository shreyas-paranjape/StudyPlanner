package com.gts.planner.model;

public class Exam {

    private Long id;
    private String Title;
    private Long StartDate;
    private Long EndDate;
    private Long student_id;


    public Exam(Long id) {
        this.id = id;
    }
    public Exam(){}
    public Exam(String title){
        this.setTitle(title);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Long getStartDate() {
        return StartDate;
    }

    public void setStartDate(Long startDate) {
        StartDate = startDate;
    }

    public Long getEndDate() {
        return EndDate;
    }

    public void setEndDate(Long endDate) {
        EndDate = endDate;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}