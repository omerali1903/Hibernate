package com.hb01.annotation;

import javax.persistence.*;

@Entity//bu class a karşılık DB de bir tablo oluşturulsun-->student01
@Table(name="t_student01")//opsiyonel
//Student01 classına karşılık gelen tablonun ismini t_student01 olarak değiştirdik.
//java kodları ile bu classa ulaşmak istersek Student01
//SQL komutu ile ulaşmak istersek t_student01 ile yazmamız lazım.
public class Student01 {

    @Id//primary key oluşmasını sağlıyoruz
    private int id;

    @Column(name="std_name",length = 100,nullable = false,unique = false)//opsiyonel
    private String name;

    //@Transient//DB de tabloda grade sütunu oluşmasın
    private int grade;

//    @Lob//large object ile büyük dataları tablomuza kaydedebiliriz.
//    private byte[] image;

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

    //toString
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
