package com.hms.web;

import com.hms.core.util.WebUtil;
import com.hms.entity.*;
import com.hms.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private InHospitalInfoService inHospitalInfoService;
    @Autowired
    private WardService wardService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private MessageService messageService;



    @RequestMapping(value="/login", method = GET)
    public String initForm(ModelMap model){
        System.out.println("########## init login page.");
        Login login = new Login();
        //绑定账户对象，也就是这个登录表单对象
        model.addAttribute("login", login);
        //指向登录页面
        return "login";
    }


    @RequestMapping(value="/loginCheck",method = RequestMethod.POST)
    public String login(@ModelAttribute("user") Login login, ModelMap model) {
        String loginName = login.getLoginName();
        User user = userService.getUser(loginName);
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(login.getLoginName(), login.getPassword(), false);
            token.setRememberMe(false);
            subject.login(token);
        } catch (UnknownAccountException e) {
            model.addAttribute("message","Not Found User");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message","Password Incorrect");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("message","500");
            return "500";
        }
        model.addAttribute("message","Welcome");
        User user1 = (User) WebUtil.getCurrentUser();
        System.out.println(user1.getUsername()+user1.getAvator());
        List<UserRole> userRoles = userRoleService.findResourcesByRole(user1.getId());
        Set<String> roleName = new HashSet<>();
        for(UserRole userRole : userRoles) {
                Role role = roleService.get(userRole.getRoleId());
                roleName.add(role.getRolename());
        }
        user1.setRole(roleName);
        model.addAttribute("userInfo",user1);
        List<Message> messagesInfo = messageService.getToMessage(user.getId());
        List<Message> messages1 = new ArrayList<>();
        for(Message message : messagesInfo) {
            message.setFrom(userService.get(message.getFromId()));
            messages1.add(message);
        }
        model.addAttribute("mails", messages1);
        model.addAttribute("messageCount",messages1.size());
        return "index";

    }


    @RequestMapping(value = "/profile",method = GET)
    public String getProfile(ModelMap map){
        User user = (User) WebUtil.getCurrentUser();

        /** 病人 **/
        if(!user.isIfEmloyee()) {
            PatientInfo patientInfo = patientService.getPatientInfo(user.getId());
            if(patientInfo.isInpatient() == true) {
                int inHospitalId = patientInfo.getInHospitalId();
                InHospitalInfo inHospitalInfo = inHospitalInfoService.get(inHospitalId);
                patientInfo.setInHospitalInfo(inHospitalInfo);
                Ward ward = wardService.get(inHospitalInfo.getWardNum());
                patientInfo.setWard(ward);
            }
            map.addAttribute("patient",patientInfo);
        }

        /** 员工 **/
        else{
            EmployeeInfo employeeInfo = employeeService.getEmployeeInfo(user.getId());
            map.addAttribute("employee",employeeInfo);
            Department department = departmentService.get(employeeInfo.getDepartId());
            String departName = department.getDepartName();
            map.addAttribute("depart",departName);
        }
        List<Message> messages = messageService.getToMessage(user.getId());
        List<Message> messages1 = new ArrayList<>();
        for(Message message : messages) {
            String photos = message.getPhoto();
            if (photos != null) {
                List<String> photoInfo = new ArrayList<>();
                String[] aa = photos.split(";");
                for (int i = 0; i < aa.length; i++) {
                    photoInfo.add(aa[i]);
                }
                message.setPhotos(photoInfo);
            }
            message.setFrom(userService.get(message.getFromId()));
            messages1.add(message);
        }
        map.addAttribute("messages", messages1);
        map.addAttribute("user",user);
        return "profile";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/changePass",method = RequestMethod.POST)
    public void changePass(@RequestParam("password") String password) {
        User user = (User) WebUtil.getCurrentUser();
        user.setPassword(password);
        userService.update(user);
    }
}
