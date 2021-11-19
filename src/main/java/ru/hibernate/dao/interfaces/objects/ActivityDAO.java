package ru.hibernate.dao.interfaces.objects;

import ru.hibernate.dao.interfaces.CommonDAO;
import ru.hibernate.entity.Activity;
import ru.hibernate.entity.User;

public interface ActivityDAO extends CommonDAO<Activity> {

    Activity getByUser(User user);
    Activity getByUser(String email);
}
