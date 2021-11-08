package ru.hibernate;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.hibernate.entity.User;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@Log4j2
public class MainHQL {

    public static void main(String[] args) {

                /*
Варианты получения
User
new User(username, email)
int
Object[]

 */


        Session session = HibernateUtil.getSessionFactory().openSession();
        // Example1
//        Query query = session.createQuery("From User u where u.email like :text");

        // Example2
//        Query query = session.createQuery("From User");

//        query.setFirstResult(1);
//        query.setMaxResults(10);
//        query.setParameter("text", "%2%");

        // Example3
//        Query query = session.createQuery("From User u where id=:id");
//        query.setParameter("id", 10025L);
//        query.uniqueResult();
//        List<User> userList = query.getResultList();
//        log.info(userList.size());

        //Example4
//        Query<Long> query = session.createQuery("select " +
//                "count(u.id) from User u " +
//                "where email like :text");
//        query.setParameter("text", "%email%");
//
//      //  List<Long> count = query.getResultList();
//        Long count = query.uniqueResult();
//        log.info(count);


        // userList.forEach(user -> System.out.println(user));

        //        for(User user: userList) {
//            System.out.println(user);
//        }
        //Example5

//        Query<User> query = session.createQuery("select new User(u.email, u.username) from User u where id=:id");
//
//        query.setParameter("id", 10037L);
//
//        User user = query.uniqueResult();
//
//        log.info(user.getUsername());

        //Example6
//        String qry = "select * from todolist.user_data";
//        NativeQuery sqlQuery = session.createSQLQuery(qry);
//        sqlQuery.setMaxResults(10);
//        sqlQuery.addEntity(User.class);
//
//        List<User> list = sqlQuery.list();
//
//        log.info(list);

        //Example7

        NativeQuery<Object[]> query = session.createNativeQuery("select " +
                "       count(u.id), " +
                "       substring(u.email, position('@' in u.email)+1, length(u.email)) as domainemail " +
                "from todolist.user_data u  " +
                "where u.email like '%@%' " +
                "group by substring(u.email, position('@' in u.email)+1, length(u.email))");

        log.info(query.getResultList());

        for (Object[] obj: query.getResultList()) {
//            Object[] objArray = (Object[]) obj;
            log.info(obj[0]);
            log.info(obj[1]);
            log.info("-----");
        }


        session.close();
        HibernateUtil.close();
    }
}
