package com.bhumi;

import javax.persistence.*;

@Entity
@Table(name = "academic_info")
public class AcademicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String courseEnrolled;
    private int attendance;
    private String grades;
    private double paymentHistory;
    private String dateOfPayment;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public double getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(double paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

	public void setStudentId1(int studentIdForAcademicInfo) {
		// TODO Auto-generated method stub
		
	}

	public void setStudentId(int studentIdForAcademicInfo) {
		// TODO Auto-generated method stub
		
	}
}