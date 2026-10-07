package com.ty.scms.main;

import com.ty.scms.dao.CourseDao;
import com.ty.scms.dao.EnrollmentDao;
import com.ty.scms.dao.StudentDao;
import com.ty.scms.daoimpl.CourseDaoImpl;
import com.ty.scms.daoimpl.EnrollmentDaoImpl;
import com.ty.scms.daoimpl.StudentDaoImpl;
import com.ty.scms.model.Course;
import com.ty.scms.model.Enrollment;
import com.ty.scms.model.Student;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SCMSApplication {

    static Scanner scanner = new Scanner(System.in);

    static StudentDao studentDao = new StudentDaoImpl();
    static CourseDao courseDao = new CourseDaoImpl();
    static EnrollmentDao enrollmentDao = new EnrollmentDaoImpl();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" STUDENT COURSE MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    courseMenu();
                    break;

                case 3:
                    enrollmentMenu();
                    break;

                case 4:
                    System.out.println("Thank you for using SCMS!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= STUDENT MENU =================

    private static void studentMenu() {

        while (true) {

            System.out.println("\n--- Student Management ---");

            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Students");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    viewStudents();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD STUDENT =================

    private static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter DOB (yyyy-mm-dd): ");
        String dobInput = scanner.nextLine();

        Date dob = java.sql.Date.valueOf(dobInput);

        Student student =
                new Student(id, name, email, dob);

        studentDao.addStudent(student);
    }

    // ================= UPDATE STUDENT =================

    private static void updateStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter New DOB (yyyy-mm-dd): ");
        String dobInput = scanner.nextLine();

        Date dob = java.sql.Date.valueOf(dobInput);

        Student student =
                new Student(id, name, email, dob);

        studentDao.updateStudent(student);
    }

    // ================= DELETE STUDENT =================

    private static void deleteStudent() {

        System.out.print("Enter Student ID: ");

        int id = scanner.nextInt();

        studentDao.deleteStudent(id);
    }

    // ================= VIEW STUDENTS =================

    private static void viewStudents() {

        List<Student> students =
                studentDao.getAllStudents();

        System.out.println("\n--- Students ---");

        for (Student student : students) {
            System.out.println(student);
        }
    }


    // ================= COURSE MENU =================

    private static void courseMenu() {

        while (true) {

            System.out.println("\n--- Course Management ---");

            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Courses");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    updateCourse();
                    break;

                case 3:
                    deleteCourse();
                    break;

                case 4:
                    viewCourses();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD COURSE =================

    private static void addCourse() {

        System.out.print("Enter Course ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Credits: ");
        int credits = scanner.nextInt();

        Course course =
                new Course(id, name, credits);

        courseDao.addCourse(course);
    }

    // ================= UPDATE COURSE =================

    private static void updateCourse() {

        System.out.print("Enter Course ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Credits: ");
        int credits = scanner.nextInt();

        Course course =
                new Course(id, name, credits);

        courseDao.updateCourse(course);
    }

    // ================= DELETE COURSE =================

    private static void deleteCourse() {

        System.out.print("Enter Course ID: ");

        int id = scanner.nextInt();

        courseDao.deleteCourse(id);
    }

    // ================= VIEW COURSES =================

    private static void viewCourses() {

        List<Course> courses =
                courseDao.getAllCourses();

        System.out.println("\n--- Courses ---");

        for (Course course : courses) {
            System.out.println(course);
        }
    }


    // ================= ENROLLMENT MENU =================

    private static void enrollmentMenu() {

        while (true) {

            System.out.println("\n--- Enrollment Management ---");

            System.out.println("1. Add Enrollment");
            System.out.println("2. Update Grade");
            System.out.println("3. Delete Enrollment");
            System.out.println("4. View Student Enrollments");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addEnrollment();
                    break;

                case 2:
                    updateGrade();
                    break;

                case 3:
                    deleteEnrollment();
                    break;

                case 4:
                    viewEnrollments();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= ADD ENROLLMENT =================

    private static void addEnrollment() {

        System.out.print("Enter Enrollment ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();

        Enrollment enrollment =
                new Enrollment(
                        id,
                        studentId,
                        courseId,
                        null
                );

        enrollmentDao.addEnrollment(enrollment);
    }

    // ================= UPDATE GRADE =================

    private static void updateGrade() {

        System.out.print("Enter Enrollment ID: ");
        int enrollmentId = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        enrollmentDao.updateGrade(
                enrollmentId,
                grade
        );
    }

    // ================= DELETE ENROLLMENT =================

    private static void deleteEnrollment() {

        System.out.print("Enter Enrollment ID: ");

        int id = scanner.nextInt();

        enrollmentDao.deleteEnrollment(id);
    }

    // ================= VIEW ENROLLMENTS =================

    private static void viewEnrollments() {

        System.out.print("Enter Student ID: ");

        int studentId = scanner.nextInt();

        List<Enrollment> enrollments =
                enrollmentDao.getEnrollmentsByStudent(studentId);

        System.out.println("\n--- Enrollments ---");

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
}