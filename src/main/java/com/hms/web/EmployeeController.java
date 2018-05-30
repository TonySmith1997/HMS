package com.hms.web;

import com.hms.entity.Department;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.entity.logs.EmployeeLog;
import com.hms.service.DepartmentService;
import com.hms.service.EmployeeLogService;
import com.hms.service.EmployeeService;
import com.hms.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    protected Logger log = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeLogService employeeLogService;
    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "",method = GET)
    public String getTotalList(ModelMap map){
        List<User> employees = userService.getEmployeeList();
        List<Department> departmentList = departmentService.getAll();
        map.addAttribute("departmentList",departmentList);
        map.addAttribute("employees",employees);
        return "TotalList";
    }

//    @RequestMapping(value = "/info",method = GET)
//    public String getEmployeeInfo(ModelMap map,int userId) {
//        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
//        map.addAttribute("employeeInfo",employeeInfo);
////        List<Log> employeeLogs  = employeeLogService.getEmployeeLog(userId);
//        return "TotalList";
//    }

     @RequestMapping(value = "/employee/insert",method=POST)
    public String registerNewEmployee(ModelMap map,
                                      EmployeeInfo employee,
                                      User user)
    {
        userService.save(user);
        int userId = user.getId();
        user.setIfEmloyee(false);
        try {
            userService.save(user);
        }catch (Exception e)
        {
            log.error("user insert failed",e);
            return "500";
        }
        employee.setUserId(userId);
        try {
            employeeService.save(employee);
        }catch (Exception e)
        {
            log.error("employee insert failed",e);
            return "500";
        }
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.setWho(userId);
        try {
            employeeLogService.save(employeeLog);
            return "TotalList";
        }catch (Exception e)
        {
            log.error("insert failed",e);
            return "500";
        }
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody EmployeeInfo getDepartment(ModelMap map, @PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        User user = userService.get(userId);
        List<EmployeeLog> employeeLogs = employeeLogService.getEmployeeLog(userId);
        employeeInfo.setUser(user);
        employeeInfo.setEmployeeLogs(employeeLogs);
        return employeeInfo;
    }
}
