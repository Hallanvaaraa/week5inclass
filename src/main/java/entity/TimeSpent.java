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
}
