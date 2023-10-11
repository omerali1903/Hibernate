package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();

        //id=1002 olan studentı görelim.
        Student03 student=session.get(Student03.class,1002);
        //id=11 olan diaryi görelim.
        Diary diary=session.get(Diary.class,11);


        System.out.println(student);
        System.out.println("********************************************");
        System.out.println(diary);
        System.out.println("********************************************");
        System.out.println(diary.getStudent());
        //diary studenta ulaşabiliyoruz.

        //id=1002 olan studentın diarysini görebilir miyiz???Hayır




        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
