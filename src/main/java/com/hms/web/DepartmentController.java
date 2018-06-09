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


@RequestMapping("/department")
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
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

    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
    public @ResponseBody
    List<Department> getEmployeeLike(@PathVariable String searchName) {
        List<Department> departments = departmentService.findDepartmentLike(searchName.trim()+"%");
        return departments;
    }

}
