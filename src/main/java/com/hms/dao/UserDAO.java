package com.hms.dao;

import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.User;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAO extends BaseDAOImpl<User,Integer> {
    public Criterion findLike(String searchName) {
        return findlike("trueName",searchName);
    }

    public Criterion findEmployee() {
        return findEQ("ifEmloyee",true);
    }


    public Criterion findPatient() {
        return findEQ("ifEmloyee",false);
    }

    public List<User> findEmployee(String searchName) {
        Criterion c1 = findLike(searchName);
        Criterion c2 = findEmployee();
        return createCriteria(c1,c2).list();
    }
    public List<User> findPatient(String searchName) {
        Criterion c1 = findLike(searchName);
        Criterion c2 = findPatient();
        return createCriteria(c1,c2).list();
    }
}
