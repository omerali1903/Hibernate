package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity//bu class a karşılık DB de bir tablo oluşturulsun-->student01
@Table(name="t_student04")//opsiyonel
public class Student04 {

    @Id//primary key oluşmasını sağlıyoruz
    private int id;

    @Column(name="std_name",length = 100,nullable = false,unique = false)//opsiyonel
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student")//mappedBy kullanmazsak FK oluşur.
    private Diary04 diary;

    //GETTER-SETTER


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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    //toString

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
