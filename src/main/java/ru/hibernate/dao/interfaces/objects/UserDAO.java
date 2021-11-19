package ru.hibernate.dao.interfaces.objects;

import ru.hibernate.dao.interfaces.CommonDAO;
import ru.hibernate.dao.interfaces.FindDAO;
import ru.hibernate.entity.User;

public interface UserDAO extends CommonDAO<User>, FindDAO<User> {

    //Получение только одного пользователя по email
    User getByEmail(String email);
}
