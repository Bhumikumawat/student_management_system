package com.bhumi;

import com.bhumi.Student;
import com.bhumi.AcademicInfo;
import com.bhumi.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    // Method to add a new student
    public void addStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("Student added successfully: " + student);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to get all students
    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    // Method to update a student
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            System.out.println("Student updated successfully: " + student);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to delete a student by ID
    public void deleteStudent(int studentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
                transaction.commit();
                System.out.println("Student deleted successfully: " + student);
            } else {
                System.out.println("Student not found with ID: " + studentId);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Method to add academic information
    public void addAcademicInfo(AcademicInfo academicInfo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(academicInfo);
            transaction.commit();
            System.out.println("Academic info added successfully: " + academicInfo);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Main method to demonstrate CRUD operations
    public static void main(String[] args) {
        StudentManagementSystem app = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Academic Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter date of birth (YYYY-MM-DD): ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter parents' name: ");
                    String parentsName = scanner.nextLine();
                    Student student = new Student();
                    app.addStudent(student);
                    break;

                case 2:
                    // View All Students
                    List<Student> students = app.getAllStudents();
                    System.out.println("All Students:");
                    students.forEach(System.out::println);
                    break;

                case 3:
                    // Update Student
                    System.out.print("Enter Student ID to update: ");
                    int studentIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    Student studentToUpdate = app.getAllStudents().stream()
                            .filter(s -> s.getStudentId() == studentIdToUpdate)
                            .findFirst()
                            .orElse(null);
                    if (studentToUpdate != null) {
                        studentToUpdate.setEmail(newEmail);
                        app.updateStudent(studentToUpdate);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter Student ID to delete: ");
                    int studentIdToDelete = scanner.nextInt();
                    app.deleteStudent(studentIdToDelete);
                    break;

                case 5:
                    // Add Academic Info
                    System.out.print("Enter Student ID for academic info: ");
                    int studentIdForAcademicInfo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course enrolled: ");
                    String courseEnrolled = scanner.nextLine();
                    System.out.print("Enter attendance: ");
                    int attendance = scanner.nextInt();
                    System.out.print("Enter grades: ");
                    String grades = scanner.next();
                    System.out.print("Enter payment history: ");
                    double paymentHistory = scanner.nextDouble();
                    System.out.print("Enter date of payment (YYYY-MM-DD): ");
                    String dateOfPayment = scanner.next();
                    AcademicInfo academicInfo = new AcademicInfo();
                    academicInfo.setStudentId(studentIdForAcademicInfo);
                    academicInfo.setCourseEnrolled(courseEnrolled);
                    academicInfo.setAttendance(attendance);
                    academicInfo.setGrades(grades);
                    academicInfo.setPaymentHistory(paymentHistory);
                    academicInfo.setDateOfPayment(dateOfPayment);
                    app.addAcademicInfo(academicInfo);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}