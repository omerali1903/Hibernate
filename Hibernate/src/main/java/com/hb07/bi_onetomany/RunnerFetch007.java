package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch007 {

    public static void main(String[] args) {
        Configuration con=new Configuration().configure().addAnnotatedClass(Student07.class)
                .addAnnotatedClass(Book07.class);

        SessionFactory sf =con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //DELETE işlemi:
        //aşamalı silme yapabiliriz.

        //HQL ile
        //Book07 tablosundaki tüm kayıtları silelim.
//        String hql1="DELETE FROM Book07";
//        int numOfDeletedRecord=session.createQuery(hql1).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numOfDeletedRecord);
//
//
//        //Student07 tablosundaki tüm kayıtları silelim.
//        String hql2="DELETE FROM Student07";
//        int numOfDeletedRecord2=session.createQuery(hql2).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numOfDeletedRecord2);
//
//        //HQL:Kitab ismi: "Java Book" olan kitabı silelim.
//        String hql3="DELETE FROM Book07 b WHERE b.name='Java Book'";
//        int numOfDeletedRecord3=session.createQuery(hql3).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı: "+numOfDeletedRecord3);

        //kitabı olan bir öğrenciyi silmek istersek
           //1-önce Book tablosunda ilişkili booklar silinir, daha sonra öğrenci silinir.
           //2-cascadeType.REMOVAL vs orphanRemoval

        //session ın metodu ile
        //id:1001 olan studentı silelim.
        Student07 student=session.get(Student07.class,1001);
        //session.delete(student);
        //cascadeType.REMOVAL vs orphanRemoval aynı çalışır.

        // !!! 1002 id li studentın kitap listesinden ilkini silelim
        Student07 student2=session.get(Student07.class,1002);
        student2.getBookList().remove(0);//103,104,105->104,105
        //orphanRemoval=true, listeden bir objeyi kaldırırsak yada
        //null a set edersek bu objeyi tablodan da kaldırıyor.

        System.out.println(student2.getBookList());

        tx.commit();
        session.close();
        sf.close();
    }
}
