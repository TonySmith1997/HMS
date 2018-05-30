package com.hms.web;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DrugController {

    @RequestMapping(value = "/drugs",method = RequestMethod.GET)
    public String getDrugList() {
        return "drugList";
    }

//    @RequestMapping(value = "/drugs",method = RequestMethod.GET)
//    public String getDrugs() {
//        return "";
//    }

}
