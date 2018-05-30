package com.hms.web;

import com.hms.entity.Department;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.service.DepartmentService;
import com.hms.service.EmployeeService;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/employee/departmentList",method = RequestMethod.GET)
    public String getDepartmentList(ModelMap map){
        List<Department> departmentList = departmentService.getAll();
        map.addAttribute("departmentList",departmentList);
        return "TotalList";
    }

//    @RequestMapping(value = "/employee/department{id}",method = RequestMethod.GET)
//    public String getDepartment(ModelMap map, @PathVariable String id) {
//        Integer departId = Integer.valueOf(id);
//        Department department = departmentService.getDepartmentUnique(departId);
//        map.addAttribute("department",department);
//        map.addAttribute("ifDepartment",true);
//        List<EmployeeInfo> employeeInfos = employeeService.getEmployeeInfoByDepartment(departId);
//        map.addAttribute("employeeByDepartment",employeeInfos);
//        return "TotalList";
//    }

    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public @ResponseBody Department getDepartment(ModelMap map, @PathVariable String id) {
        Integer departId = Integer.valueOf(id);
        Department department = departmentService.get(departId);
        List<EmployeeInfo> employeeInfos = employeeService.getEmployeeInfoByDepartment(departId);
        for (EmployeeInfo employeeInfo: employeeInfos) {
            int userId = employeeInfo.getUserId();
            User user = userService.get(userId);
            employeeInfo.setUser(user);
        }
        department.setEmployees(employeeInfos);
        return department;
    }
}
