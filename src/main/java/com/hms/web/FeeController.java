package com.hms.web;

import com.hms.entity.*;
import com.hms.entity.vo.FeeVo;
import com.hms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/fee")
@Controller
public class FeeController {
    @Autowired
    private InHospitalInfoService inHospitalInfoService;
    @Autowired
    private DrugFeeService drugFeeService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private UserService userService;
    @Autowired
    private DrugService drugService;


    @Transactional
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String getTotalFee(@PathVariable(value = "id") String userId, ModelMap map) {
        Integer id = Integer.valueOf(userId);
        User user = userService.get(id);
        InHospitalInfo inHospitalInfo = inHospitalInfoService.getHospitalInfo(id);
        List<DrugFee> drugFees = drugFeeService.getDrugFeeByPatient(id);
        List<PhysicalExamination> checks = checkService.getCheckByPatient(id);
        ArrayList<FeeVo> feeVos = new ArrayList<>();
        BigDecimal totalFee = new BigDecimal("0");
        FeeVo feeVo1 = null;
        /** 住院费 **/
        if(inHospitalInfo != null) {
            BigDecimal hospitalFee = inHospitalInfo.getFee();
            Date startTime = inHospitalInfo.getStartTime();
            Date endTime = inHospitalInfo.getEndTime();
            feeVo1 = new FeeVo("Hospitalization",1, hospitalFee, "Time: " + startTime + "~" + endTime);
            feeVos.add(feeVo1);
            totalFee = totalFee.add(hospitalFee);
        }
        /**药物费用 **/
        for(DrugFee drugFee : drugFees) {
            int drugId = drugFee.getDrugId();
            Drug drug = drugService.get(drugId);
            String drugName = drug.getDrugName();
            BigDecimal drugPrice  = drug.getUnitPrice();
            int drugNum  =drugFee.getDrugNum();
            Date drugTime = drug.getCreateTime();
            feeVo1 = new FeeVo(drugName,drugNum,drugPrice,drugTime+"");
            feeVos.add(feeVo1);
            totalFee = totalFee.add(drugPrice);
        }

        /** 检查费用 **/
        for(PhysicalExamination check : checks) {
            String checkName = check.getCheckName();
            BigDecimal checkPrice = check.getFee();
            Date checkTime = check.getCreateTime();
            feeVo1 = new FeeVo(checkName,1,checkPrice,checkTime +"");
            feeVos.add(feeVo1);
            totalFee = totalFee.add(checkPrice);
        }

        /** 总价 **/

        map.addAttribute("user",user);
        map.addAttribute("fees",feeVos);
        map.addAttribute("toalFee",totalFee);
        return "TotalFee";
    }

    @Transactional
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void addDrug(@RequestParam("patientId") String patientId,
                        @RequestParam("drugName") String drugName,
                        @RequestParam("drugNum") String drugNum,
                        @RequestParam("recordId") String recordId) {
        DrugFee drugFee = new DrugFee();
        drugFee.setCreateBy(1);
        drugFee.setCreateTime(new Date());
        Drug drug = drugService.getDrugByName(drugName.trim());
        drugFee.setDrugId(drug.getId());
        int drugNums = Integer.valueOf(drugNum);
        drugFee.setDrugNum(drugNums);
        drugFee.setPatientId(Integer.valueOf(patientId));
        drugFee.setMedicalRecordId(Integer.valueOf(recordId));
        drugFeeService.save(drugFee);
        /** drug part **/
        int drugQty = drug.getQty();
        drug.setQty(drugQty-drugNums);
        drugService.update(drug);
    }
}
