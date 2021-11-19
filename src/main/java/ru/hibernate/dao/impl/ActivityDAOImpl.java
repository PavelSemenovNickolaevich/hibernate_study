package ru.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.hibernate.HibernateUtil;
import ru.hibernate.dao.interfaces.objects.ActivityDAO;
import ru.hibernate.entity.Activity;
import ru.hibernate.entity.User;

public class ActivityDAOImpl implements ActivityDAO {

    @Override
    public Activity get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Activity user = session.get(Activity.class, id);
        session.close();
        return user;
    }

    @Override
    public void update(Activity obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.update(obj); // если id объекта НЕ будет заполнено - выйдет ошибка (Hibernate не поймет какую именно строку хотите обновить)
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(long id) {
        throw new IllegalStateException("you can not delete activity by yourself - only DB can");
    }

    @Override
    public void add(Activity obj) {
        throw new IllegalStateException("you can not add activity by yourself - only DB can");
    }

    @Override
    public Activity getByUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Activity> query = session.createQuery("FROM Activity where user.email like :email");
        query.setParameter("email", email);
        Activity activity = query.uniqueResult();
        session.close();
        return activity;
    }

    @Override
    public Activity getByUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Activity> query = session.createQuery("FROM Activity where user.email like :email");
        query.setParameter("email", "%" + user.getEmail() + "%");
        Activity activity = query.uniqueResult();
        session.close();
        return activity;
    }
}
