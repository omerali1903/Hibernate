package com.hb07.bi_onetomany;

import com.hb06.onetomany.Book06;
import com.hb06.onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student1=new Student07(1001,"Fazıl Bey",90);
        Student07 student2=new Student07(1002,"Aynur Hanım",90);
        Student07 student3=new Student07(1003,"Yavuz Bey",90);

        Book07 book1=new Book07(101,"Java Book");
        Book07 book2=new Book07(102,"Math Book");
        Book07 book3=new Book07(103,"C++ Book");
        Book07 book4=new Book07(104,"React Book");
        Book07 book5=new Book07(105,"Chem Book");

        // ilişki sahibi tarafından set edilmeli, aksi takdirde FK sütununda değerler null olur
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student2);

//        student1.getBookList().add(book1);
//        student1.getBookList().add(book2);



        Configuration con=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sf.close();



    }
}
