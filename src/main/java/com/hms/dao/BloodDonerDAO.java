package com.hms.dao;
import com.hms.core.base.BaseDAOImpl;
import com.hms.entity.BloodDonor;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BloodDonerDAO extends BaseDAOImpl<BloodDonor,Integer> {
    public Criterion findBlooddonorLike(String searchName) {
        return findlike("name",searchName);
    }

    public List<BloodDonor> findBlooddonor(String searchName) {
        Criterion c1 = findBlooddonorLike(searchName);

        return createCriteria(c1).list();
    }
}
