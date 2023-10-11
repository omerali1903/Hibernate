package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch11 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory =config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        /*
        session methodlari
        C:save
        R:get
        U:update
        D:delete
         */


        //UPDATE islemi

        int defaultgrade=30;
        int updatedgrade=80;

       Student11 student = session.get(Student11.class,1L);
       student.setMathGrade(40);
       session.update(student);

       //TASK: MathGrade puani 30 dan kucuk olan ogrencilerin puanlarini 80 yapalim
        String hqlQuery = "UPDATE Student11 SET mathGrade=:sMath WHERE mathGrade<:lMath";
        Query query = session.createQuery(hqlQuery);
        query.setParameter("sMath",updatedgrade);
        query.setParameter("lMath",defaultgrade);

        int updatedrecord =query.executeUpdate();
        System.out.println("Guncellenen kayit sayisi : " + updatedrecord);







        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
