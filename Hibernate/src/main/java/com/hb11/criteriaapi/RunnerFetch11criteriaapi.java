package com.hb11.criteriaapi;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11criteriaapi {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);
        SessionFactory sessionFactory =config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        CriteriaBuilder cb = session.getCriteriaBuilder();

      CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);


        criteriaQuery.select(root);

        List<Student11> resultList = session.createQuery(criteriaQuery).getResultList();
        resultList.forEach(System.out::println);






        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
