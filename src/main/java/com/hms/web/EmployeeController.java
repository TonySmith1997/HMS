package com.hms.web;

import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.entity.logs.EmployeeLog;
import com.hms.service.EmployeeLogService;
import com.hms.service.EmployeeService;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeLogService employeeLogService;


    @RequestMapping(value = "/employee",method = GET)
    public String getTotalList(ModelMap map){
        List<User> employees = userService.getEmployeeList();
        map.addAttribute("employee",employees);
        return "TotalList";
    }

    @RequestMapping(value = "/employee/info",method = GET)
    public String getEmployeeInfo(ModelMap map,int userId) {
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        map.addAttribute("employeeInfo",employeeInfo);
        List<EmployeeLog> employeeLogs  = employeeLogService.getEmployeeLog(userId);
        return "TotalList";
    }

     @RequestMapping(value = "/employee/insert",method=POST)
    public String registerNewEmployee(ModelMap map,
                                      EmployeeInfo employee,
                                      User user)
    {
        userService.save(user);
        int userId = user.getId();
        int departId = user.getDepartId();
        employee.setUserId(userId);
        employee.setDepartId(departId);
        employeeService.save(employee);
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setWho(userId);
        employeeLogService.save(employeeLog);
        return "TotalList";
    }


}
