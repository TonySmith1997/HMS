package com.hms.service;

        import com.hms.core.base.BaseDAOImpl;
        import com.hms.core.base.BaseService;
        import com.hms.dao.DrugDAO;
        import com.hms.entity.Drug;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.Date;
        import java.util.List;

@Service
@Transactional(readOnly = true)
public class DrugService extends BaseService<Drug,Integer> {
    @Autowired
    private DrugDAO drugDAO;

    public BaseDAOImpl<Drug, Integer> getBaseDAO() {
        return drugDAO;
    }

    @Transactional
public Date getLastUpdate() {
    String propertyName = "updateTime";
    List<Drug> drugInfos =  drugDAO.findAll(propertyName,false);
    return drugInfos.get(0).getUpdateTime();
}
    @Transactional
    public List<Drug> getDrugLike(String searchName) {
        return drugDAO.findDrug(searchName);
    }

    @Transactional
    public Drug getDrugByName(String drugName) {
        return drugDAO.findUniqueBy("drugName",drugName);
    }
}