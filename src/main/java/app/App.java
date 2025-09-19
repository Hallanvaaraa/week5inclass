package app;

import dao.Dao;
import entity.Student;

public class App {

    public static void main(String[] args) {
        Dao dao = new Dao();

        // Add students
        Student newStudent = new Student("Mikko Mallikas", "mikko@email.com");

        dao.addStudent(newStudent);

        newStudent = new Student("Tommi Halla", "tommi@googol.com");

        dao.addStudent(newStudent);

        // Find student
        Student foundStudent = dao.findStudent("mikko@email.com");
        System.out.println(foundStudent);

        // Update student
        foundStudent.setName("Mikko Mallikas Jr.");
        Student updatedStudent = foundStudent;
        dao.updateStudent("mikko@email.com", updatedStudent);

        foundStudent = dao.findStudent("mikko@email.com");
        System.out.println(foundStudent);
    }
}
