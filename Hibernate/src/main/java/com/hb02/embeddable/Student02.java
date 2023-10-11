package com.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id//primary key oluşmasını sağlıyoruz
    private int id;

    @Column(name="std_name",length = 100,nullable = false,unique = false)//opsiyonel
    private String name;

    private int grade;

    //street
    //city
    //country
    //zipCode
    //Address classının değişkenleri t_student02  tablosuna sütun olarak eklenir.
    @Embedded//opsiyonel
    private Address address;



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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //toString
    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
