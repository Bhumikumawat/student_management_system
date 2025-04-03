package com.bhumi;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        AcademicInfoDAO academicInfoDAO = new AcademicInfoDAO();

        // Create a new student
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john.doe@example.com");
        student.setDateOfBirth("2000-01-01");
        student.setGender("Male");
        student.setParentsName("Jane Doe");

        // Save student
        studentDAO.saveStudent(student);

        // Create academic info
        AcademicInfo academicInfo = new AcademicInfo();
        academicInfo.setStudent(student);
        academicInfo.setCourseEnrolled("Computer Science");
        academicInfo.setAttendance(90);
        academicInfo.setGrades("A");
        academicInfo.setPaymentHistory(1000);
        academicInfo.setDateOfPayment("2023-01-01");

        // Save academic info
        academicInfoDAO.saveAcademicInfo(academicInfo);

        // Retrieve all students
        List<Student> students = studentDAO.getAllStudents();
        students.forEach(s -> System.out.println(s.getName()));
    }
}