package com.hms.web;
        import com.hms.entity.*;
        import com.hms.service.*;
        import org.apache.log4j.LogManager;
        import org.apache.log4j.Logger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;
//        import java.util.date;
        import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/drug")
public class DrugController {
    protected Logger log = LogManager.getLogger(DrugController.class);

    @Autowired
    private DrugService drugService;
    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "",method = GET)
    public String getDrugLog(ModelMap map){
        List<Drug> drugs = drugService.getAll();
        List<Device> deviceList=deviceService.getAll();
        int count = drugService.count();
//        Date LastUpdate = drugService.getLastUpdate();
//        map.addAttribute("lastUpdate",LastUpdate);
        map.addAttribute("drugCount",count);
        map.addAttribute("deviceList",deviceList);
        map.addAttribute("drugs",drugs);
        return "drugLog";
    }
    /**
     * 表单提交更新员工
     * @param id
     * @param drugName
     * @param description
     * @param effect
     * @param unitPrice
     * @return
     */
/**
 * 显示表单更新时的弹出框
 * @param id
 * @return
 */
    @RequestMapping(value = "/update/{id}",method = GET)
    public @ResponseBody Drug getDrugForUpdate(@PathVariable String id) {
        Integer drugId = Integer.valueOf(id);
        Drug drugInfo = drugService.get(drugId);
//        User user = drugService.get(drugId);
//        drugInfo.setUser(user);
//        Integer deviceId = Integer.valueOf(id);
//        Device deviceInfo = deviceService.get(deviceId);
        return drugInfo;
}
    /**
     * 获得用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    Drug getDrugDetail(@PathVariable String id) {
        Integer drugId = Integer.valueOf(id);
        Drug drugInfo = drugService.get(drugId);
//        User user = userService.get(userId);
//        List<EmployeeLog> employeeLogs = employeeLogService.getEmployeeLog(userId);
//        drugInfo.setId(drugId);
//        drugInfo.setEmployeeLogs(employeeLogs);
        return drugInfo;
    }
}

