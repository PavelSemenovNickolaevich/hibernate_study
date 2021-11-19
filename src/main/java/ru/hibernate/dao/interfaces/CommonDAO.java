package ru.hibernate.dao.interfaces;

import java.util.List;

//CRUD
public interface CommonDAO<T> {

    // получить одно значение по id
    T get(long id);

    // обновить значение
    void update(T obj);

    // удалить значение по id
    void delete(long id);

    // добавить значение
    void add(T obj);
}
