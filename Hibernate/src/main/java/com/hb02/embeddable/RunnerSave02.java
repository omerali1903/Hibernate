package com.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {
        Student02 student1=new Student02();
        student1.setId(1001);
        student1.setName("Vehbi Demirezen");
        student1.setGrade(99);
       // student1.setAddress();

        Address address1=new Address();
        address1.setStreet("Apple St.");
        address1.setCity("NewYork");
        address1.setCountry("US");
        address1.setZipCode("65123");

        student1.setAddress(address1);

        Student02 student2=new Student02();
        student2.setId(1002);
        student2.setName("Yavuz Çoban");
        student2.setGrade(98);

        Address address2=new Address();
        address2.setStreet("Orange St.");
        address2.setCity("London");
        address2.setCountry("England");
        address2.setZipCode("425123");

        student2.setAddress(address2);

        Configuration con=new Configuration().configure().addAnnotatedClass(Student02.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session =sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit();
        session.close();
        sf.close();

    }

}
