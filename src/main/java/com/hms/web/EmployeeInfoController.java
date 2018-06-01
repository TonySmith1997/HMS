package com.hms.web;

import com.hms.entity.Department;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.entity.logs.EmployeeLog;
import com.hms.service.DepartmentService;
import com.hms.service.EmployeeLogService;
import com.hms.service.EmployeeService;
import com.hms.service.UserService;
import com.hms.type.EmployeeType;
import com.hms.type.LogType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/employee")
public class EmployeeInfoController {


    protected Logger log = LogManager.getLogger(EmployeeInfoController.class);

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

    @RequestMapping(value = "/info",method = GET)
    public String getEmployeeInfo(ModelMap map,int userId) {
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        map.addAttribute("employeeInfo",employeeInfo);
//        List<Log> employeeLogs  = employeeLogService.getEmployeeLog(userId);
        return "TotalList";
    }


    @RequestMapping(value = "update",method=POST)
    public String registerNewEmployee(
                                      @RequestParam("userid") String userid,
                                      @RequestParam("username") String username,
                                      @RequestParam("mobile") String mobile,
                                      @RequestParam("email") String email,
                                      @RequestParam("age") String age,
                                      @RequestParam("gender") String gender,
                                      @RequestParam("department") String department,
                                      @RequestParam("position") String position)
     {
         int userId = Integer.valueOf(userid.trim());
         User user = userService.get(userId);
         user.setUsername(username.trim());
         user.setMobile(mobile.trim());
         user.setEmail(email.trim());
         user.setAge(Integer.valueOf(age.trim()));
         boolean gender1 = Boolean.valueOf(gender);
         user.setGender(gender1);
         user.setUpdateBy(1);
         Date date = new Date();
         user.setUpdateTime(date);
         userService.update(user);
         /** --employee -- **/
         EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
         int oldDepartId = employeeInfo.getDepartId();
         String oldPosition = employeeInfo.getType();
        int newDepartId =Integer.valueOf(department);
         employeeInfo.setDepartId(newDepartId);
         employeeInfo.setType(position);
         employeeInfo.setUser(user);
         employeeInfo.setUpdateBy(1);
         employeeInfo.setUpdateTime(date);
         if(position.trim().equals(EmployeeType.chief.getName().trim())) {
             employeeInfo.setIfHead(true);
         }
         else {
             employeeInfo.setIfHead(false);
         }
         employeeService.update(employeeInfo);
         String type = "";
         /** --log -- **/
         if(newDepartId != oldDepartId){
             type = LogType.transfer;//调岗
         }
         else {
             type = LogType.modify;//修改信息
         }
         if(EmployeeType.getValue(oldPosition) > EmployeeType.getValue(position)) {
             type = LogType.demote;//降职
         }
         else if(EmployeeType.getValue(oldPosition) < EmployeeType.getValue(position)){
             type = LogType.promote;//升职
         }
        employeeLogService.saveEmployeeLog(userId,username,type,date);
         return "TotalList";
     }


    @RequestMapping(value = "/update/{id}",method = GET)
    public @ResponseBody EmployeeInfo getEmployeeForUpdate(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        User user = userService.get(userId);
        employeeInfo.setUser(user);
        Department department = departmentService.get(employeeInfo.getDepartId());
        return employeeInfo;
    }


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    EmployeeInfo getDepartment(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        User user = userService.get(userId);
        List<EmployeeLog> employeeLogs = employeeLogService.getEmployeeLog(userId);
        employeeInfo.setUser(user);
        employeeInfo.setEmployeeLogs(employeeLogs);
        return employeeInfo;
    }

    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String getEmployeeInsertPage(){
        return "EmployeeInsert";
    }
}
