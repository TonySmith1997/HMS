package com.hms.core.base;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * 提供基础的service的操作
 */
public abstract class BaseService<T,Pk extends Serializable> {

    public abstract BaseDAOImpl<T,Pk> getBaseDAO();

    @Transactional(readOnly = true)
    public T get(final Pk id) {
        return getBaseDAO().find(id);
    }

    @Transactional(readOnly = false)
    public void save(final T entity){
        getBaseDAO().save(entity);
    }

    @Transactional(readOnly = false)
    public void update(final T entity){
        getBaseDAO().update(entity);
    }

    @Transactional(readOnly = false)
    public void delete(final T entity){
        getBaseDAO().delete(entity);
    }

    @Transactional(readOnly = true)
    public List<T> getAll(){
        return getBaseDAO().findAll();
    }


}
