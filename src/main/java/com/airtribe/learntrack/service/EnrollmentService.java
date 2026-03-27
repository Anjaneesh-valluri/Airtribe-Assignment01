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

    public EnrollmentService(StudentService studentService, CourseService courseService){
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
            return;
        }
        throw new EntityNotFoundException("Please verify IDs again");

    }
    public void updateStatus(int enrollmentId, Enrollment.Status newStatus) throws EntityNotFoundException{
        for(Enrollment e: enrollments) {
            if (e.getId() == enrollmentId) {
                e.setStatus(newStatus);
                System.out.println("Status is updated successfully");
                return;
            }
            throw new EntityNotFoundException("Unable to find any enrollment with the Enrollment number: "+enrollmentId);
        }

    }

    public ArrayList<Enrollment> getEnrollmentByStudent (int studentId) throws EntityNotFoundException{
        ArrayList<Enrollment> output = new ArrayList<Enrollment>();
        for(Enrollment e : enrollments){
            if(e.getStudentId()==studentId)
                output.add(e);
        }
        if(output.isEmpty())
            throw new EntityNotFoundException("Unable to find any enrollments");
        return output;
    }

}
