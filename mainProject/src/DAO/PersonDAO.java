package DAO;

import Entities.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nsalahub on 12/16/2014.
 */
@Repository
public class PersonDAO {
    private SessionFactory sessionFactory;
    public Person getByID(Long id){
        return (Person)sessionFactory.getCurrentSession().get(Person.class, id);
    }
}
