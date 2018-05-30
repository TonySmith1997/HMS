package com.hms.service;

import com.hms.core.base.BaseDAOImpl;
import com.hms.core.base.BaseService;
import com.hms.core.security.Digests;
import com.hms.core.util.ValidatorUtil;
import com.hms.dao.UserDAO;
import com.hms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<User,Integer> {

    public static final String HASH_ALGORITHM = "MD5";

    @Autowired
    private UserDAO userDAO;

    public BaseDAOImpl<User, Integer> getBaseDAO() {
        return userDAO;
    }

    /**
     * register
     * @param user
     */
    @Transactional(readOnly = false)
    public void save(User user){
        entryptPassword(user);
        user.setCreateTime((Timestamp) new Date());
        userDAO.save(user);
    }

    /**
     * 修改密码
     * @param user
     */
    @Transactional(readOnly = false)
    public void updatePwd(User user){
        entryptPassword(user);
        userDAO.update(user);
    }


    /**
     * 通过登陆名(username,mobile,email)获取用户
     * @param loginName
     * @return
     */
    public User getUser(String loginName){
        System.out.println(loginName);
        String login = getTypeofLogin(loginName);
        return userDAO.findUniqueBy(login,loginName);
    }


    public String getTypeofLogin(String loginName){
        String regex1 = "1[3579][0-9]{9}";
        String regex2 = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean flag1 = ValidatorUtil.pattern(loginName,regex1);
        boolean flag2 = ValidatorUtil.pattern(loginName,regex2);
        if(flag1){
            return "mobile";
        }
        else if(flag2) {
            return "email";
        }
        return "username";
    }

    /**
     * 检验密码
     * @param user
     * @param password
     * @return
     */
    public boolean checkPassword(User user,String password){
        byte[] hashPassword = Digests.MD5(password.trim().getBytes());
        byte[] truePassword = user.getPassword().getBytes();
        if(hashPassword.equals(truePassword)){
            return true;
        }
        return false;
    }


    private void entryptPassword(User user){
        byte[] hashPassword = Digests.MD5(user.getPassword().getBytes());
        user.setPassword(hashPassword.toString());
    }

    /**
     * 得到除patient以外的user信息表
     * @return
     */
    public List<User> getEmployeeList(){
        String propertyName = "ifEmloyee";
        return userDAO.findAllEq(propertyName,true);
    }


}
