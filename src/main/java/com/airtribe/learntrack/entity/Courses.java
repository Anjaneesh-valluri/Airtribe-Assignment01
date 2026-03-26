package com.airtribe.learntrack.entity;

public class Courses {
    private int id;
    private String courseName;
    private String descripiton;

    public Courses(int id, String courseName, String descripiton, int durationInWeeks, boolean active) {
        this.id = id;
        this.courseName = courseName;
        this.descripiton = descripiton;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private int durationInWeeks;
    private boolean active;

}
