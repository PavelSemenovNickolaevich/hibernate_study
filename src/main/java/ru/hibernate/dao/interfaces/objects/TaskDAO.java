package ru.hibernate.dao.interfaces.objects;

import ru.hibernate.dao.interfaces.CommonDAO;
import ru.hibernate.dao.interfaces.FindDAO;
import ru.hibernate.entity.Task;

import java.util.List;

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {


    List<Task> find(boolean completed, String email);
}
