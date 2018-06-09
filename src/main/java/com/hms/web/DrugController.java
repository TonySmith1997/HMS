package com.hms.web;
        import com.hms.entity.*;
        import com.hms.service.*;
        import com.hms.type.EmployeeType;
        import com.hms.type.LogType;
        import com.sun.javafx.binding.StringFormatter;
        import org.apache.log4j.LogManager;
        import org.apache.log4j.Logger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.*;

        import java.math.BigDecimal;
        import java.util.Date;
        import java.util.List;

        import static org.springframework.web.bind.annotation.RequestMethod.GET;
        import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/drug")
public class DrugController {
    protected Logger log = LogManager.getLogger(DrugController.class);

    @Autowired
    private DrugService drugService;
    @Autowired
    private DeviceService deviceService;
    /**
     * 显示主页面
     * 最新更新时间
     * 用户数量
     * 员工表
     * 科室表
     * @param map
     * @return
     */
    @RequestMapping(value = "",method = GET)
    public String getDrugLog(ModelMap map){
        List<Drug> drugs = drugService.getAll();
        List<Device> deviceList=deviceService.getAll();
        int count = drugService.count();
        int devicecount=deviceService.count();
        Date LastUpdate = drugService.getLastUpdate();
        map.addAttribute("lastUpdate",LastUpdate);
        map.addAttribute("drugCount",count);
        map.addAttribute("deviceCount",devicecount);
        map.addAttribute("deviceList",deviceList);
        map.addAttribute("drugs",drugs);
        return "drugLog";
    }
/**return value to  data
 */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    Drug getDrugDetail(@PathVariable String id) {
        Integer drugId = Integer.valueOf(id);
        Drug drugInfo = drugService.get(drugId);
        return drugInfo;
    }
    /**
     * submit form ,update drug
     * @param drugid
     * @param drugname
     * @param effect
     * @param descriptions
     * @param qty
     * @param unitprice
     * @return
     */
    @RequestMapping(value = "update",method=POST)
    public String updateDrug(
            @RequestParam("drugid") String drugid,
            @RequestParam("drugname") String drugname,
            @RequestParam("effect") String effect,
            @RequestParam("descriptions") String descriptions,
            @RequestParam("qty") String qty,
            @RequestParam("unitPrice") String unitprice,
            @RequestParam("instruments")String instruments)
    {
        int drugId = Integer.valueOf(drugid.trim());
        Drug drug = drugService.get(drugId);
        drug.setDrugName(drugname.trim());
        drug.setEffect(effect.trim());
       // drug.setUnitPrice(BigDecimal.valueOf(unitprice.trim()));
        BigDecimal d = new BigDecimal(unitprice);
        drug.setUnitPrice(d);
        drug.setDescription(descriptions.trim());
        drug.setQty(Integer.valueOf(qty.trim()));
        drug.setInstrument(instruments.trim());
        drug.setUpdateBy(1);
        Date date = new Date();
        drug.setUpdateTime(date);
        drugService.update(drug);

        return "drugLog";
    }

    /**
     *insert new drug
     * @param drugname
     * @param effect
     * @param description
     * @param qty
     * @param unitprice
     * @param instrument
     * @return
     */

    @RequestMapping(value = "insert",method=POST)
    public String insertDrug(

            @RequestParam("drugname") String drugname,
            @RequestParam("effect") String effect,
            @RequestParam("descriptions") String description,
            @RequestParam("qty") String qty,
            @RequestParam("unitPrice") String unitprice,
            @RequestParam("instruments")String instrument)
    {
        Drug drug=new Drug();
        drug.setAvator("/static/img/a1.jpg");
        drug.setDrugName(drugname.trim());
        drug.setEffect(effect.trim());
        BigDecimal d = new BigDecimal(unitprice);
        drug.setUnitPrice(d);
        drug.setDescription(description.trim());
        drug.setQty(Integer.valueOf(qty.trim()));
        drug.setInstrument(instrument.trim());
        drug.setUpdateBy(1);
        Date date = new Date();
        drug.setUpdateTime(date);
        drugService.save(drug);
        return "drugLog";
    }
/**
 * 显示表单更新时的弹出框
 * @param id
 * @return
 */

    @RequestMapping(value = "/update/{id}",method = GET)
    public @ResponseBody Drug getDrugForUpdate(@PathVariable String id) {
        Integer drugId = Integer.valueOf(id);
        Drug drugInfo = drugService.get(drugId);
        return drugInfo;
}
    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
    public @ResponseBody
    List<Drug> getDrugLike(@PathVariable String searchName) {
        List<Drug> drugs = drugService.getDrugLike(searchName.trim()+"%");
        return drugs;
    }


}

