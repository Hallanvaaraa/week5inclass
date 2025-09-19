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
    private List<TimeSpent> timeSpentList;

    public Student() {
        timeSpentList = new ArrayList<TimeSpent>();
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
        timeSpentList = new ArrayList<TimeSpent>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TimeSpent> getTimeSpentList() {
        return timeSpentList;
    }

    public void setTimeSpentList(List<TimeSpent> timeSpentList) {
        this.timeSpentList = timeSpentList;
    }

    public void addTimeSpent(TimeSpent timeSpent) {
        this.timeSpentList.add(timeSpent);
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
