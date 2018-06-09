package com.hms.dao;

import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.Department;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartementDAO extends BaseDAOImpl<Department,Integer>{
    public Criterion findLike(String searchName) {
        return findlike("departName",searchName);
    }

    public List<Department> findDepartmentLike(String searchName) {
        Criterion c1 = findLike(searchName);
        return createCriteria(c1).list();
    }
}
