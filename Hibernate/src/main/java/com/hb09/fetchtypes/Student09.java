package com.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student09")
public class Student09 {//one
    @Id
    private int id;

    private String name;

    private int grade;

      /*
    2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

    OneToMany       --> LAZY
    ManyToMany      --> LAZY
    OneToOne        --> EAGER
    ManyToOne       --> EAGER
 */

    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Book09> bookList=new ArrayList<>();

    //const


    public Student09() { }

    public Student09(int id, String name, int grade) {
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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
