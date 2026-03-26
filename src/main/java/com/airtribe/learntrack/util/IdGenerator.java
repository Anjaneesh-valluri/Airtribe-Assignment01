package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int count = 0;
    private static int courseCount = 0;
    private static int enrollmentCount = 0;
    public static int getNewId(){
        count=count+1;
        return count;
    }
    public static int getNewCourseId(){
        courseCount=courseCount+1;
        return courseCount;
    }
    public static int getNewEnrollmentId(){
        enrollmentCount=enrollmentCount+1;
        return enrollmentCount;
    }
}
