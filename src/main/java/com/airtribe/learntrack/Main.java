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
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello Welcome to AirTribe Learning console!!!\nPlease enter a choice: \n 1. Add a student\n  2. View all the courses\n 3. Enroll a student to a course\n 0. Exit\n Please enter your choice: ");
        int input=sc.nextInt() ;
        sc.nextLine();
        while(input!=0){
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

            }
            System.out.println("-------------Action end------------\nPlease enter a choice: \n1. Add a student\n2. View all the courses\n3. Enroll a student to a course\n0. Exit\n Please enter your choice: ");
            input=sc.nextInt();
        }



    }
}
