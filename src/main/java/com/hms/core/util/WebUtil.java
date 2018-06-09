package com.hms.core.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebUtil {
    public WebUtil() {
    }

    public static final String getCookieValue(HttpServletRequest request,String cookieName,String defaultValue) {
        Cookie cookie = WebUtils.getCookie(request,cookieName);
        if(cookie == null) {
            return defaultValue;
        }
        return cookie.getValue();
    }

    public static final void saveCurrentUser(Object user) {
        setSeesion("user",user);
    }

    public static final void saveCurrentUser(HttpServletRequest request,Object user) {
        setSession(request,"user",user);
    }

    public static final Object getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser) {
            try{
                Session session = currentUser.getSession();
                if(null != session){
                    return session.getAttribute("user");
                }
            }catch (InvalidSessionException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static final Object getCurrentUser(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            if(null != session) {
                return session.getAttribute("user");
            }
        }catch (InvalidSessionException e){
            e.printStackTrace();
        }
        return null;
    }

    public static final void removeCurrentUser(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
    }

    public static final void setSeesion(Object key,Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser) {
            Session session = currentUser.getSession();
            if(null != session) {
                session.setAttribute(key,value);
            }
        }
    }

    public static final void setSession(HttpServletRequest request,String key,Object value) {
        HttpSession session = request.getSession();
        if(null != session) {
            session.setAttribute(key,value);
        }
    }
}
