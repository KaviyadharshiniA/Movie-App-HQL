package com.example.movie.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.example.movie.model.Member;
import com.example.movie.util.HibernateUtil;

import java.util.List;

public class MemberDAO {

    public void addMember(Member m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(m);

        session.getTransaction().commit();
        session.close();
    }

    public void showMembers() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Member> q = session.createQuery("from Member", Member.class);
        List<Member> list = q.list();

        for (Member m : list) {
            System.out.println(m);
        }

        session.close();
    }

    public void searchMember(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Member> q = session.createQuery("from Member where memberId=:id", Member.class);
        q.setParameter("id", id);

        Member m = q.uniqueResult();
        System.out.println(m);

        session.close();
    }

    public void deleteMember(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("delete from Member where memberId=:id");
        q.setParameter("id", id);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}