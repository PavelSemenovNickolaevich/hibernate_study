package ru.hibernate;

import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import ru.hibernate.entity.User;


@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Hibernate tutorial started");


        Session session = HibernateUtil.getSessionFactory().openSession();

        session.getTransaction().begin();

        log.info("Transaction started");

        User user = new User();
        user.setEmail("terminator11@gmail.com");
        user.setUsername("John11");
        user.setPassword("32167811");

        session.save(user);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.close();

    }
}
