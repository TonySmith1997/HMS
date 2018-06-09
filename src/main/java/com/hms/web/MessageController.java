package com.hms.web;

import com.hms.core.util.WebUtil;
import com.hms.entity.Message;
import com.hms.entity.User;
import com.hms.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RequestMapping(value = "/message")
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value="", method = POST)
    public void sendMessage(ModelMap model,
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
}
