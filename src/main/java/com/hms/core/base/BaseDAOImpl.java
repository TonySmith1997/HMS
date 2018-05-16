package com.hms.core.base;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository("baseDAO")
public class BaseDAOImpl<T,Pk extends Serializable> implements IBaseDAO<T,Pk>{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Class<T> clazz;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }


    public Serializable save(Object o) {
        return getCurrentSession().save(o);
    }

    public void delete(Object o) {
        getCurrentSession().delete(o);
    }

    public void update(Object o) {
        getCurrentSession().update(o);
    }

    public void saveOrUpdate(Object o) {
        getCurrentSession().saveOrUpdate(o);
    }

    public T find(  Serializable id) {
        return getCurrentSession().load(clazz,id);
    }


    public T findUniqueBy(String propertyName, Object value) {
        Criterion criterion = Restrictions.eq(propertyName,value);
        return (T) createCriteria(criterion).uniqueResult();
    }

    /**
     * 是否升序
     * @param orderByProperty
     * @param isAsc
     * @return
     */
    public List<T> findAll(String orderByProperty, boolean isAsc) {
        Criteria c = createCriteria();
        if(isAsc){
            c.addOrder(Order.asc(orderByProperty));
        }else{
            c.addOrder(Order.desc(orderByProperty));
        }
        return c.list();
    }

    /**
     * 默认升序
     * @param orderByProperty
     * @return
     */
    public List<T> findAll(String orderByProperty) {
        return findAll(orderByProperty,true);
    }


    /**
     * 默认按照id排序
     * @param isAsc
     * @return
     */
    public List<T> findAll(boolean isAsc) {
        return findAll("id",isAsc);
    }

    public List<T> findAll() {
        return findAll("id",true);
    }

    public Criteria createCriteria(Criterion... criterions) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        for(Criterion c : criterions){
            criteria.add(c);
        }
        return criteria;
    }

    public T findUnique(String hql, Map<String, ?> values) {
        return (T) createQuery(hql,values).uniqueResult();
    }



    public Query createQuery(final String queryString, final Map<String,?> values){
        Assert.hasText(queryString,"queryString cannot be empty");
        Query query = getCurrentSession().createQuery(queryString);
        if(values !=null){
            query.setProperties(values);
        }
        return query;
    }

    public void initProxyObject(Object proxy) {
        Hibernate.initialize(proxy);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
