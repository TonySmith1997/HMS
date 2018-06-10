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

    @RequestMapping(value="/sys",method= RequestMethod.GET)
    public String getIndex(){
        System.out.println("ok");
        return "index";
    }
    @RequestMapping(value="/403",method= RequestMethod.GET)
    public String get403(){
        return "403";
    }

    @RequestMapping(value ="/home",method = RequestMethod.GET)
    public String getHomepage() {
        return "homepage";
    }
}
