package entity;

import jakarta.persistence.*;

@Entity
public class TimeSpent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int homeworkHours;

    private int inClassHours;

    private int theoryHours;

    @ManyToOne
    private Student student;

    public TimeSpent() {
    }

    public TimeSpent(int homeworkHours, int inClassHours, int theoryHours, Student student) {
        this.homeworkHours = homeworkHours;
        this.inClassHours = inClassHours;
        this.theoryHours = theoryHours;
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeworkHours() {
        return homeworkHours;
    }

    public void setHomeworkHours(int homeworkHours) {
        this.homeworkHours = homeworkHours;
    }

    public int getInClassHours() {
        return inClassHours;
    }

    public void setInClassHours(int inClassHours) {
        this.inClassHours = inClassHours;
    }

    public int getTheoryHours() {
        return theoryHours;
    }

    public void setTheoryHours(int theoryHours) {
        this.theoryHours = theoryHours;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
