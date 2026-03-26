package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Courses;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class EnrollmentService {

    StudentService studentService;
    CourseService courseService;
    Student student;
    Courses course;
    ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    LocalDate date = LocalDate.now();

    EnrollmentService(StudentService studentService, CourseService courseService){
        this.courseService = courseService;
        this.studentService=studentService;
    }
    public void enroll(int studentId, int courseId) throws EntityNotFoundException {
        student = studentService.getById(studentId);
        course = courseService.getCourseById(courseId);
        if(student.getId()!=0&& course.getId()!=0){
            Enrollment enrollment = new Enrollment(IdGenerator.getNewEnrollmentId(),studentId,courseId,date, Enrollment.Status.ACTIVE );
            enrollments.add(enrollment);
            System.out.println("Enrollment done successfully !");
        }

    }
    public void updateStatus(int enrollmentId, Status newStatus){
        
    }

    public ArrayList<Enrollment> getEnrollmentByStudent throws EntityNotFoundException(int studentId){
        ArrayList<Enrollment> output = new ArrayList<Enrollment>();
        for(Enrollment e : enrollments){
            output.add(e);
        }
        return output;
        throw new EntityNotFoundException("Unable to find any enrollments");
    }

}
