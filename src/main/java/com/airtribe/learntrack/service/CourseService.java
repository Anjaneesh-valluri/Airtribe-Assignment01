package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Courses;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class CourseService {
    private ArrayList<Courses> Courses= new ArrayList<Courses>();

    public  void addCourse(Courses c){
        Courses.add(c);
        System.out.println("Course Added Successfully");
    }

    public void displayAll() throws EntityNotFoundException{
        System.out.println("Here are all the details of the Courses: ");
        if(Courses.isEmpty())
            throw new EntityNotFoundException("No courses present");
        for(Courses e : Courses){
            System.out.println("Course's ID: "+e.getId()+" Course's Name: "+e.getCourseName()+" Course's e-mail: "+e.isActive());
            return;
        }
    }

    public void deactivateCourse(int id) throws EntityNotFoundException{
        for(Courses e: Courses){
            if(e.getId()==id){
                e.setActive(false);
                System.out.println("Course deactivated successfully.");
            }
        }
        throw new EntityNotFoundException("Course with ID: "+id+" Not found");
    }

    public Courses getCourseById(int id) throws EntityNotFoundException{
        for(Courses e: Courses){
            if(e.getId()==id){
                return e;
            }
        }
        throw new EntityNotFoundException("Course with ID: "+id+" Not found");
    }
}
