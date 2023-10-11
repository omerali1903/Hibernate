package com.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    private int grade;
    private LocalDateTime createOn;//obje DB e kaydedildiğinde set edelim


    @ManyToOne
    @JoinColumn(name="uni_id")//opsiyonel
    private University university;

    @PrePersist//obje DB e kaydedilmeden hemen önce şu metodu çağır
    public void prePersist(){
        //obje DB de kalıcı hale gelmeden önceki işlemler
      this.createOn=LocalDateTime.now();
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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
//toString
    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
