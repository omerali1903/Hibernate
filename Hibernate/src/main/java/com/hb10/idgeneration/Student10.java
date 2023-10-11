package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_student10")
public class Student10 {

    /*
    AUTO:Default auto-increment öz. kullanır
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)
     IDENTITY:Kontrol DB de olur, 1 den başlayarak üretir.
     TABLE:id generate etmek için tablo oluşturulur.performansı düşük, tercih edilmez
     SEQUENCE:id set oluşturulur, başlangıç sayısını belirleyebiliriz.performansı yüksek
     */

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequencegen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequencegen",//generatorın ismini  GeneratedValue annotasyonunda kullanırız.
                       sequenceName = "student_seq",//DB de bu isimde seq oluşur
                        initialValue = 1000,//id ler bu değer ile başlasın
                        allocationSize = 5)//id setinde 5 tane id bulunsun.
    @Id
    private int id;

    private String name;

    private int grade;

    //getter-setter


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
}
