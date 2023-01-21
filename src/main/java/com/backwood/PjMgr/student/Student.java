package com.backwood.PjMgr.student;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String Name;
    private  String Email;
    private LocalDate Dob;
    @Transient
    private  Integer Age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        Name = name;
        Dob = dob;
        Email = email;
    }

    public Student(String name, LocalDate dob, String email) {
        Name = name;
        Dob = dob;
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getAge() {
        return Period.between(this.Dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Dob=" + Dob +
                ", Email='" + Email + '\'' +
                ", Age=" + Age +
                '}';
    }
}
