package com.hms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * dispatcher view
 */

@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String getIndex(){
        System.out.println("ok");
        return "index";
    }
}
