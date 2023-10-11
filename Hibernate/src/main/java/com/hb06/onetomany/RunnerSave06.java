package com.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06 {
    public static void main(String[] args) {

        Student06 student1=new Student06(1001,"Fazıl Bey",90);
        Student06 student2=new Student06(1002,"Aynur Hanım",90);
        Student06 student3=new Student06(1003,"Yavuz Bey",90);

        Book06 book1=new Book06(101,"Java Book");
        Book06 book2=new Book06(102,"Math Book");
        Book06 book3=new Book06(103,"Chem Book");
//bookları eklemek için
        //1.yöntem
        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        //2.yöntem
        List<Book06> bookList=new ArrayList<>();
        bookList.add(book3);
        student2.setBookList(bookList);



        Configuration con=new Configuration().configure().
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();




    }
}
