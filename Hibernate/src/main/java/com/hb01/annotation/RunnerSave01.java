package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student1=new Student01();
        student1.setId(1001);
        student1.setName("Yusuf Çoban");
        student1.setGrade(95);

        Student01 student2=new Student01();
        student2.setId(1002);
        student2.setName("Fazıl Demir");
        student2.setGrade(98);

        Student01 student3=new Student01();
        student3.setId(1003);
        student3.setName("Ebru Hanım");
        student3.setGrade(96);


        //configure metoduna parametre girilmezse defaultta "hibernate.cfg.xml" dosyasına göre konfig. yapar.
        //hibernate e Entity classımızı bildirdik.
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
