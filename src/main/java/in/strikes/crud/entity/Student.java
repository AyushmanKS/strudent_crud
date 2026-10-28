package in.strikes.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Student {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;

    public Long getId() {
        System.out.println("   Student.getId() -> " + id);
        return id;
    }

    public String getName() {
        System.out.println("   Student.getName() -> " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("1. Student.setName() -> " + name);
        this.name = name;
    }

    public int getAge() {
        System.out.println("   Student.getAge() -> " + age);
        return age;
    }

    public void setAge(int age) {
        System.out.println("1. Student.setAge() -> " + age);
        this.age = age;
    }

    public String getEmail() {
        System.out.println("   Student.getEmail() -> " + email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("1. Student.setEmail() -> " + email);
        this.email = email;
    }

    public int getRollNo() {
        System.out.println("   Student.getRollNo() -> " + rollNo);
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        System.out.println("1. Student.setRollNo() -> " + rollNo);
        this.rollNo = rollNo;
    }

    public String getSubject() {
        System.out.println("   Student.getSubject() -> " + subject);
        return subject;
    }

    public void setSubject(String subject) {
        System.out.println("1. Student.setSubject() -> " + subject);
        this.subject = subject;
    }
}
