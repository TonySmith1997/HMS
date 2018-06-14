package com.hms.dao;

import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.BloodBank;
import com.hms.entity.Device;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BloodBankDAO extends BaseDAOImpl<BloodBank,Integer> {
    public Criterion findBloodbankLike(String searchName) {
        return findlike("bloodbankName",searchName);
    }

    public List<BloodBank>findBloodBank(String searchName) {
        Criterion c1 = findBloodbankLike(searchName);
        return createCriteria(c1).list();
    }
}
