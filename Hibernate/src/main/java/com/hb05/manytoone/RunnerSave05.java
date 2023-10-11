package com.hb05.manytoone;

import com.hb04.bi_onetoone.Diary04;
import com.hb04.bi_onetoone.Student04;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        University university1=new University(1,"TPE University");
        University university2=new University(2,"Hibernate University");

        Student05 student1=new Student05();
        student1.setId(1001);
        student1.setName("Bahadır Bey");
        student1.setGrade(98);
        student1.setUniversity(university1);

        Student05 student2=new Student05();
        student2.setId(1002);
        student2.setName("Ebru Hanım");
        student2.setGrade(98);
        student2.setUniversity(university1);

        Student05 student3=new Student05();
        student3.setId(1003);
        student3.setName("Fazıl Bey");
        student3.setGrade(100);
        student3.setUniversity(university2);



        Configuration config=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory =config.buildSessionFactory();//session başlatılmasını sağlar
        Session session=sessionFactory.openSession();
        //sesssion DB ile iletişime geçip bazı işlemler yapmamızı sağlayan metodlara sahip
        Transaction tx =session.beginTransaction();

        session.save(university1);
        session.save(university2);

        session.save(student1);
        session.save(student2);
        session.save(student3);




        tx.commit();
        session.close();
        sessionFactory.close();

    }
}
