package com.hms.dao;
import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.Drug;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DrugDAO extends BaseDAOImpl<Drug,Integer> {
    public Criterion findDrugLike(String searchName) {
        return findlike("drugName",searchName);
    }

    public List<Drug> findDrug(String searchName) {
        Criterion c1 = findDrugLike(searchName);
        return createCriteria(c1).list();
    }
}
