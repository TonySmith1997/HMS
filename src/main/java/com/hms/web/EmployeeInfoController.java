package com.hms.web;

import com.hms.core.util.AvatorCopy;
import com.hms.core.util.WebUtil;
import com.hms.entity.Department;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.User;
import com.hms.entity.UserRole;
import com.hms.entity.logs.EmployeeLog;
import com.hms.service.*;
import com.hms.type.EmployeeType;
import com.hms.type.LogType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private UserRoleService userRoleService;


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
    public String getTotalList(ModelMap map){
        List<User> employees = userService.getEmployeeList();
        List<Department> departmentList = departmentService.getAll();
        int count = employeeService.count();
        int departcount = departmentService.count();
        Date LastUpdate = employeeService.getLastUpdate();
        map.addAttribute("lastUpdate",LastUpdate);
        map.addAttribute("empCount",count);
        map.addAttribute("departCount",departcount);
        map.addAttribute("departmentList",departmentList);
        map.addAttribute("employees",employees);
        /** first employee **/
        User employee = employees.get(0);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(employee.getId());
        employeeInfo.setUser(employee);
        List<EmployeeLog> employeeLogs = employeeLogService.getEmployeeLog(employee.getId());
        employeeInfo.setEmployeeLogs(employeeLogs);
        map.addAttribute("emp",employeeInfo);
        return "TotalList";
    }



    /**
     * 表单提交更新员工
     * @param userid
     * @param username
     * @param mobile
     * @param email
     * @param age
     * @param gender
     * @param department
     * @param position
     * @return
     */
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
         user.setTrueName(username.trim());
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
         /**
          * 权限管理 todo
          */
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


    /**
     * 显示表单更新时的弹出框
     * @param id
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = GET)
    public @ResponseBody EmployeeInfo getEmployeeForUpdate(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        User user = userService.get(userId);
        employeeInfo.setUser(user);
        Department department = departmentService.get(employeeInfo.getDepartId());
        return employeeInfo;
    }

    /**
     * 获得用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public @ResponseBody
    EmployeeInfo getEmployeeDetail(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(userId);
        User user = userService.get(userId);
        List<EmployeeLog> employeeLogs = employeeLogService.getEmployeeLog(userId);
        employeeInfo.setUser(user);
        employeeInfo.setEmployeeLogs(employeeLogs);
        return employeeInfo;
    }

    @RequestMapping(value = "/search/{searchName}",method = RequestMethod.GET)
    public @ResponseBody
    List<User> getEmployeeLike(@PathVariable String searchName) {
        List<User> users = userService.getEmployeeLike(searchName.trim()+"%");
        return users;
    }

    /**
     * 用户头像更新
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public void updateAvator(@RequestParam("id") String id,@RequestParam("imgData") String dataURL) throws IOException {
        Integer userId = Integer.valueOf(id);
        User user = userService.get(userId);
        String path = "/Users/tony/Documents/HMS/src/main/webapp/static/img/avator/";
        String imgName = user.getTrueName() +"_"+userId+".png";
        AvatorCopy.decodeBase64DataURLToImage(dataURL,path,imgName);
        user.setUpdateTime(new Date());
        user.setUpdateBy(1);
        user.setAvator("/static/img/avator/"+imgName);
        userService.update(user);
    }

    /**
     * Employee Log
     * @return
     */
    @RequestMapping(value = "logs",method = RequestMethod.GET)
    public String getEmployeeLog(ModelMap map) {
        List<EmployeeLog> employeeLogs = employeeLogService.getAll();
        for(EmployeeLog employeeLog :employeeLogs){
            int who = employeeLog.getWho();
            User user = userService.get(who);
            employeeLog.setUser(user);
        }
        map.addAttribute("employeeLogs",employeeLogs);
        return "employeeLog";
    }


    /**
     * 跳转用户注册页面
     * @return
     */
    @Transactional
    @RequestMapping(value = "insert",method = RequestMethod.GET)
    public String getEmployeeInsertPage(){
        return "EmployeeInsert";
    }

    @RequestMapping(value = "insert",method = POST)
    public String insertNewEmployee(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("trueName") String trueName,
                                  @RequestParam("email") String email,
                                  @RequestParam("mobile") String mobile,
                                  @RequestParam("age") String age,
                                  @RequestParam("gender") String gender,
                                  @RequestParam("department") String department,
                                  @RequestParam("position") String position) throws InterruptedException {
        Date date = new Date();
        /** User **/
        User user = new User();
        user.setUsername(username.trim());
        user.setAvator("/static/img/a5.jpg");//default
        user.setPassword(password.trim());
        user.setTrueName(trueName.trim());
        user.setEmail(email.trim());
        user.setMobile(mobile.trim());
        user.setAge(Integer.valueOf(age.trim()));
        user.setGender(Boolean.valueOf(gender));
        user.setCreateBy(1);
        user.setCreateTime(date);
        user.setIfEmloyee(true);
        userService.save(user);
        int id = user.getId();
        Thread.sleep(500);
        /** employee **/
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setUserId(id);
        employeeInfo.setDepartId(Integer.valueOf(department));
        employeeInfo.setType(position);
        employeeInfo.setCreateBy(1);
        employeeInfo.setCreateTime(date);
        if(EmployeeType.getValue(position) == 1) {
            employeeInfo.setIfHead(true);
        }
        employeeService.save(employeeInfo);
        /**
         *  role
         */
        UserRole role = new UserRole();
        role.setRoleId(4);//新注册的人都是新人
        role.setUserId(user.getId());
        userRoleService.save(role);
        /**employee Log **/
        EmployeeLog employeeLog = new EmployeeLog();
        employeeLogService.saveEmployeeLog(id,username,LogType.join,date);
        return "EmployeeInsert";
    }

    /**
     * 签到
     */
    @RequestMapping(value = "/signin",method = POST)
    public @ResponseBody void signIn() {
        User user = (User) WebUtil.getCurrentUser();
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(user.getId());
        employeeInfo.setStatus(1);
        employeeInfo.setUpdateTime(new Date());
        employeeService.update(employeeInfo);
    }

    /**
     * 签退
     */
    @RequestMapping(value = "/signout",method = POST)
    public @ResponseBody void signOut() {
        User user = (User) WebUtil.getCurrentUser();
        EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(user.getId());
        employeeInfo.setStatus(0);
        employeeInfo.setUpdateTime(new Date());
        employeeService.update(employeeInfo);
    }

}
