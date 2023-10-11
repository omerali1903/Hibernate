package com.hb06.onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {//one

    @Id
    private int id;

    private String name;

    private int grade;

    @OneToMany//FK sütunu Book06 tablosunda oluşturur.name:bookList_id
    @JoinColumn(name = "student_id")
    private List<Book06> bookList=new ArrayList<>();

    //const


    public Student06() {}

    public Student06(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
    }

}
