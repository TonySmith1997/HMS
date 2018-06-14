package com.hms.web;

import com.hms.core.util.WebUtil;
import com.hms.entity.Department;
import com.hms.entity.EmployeeInfo;
import com.hms.entity.Message;
import com.hms.entity.User;
import com.hms.service.DepartmentService;
import com.hms.service.EmployeeService;
import com.hms.service.MessageService;
import com.hms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequestMapping(value = "/message")
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @RequestMapping(value="", method = POST)
    public void sendMessage(
                              @RequestParam("toId") String id,
                              @RequestParam("message") String messageInfo){
        Message message = new Message();
        message.setCreateTime(new Date());
        User user = (User) WebUtil.getCurrentUser();
        message.setFromId(user.getId());
        message.setToId(Integer.valueOf(id.trim()));
        message.setMessage(messageInfo);
        messageService.save(message);
    }

    @Transactional
    @RequestMapping(value = "check",method = POST)
    public void sendCheck(@RequestParam("userId") String userId,
                          @RequestParam("check") String check,
                          @RequestParam("extraMessage") String extraMessage) {
        int departId = 0;
        switch(check){
            case "CT":
            case "X-ray":
                departId = 13;
                break;
            case "URAN":
            case "Blood test":
                departId = 15;
                break;
        }
        Department department = departmentService.get(departId);
        List<EmployeeInfo> employeeInfos = employeeService.getEmployeeInfoByDepartment(departId);
        User patient = userService.get(Integer.valueOf(userId));
        Date date = new Date();
        User session = (User) WebUtil.getCurrentUser();
        /**通知同事准备为病人做检查 **/
        for(EmployeeInfo employeeInfo : employeeInfos) {
            Message message = new Message();
            message.setMessage("make a "+check+" for "+patient.getTrueName()+",ps. "+extraMessage);
            message.setCreateTime(date);
            message.setFromId(session.getId());
            message.setToId(employeeInfo.getUserId());
            messageService.save(message);
        }
        /**通知病人去做检查**/
        Message message = new Message();
        message.setToId(patient.getId());
        message.setFromId(session.getId());
        message.setCreateTime(date);
        message.setMessage("please go to "+department.getDepartName()+" for "+ check);
        messageService.save(message);
    }

}
