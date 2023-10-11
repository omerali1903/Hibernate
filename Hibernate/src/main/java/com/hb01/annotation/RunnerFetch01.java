package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory =config.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx =session.beginTransaction();

        //DB den data çekmek istersek 3 yol var

        //1.yol:sessionın get metodunu kullanma
//        Student01 student1=session.get(Student01.class,1001);
//        Student01 student2=session.get(Student01.class,1002);
//        Student01 student3=session.get(Student01.class,1003);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);

        //2.yol:SQL kullanma
//        String sqlQuery="SELECT * FROM t_student01";
//        List<Object[]> resultList=session.createSQLQuery(sqlQuery).getResultList();
//        for(Object[] objects:resultList){
//            System.out.println(Arrays.toString(objects));
//        }

        //3.yol: HQL kullanma
//        String hqlQuery="FROM Student01";
//        List<Student01> resultList2=session.createQuery(hqlQuery, Student01.class).getResultList();
//        for (Student01 student:resultList2){
//            System.out.println(student);
//        }

        //3 yöntemli kıyaslayalalım:
        //1-sessionın metodu, 2-HQL, 3-SQL

        //SQL ile koşul belirterek data çekme
//        String sqlQuery2="SELECT * FROM t_student01 WHERE std_name='Yusuf Çoban'";
//        Object[] uniqueResult= (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//        //uniqueResult() gelen kaydın tek satır olduğundan emin olduğumuzda kullanılır.
//        System.out.println(Arrays.toString(uniqueResult));


        //HQL ile koşul belirterek data çekme
//        String hqlQuery2="FROM Student01 WHERE name='Yusuf Çoban'";
//        //Object student=session.createQuery(hqlQuery2).uniqueResult();
//        Student01 student=session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(student);

        //yukarıdaki sorguda HQL ile alias kullanalım
//        String hqlQuery3="FROM Student01 std WHERE std.name='Yusuf Çoban'";
//        //Object student=session.createQuery(hqlQuery2).uniqueResult();
//        Student01 student2=session.createQuery(hqlQuery3, Student01.class).uniqueResult();
//        System.out.println(student2);

        //HQL ile grade i 98 olan kaydın(öğrencinin) sadece id ve name ini getirelim.
        String hqlQuery4="SELECT s.id, s.name FROM Student01 s WHERE s.grade=98";
        Object[] result= (Object[]) session.createQuery(hqlQuery4).uniqueResult();
        System.out.println(Arrays.toString(result));


        tx.commit();
        session.close();
        sessionFactory.close();




    }
}
