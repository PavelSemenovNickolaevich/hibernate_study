package ru.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.hibernate.entity.User;


@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Hibernate tutorial started");

        Session session = HibernateUtil.getSessionFactory().openSession();

        //  session.getTransaction().begin();

        log.info("Transaction started");

//        User user = new User();
//        user.setEmail("terminator11@gmail.com");
//        user.setUsername("John11");
//        user.setPassword("32167811");

//        session.save(user);

        // подготовка запроса - получение всех пользователей
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root); // конечный запрос select из таблицы User
//
//        Predicate p1 = criteriaBuilder.gt(root.get("id"), 10000);
//        Predicate p2 = criteriaBuilder.lt(root.get("id"), 20000);
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1 ,p2));
//
//        // выполнение запроса с получением результата
//        Query query = session.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
        //        log.info(users);

// delete
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
//        Root<User> root = criteriaDelete.from(User.class);
//        criteriaDelete.where(cb.equal(root.get("id"), 10514));
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(criteriaDelete).executeUpdate();
//        transaction.commit();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> criteriaUpdate = cb.createCriteriaUpdate(User.class);
        Root<User> root = criteriaUpdate.from(User.class);

        criteriaUpdate.set("email", "2345435");
        criteriaUpdate.where(cb.equal(root.get("id"), 10516));

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaUpdate).executeUpdate();
        transaction.commit();

        //  session.getTransaction().commit();

        session.close();
        HibernateUtil.close();
    }
}
