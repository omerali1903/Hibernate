package com.hb06.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {//Many
    @Id
    private int id;//default 0

    private String name;

    //const
    //fetch işlemleri için default cons. gerekli
    public Book06() { }

    public Book06(int id, String name) {
        this.id = id;
        this.name = name;
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
//toString
    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
