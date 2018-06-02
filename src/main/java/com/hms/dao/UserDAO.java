package com.hms.dao;

import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.User;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAO extends BaseDAOImpl<User,Integer> {
    public Criterion findEmployeeLike(String searchName) {
        return findlike("trueName",searchName);
    }

    public Criterion findEmployee() {
        return findEQ("ifEmloyee",true);
    }

    public List<User> findEmployee(String searchName) {
        Criterion c1 = findEmployeeLike(searchName);
        Criterion c2 = findEmployee();
        return createCriteria(c1,c2).list();
    }
}
