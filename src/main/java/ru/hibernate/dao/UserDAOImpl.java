package ru.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.hibernate.HibernateUtil;
import ru.hibernate.entity.User;

import java.util.List;

public class UserDAOImpl implements CommonDAO<User> {

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User");
        List<User> listUser = query.getResultList();
        session.close();
        return listUser;
    }

    @Override
    public List<User> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User where email like :email");
        query.setParameter("email", "%" + email + "%");
        List<User> listUser = query.getResultList();
        session.close();
        return listUser;
    }

    @Override
    public User get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id); // получаем единичный объект
        session.close();
        return user;
    }

    @Override
    public void update(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.update(obj); // если id объекта НЕ будет заполнено - выйдет ошибка (Hibernate не поймет какую именно строку хотите обновить)
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        User u = new User();// создаем временный объект и заполняем его id
        u.setId(id);
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // т.к. это опреация изменения - должны использовать транзакцию
        session.save(obj); // если id объекта будет заполнено - БД перезапишет это поле
        session.getTransaction().commit();
        session.close();
    }
}
