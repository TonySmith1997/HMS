package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.dao.MessageDAO;
import com.hms.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
public class MessageService extends BaseService<Message,Integer> {
    @Autowired
    private MessageDAO dao;

    @Override
    public BaseDAOImpl<Message, Integer> getBaseDAO() {
        return dao;
    }

    @Transactional
    public List<Message> getFromMessage(int userid) {
        return dao.findAllEq("fromId",userid);
    }

    @Transactional
    public List<Message> getToMessage(int userid) {
        return dao.findAllEq("toId",userid);
    }


}
