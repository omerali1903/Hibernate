package com.hb07.bi_onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="t_student07")
public class Student07 {

    @Id
    private int id;

    private String name;

    private int grade;

    //CascadeType.REMOVE:Student silinirse ilişkili olduğu bookları da Book tablosundan siler.
    //@OneToMany(mappedBy = "student",cascade = CascadeType.REMOVE)//FK sütunu Book07 tablosunda oluşturur.

    //orphanRemoval = true:Student silinirse ilişkili olduğu bookları da Book tablosundan siler.
    @OneToMany(mappedBy = "student"/*,orphanRemoval = true*/)//FK sütunu Book07 tablosunda oluşturur.
    private List<Book07> bookList=new ArrayList<>();

    //const
    public Student07() {
    }

    public Student07(int id, String name, int grade) {
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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
