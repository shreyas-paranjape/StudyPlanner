package com.gts.planner.model;

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
    public Long getId(Long id){
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

}
