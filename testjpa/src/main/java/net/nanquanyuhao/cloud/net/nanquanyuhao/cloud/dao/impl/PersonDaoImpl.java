package net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.dao.impl;

import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.dao.PersonDaoCustom;
import net.nanquanyuhao.cloud.net.nanquanyuhao.cloud.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by nanquanyuhao on 2017/11/26.
 */
public class PersonDaoImpl implements PersonDaoCustom{

    @PersistenceContext
    private EntityManager em;

    public List<Person> myQuery() {

        Query q = em.createQuery("from Person");
        return q.getResultList();
    }
}
