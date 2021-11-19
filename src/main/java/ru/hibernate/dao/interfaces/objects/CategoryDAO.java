package ru.hibernate.dao.interfaces.objects;

import ru.hibernate.dao.interfaces.CommonDAO;
import ru.hibernate.dao.interfaces.FindDAO;
import ru.hibernate.entity.Category;


public interface CategoryDAO extends CommonDAO<Category>, FindDAO<Category> {
}
