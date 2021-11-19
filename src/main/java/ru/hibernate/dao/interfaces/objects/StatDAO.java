package ru.hibernate.dao.interfaces.objects;

import ru.hibernate.entity.Stat;
import ru.hibernate.entity.User;

public interface StatDAO {

    Stat getByUser(String email);
    Stat getByUser(User user);
}
