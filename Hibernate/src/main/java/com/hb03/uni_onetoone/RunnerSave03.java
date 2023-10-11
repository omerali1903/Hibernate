package com.hb03.uni_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {


        Student03 student1=new Student03();
        student1.setId(1001);
        student1.setName("Caner Bey");
        student1.setGrade(90);

        Student03 student2=new Student03();
        student2.setId(1002);
        student2.setName("Musab Bey");
        student2.setGrade(92);

        Student03 student3=new Student03();
        student3.setId(1003);
        student3.setName("Kübra Hanım");
        student3.setGrade(98);


        Diary diary1=new Diary();
        diary1.setId(11);
        diary1.setName("Caner's Diary");
        diary1.setStudent(student1);

        Diary diary2=new Diary();
        diary2.setId(12);
        diary2.setName("Musab's Diary");
        diary2.setStudent(student2);

        Diary diary3=new Diary();
        diary3.setId(13);
        diary3.setName("X's Diary");
    //    diary3.setStudent(student1);


        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sessionFactory.close();


    }
}
