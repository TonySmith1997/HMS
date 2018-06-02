package com.hms.core.base;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseDAO<T,Pk extends Serializable> {
    /**
     * basic crud
     */
    public Serializable save(final T o);
    public void delete(final T o);
    public void update(final T o);
    public void saveOrUpdate(final T o);
    public T find(final Pk id);
    public T findUniqueBy(final String propertyName,final Object value);
    public List<T> findAllEq(String propertyName,Object value);
    public List<T> findAllLike(String propertyName, Object value);//模糊搜索
    public List<T> findAllNOTNULL(String propertyName);

    Criterion findlike(String propertyName, Object value);

    Criterion findEQ(String propertyName, Object value);

    /**
     * findAll
     */
    public List<T> findAll(String orderByProperty,boolean isAsc);
    public List<T> findAll(String orderByProperty);
    public List<T> findAll(boolean isAsc);
    public List<T> findAll();
    public Criteria createCriteria(final Criterion... criterions);


    /**
     * HQL
     */
    public T findUnique(final String hql,final Map<String, ?> values);
    public Integer count();

    public void initProxyObject(Object proxy);
    public void flush();

}
