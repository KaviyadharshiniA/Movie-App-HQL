package com.example.movie.dao;

import com.example.movie.model.Movie;
import com.example.movie.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class MovieDAO {

    public void addMovie(Movie m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(m);

        session.getTransaction().commit();
        session.close();
    }

    public void showMovies() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Movie> q = session.createQuery("from Movie", Movie.class);
        List<Movie> list = q.list();

        for (Movie m : list) {
            System.out.println(m);
        }

        session.close();
    }

    public void searchMovie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Movie> q = session.createQuery("from Movie where movieId=:id", Movie.class);
        q.setParameter("id", id);

        Movie m = q.uniqueResult();
        System.out.println(m);

        session.close();
    }

    public void updatePrice(int id, double price) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("update Movie set price=:p where movieId=:id");
        q.setParameter("p", price);
        q.setParameter("id", id);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void deleteMovie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query q = session.createQuery("delete from Movie where movieId=:id");
        q.setParameter("id", id);

        q.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}