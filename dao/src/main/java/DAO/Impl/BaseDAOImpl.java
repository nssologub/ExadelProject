package main.java.DAO.Impl;

import DAO.BaseDAO;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by alupachou on 12/16/2014.
 */

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    public BaseDAOImpl() {
    }

    public BaseDAOImpl(Class<T> type)  {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }

    @Override
    public void create(T t) {
        if (t == null) {
            return;
        }
        sessionFactory.getCurrentSession().saveOrUpdate(t);
    }

    @Override
    public T read(Long id) {
        T result = (T) sessionFactory.getCurrentSession().load(type, id);
        if (result != null) {
            Hibernate.initialize(result);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public T update(T t) {
        if(t == null){
            return null;
        }
        sessionFactory.getCurrentSession().update(t);
        return t;
    }

    @Override
    public void delete(T t) {
        if(t == null){
            return;
        }
        sessionFactory.getCurrentSession().delete(t);
    }
}