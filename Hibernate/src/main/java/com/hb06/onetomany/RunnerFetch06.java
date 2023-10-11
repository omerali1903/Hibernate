package com.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration con=new Configuration().configure().
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //id si 1001 olan studentı görelim.
        Student06 student=session.get(Student06.class,1001);
      System.out.println(student);

        //id si 101 olan book u görelim.
        Book06 book=session.get(Book06.class,101);
       System.out.println(book);
        //book un sahibi olan studentı göremiyoruz.

        //id si 1001 olan studentın tüm kitapları görelim.
        System.out.println(student.getBookList());

        //yukarıdaki sorguyu HQL ile yapalım.
        System.out.println("------------------------------------------------------------------");
        String hqlQuery="SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> resultList=session.createQuery(hqlQuery).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));





        tx.commit();
        session.close();
        sf.close();



    }
}
