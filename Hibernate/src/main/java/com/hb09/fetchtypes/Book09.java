package com.hb09.fetchtypes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book09 {//ilişki sahibi

    @Id
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)//EAGER
    private Student09 student;

    //const
    public Book09() {}

    public Book09(int id, String name, Student09 student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }
    //toString

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
