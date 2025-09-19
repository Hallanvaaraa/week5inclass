package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    @OneToMany
    @JoinColumn
    private List<TimeSpent> timeSpentList = new ArrayList<TimeSpent>();
}
