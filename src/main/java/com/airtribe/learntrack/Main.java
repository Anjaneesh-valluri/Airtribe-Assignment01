package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        String menu = "-------------MENU--------------\nPlease enter a choice: \n 1. Add a student\n 2. View all the courses\n 3. Enroll a student to a course\n" +
                " 4. Print a student details\n 5. Get all enrolments for a student \n 6. Display all the student details\n 7. Print new courses\n 8. Create/Add a new Course \n 0. Exit\n Please enter your choice: ";
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Welcome to AirTribe Learning console!!!\n"+menu);
        int input=sc.nextInt() ;
        sc.nextLine();
        while(input!=0){
            int studentId =0;
            int courseId =0;
            switch(input){
                case 1:
                    System.out.println("Please provide details of the new student:\n1. Firstname: ");
                    String fName = sc.nextLine();
                    System.out.println("2. Lastname: ");
                    String lName = sc.nextLine();
                    System.out.println("3. E-mail: ");
                    String email = sc.nextLine();
                    System.out.println("4. Batch name: ");
                    String batch = sc.nextLine();
                    System.out.println("5. is Active? (True/False): ");
                    boolean isActive = sc.nextBoolean();
                    Student s = new Student(IdGenerator.getNewId(),fName,lName,email,batch, isActive);
                    studentService.addStudent(s);
                    break;
                case 2:
                    System.out.println("Here are all the courses available: ");
                    try{
                        courseService.displayAll();
                    }
                    catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID and course ID: ");
                    studentId=sc.nextInt();
                    courseId=sc.nextInt();
                    try{
                        enrollmentService.enroll(studentId,courseId);
                    }
                    catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());

                }
                    break;
                case 4:
                    System.out.println("Enter the student ID: ");
                    studentId=sc.nextInt();
                    Student student;
                    try {
                       student = studentService.getById(studentId);
                       System.out.println("Here are the details of the student:\n ID: "+student.getId()+" FullName: "+student.getFullName()+" E-mail: "+student.getEmail()+" Batch: "+student.getClass());
                    }
                    catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the student ID: ");
                    studentId=sc.nextInt();
                    try {
                        enrollmentService.getEnrollmentByStudent(studentId);
                    }
                    catch (EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Here are all the details of the students:\n");
                    try{
                        studentService.displayAll();
                    }
                    catch(EntityNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Sorry wrong input, select a valied option.");
                    break;


            }
            System.out.println(menu);
            input=sc.nextInt();
        }
        System.out.println("Exiting, Thank you.....!!!");


    }
}
