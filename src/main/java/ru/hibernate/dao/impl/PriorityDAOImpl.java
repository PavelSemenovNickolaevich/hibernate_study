package ru.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.hibernate.HibernateUtil;
import ru.hibernate.dao.interfaces.objects.PriorityDAO;
import ru.hibernate.entity.Priority;
import ru.hibernate.entity.User;

import java.util.List;

public class PriorityDAOImpl implements PriorityDAO {

    @Override
    public Priority get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Priority user = session.get(Priority.class, id);
        session.close();
        return user;
    }

    @Override
    public void update(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это операция изменения - должны использовать транзакцию
        session.update(obj); // если id объекта НЕ будет заполнено - выйдет ошибка (Hibernate не поймет какую именно строку хотите обновить)
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это операция изменения - должны использовать транзакцию
        Priority u = new Priority();// создаем временный объект и заполняем его id
        u.setId(id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.save(obj); // если id объекта будет заполнено - БД перезапишет это поле
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Priority> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority ");
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Priority> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority p where p.user.email like :email ");
        query.setParameter("email", email);
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }
}
