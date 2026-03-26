package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students= new ArrayList<Student>();

    public  void addStudent(Student student){
        students.add(student);
        System.out.println("Student Added Successfully");
    }

    public void displayAll(){
        System.out.println("Here are all the details of the students: ");
        for(Student e : students){
            System.out.println("Student's ID: "+e.getId()+" Student's Name: "+e.getFullName()+" Student's e-mail: "+e.getEmail());
        }
    }

    public Student getById(int id) throws EntityNotFoundException{
        for(Student e: students){
            if(e.getId()==id){
               return e;
            }
        }
        throw new EntityNotFoundException("Student with ID: "+id+" Not found");
    }
}
