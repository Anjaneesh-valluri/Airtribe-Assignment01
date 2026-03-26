package com.airtribe.learntrack.entity;

public class Student extends Person{
    private String batch;
    private boolean isActive;

    public Student(int id, String firstName, String lastName, String email, String batch, boolean isActive){
        super(id, firstName, lastName,email);
        this.batch= batch;
        this.isActive = isActive;
    }

    public Student(int id, String firstName, String lastName,  String batch, boolean isActive){
        super(id, firstName, lastName);
        this.batch= batch;
        this.isActive = isActive;
    }
}
