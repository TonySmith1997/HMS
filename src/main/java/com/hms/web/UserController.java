package com.hms.web;

import com.hms.entity.Login;
import com.hms.entity.User;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
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
        System.out.println(user);
        if(user==null) {
            model.addAttribute("message","user is not exist");
            return "login";
        }
        else if(!userService.checkPassword(user,login.getPassword())){
            System.out.println("pass");
            model.addAttribute("message","username does not match the password");
            return "login";
        }
        else {
            model.addAttribute("message","Welcome");
            return "index";
        }
    }
}
