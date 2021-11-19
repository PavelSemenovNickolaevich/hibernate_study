package ru.hibernate.dao.interfaces;

import java.util.List;

public interface FindDAO<T>{

    // получить абсолютно все значения
    List<T> findAll();

    // получить все значения по значению почты
    List<T> findAll(String email);
}
