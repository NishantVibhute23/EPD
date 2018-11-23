/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epd.redirect;

import com.epd.bean.LoginBean;
import com.epd.dao.LoginDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author nishant.vibhute
 */
public class Login extends ActionSupport implements ModelDriven, SessionAware {

    LoginBean loginBean = new LoginBean();
    LoginDao loginDao = new LoginDao();
    String message;
    private SessionMap<String, Object> sessionMap;

    public Login() {

    }

    @Override
    public String execute() throws Exception {

        return ActionSupport.SUCCESS;
    }

    public String checkLogin() {
        String username = loginBean.getUserName();
        String password = loginBean.getPassword();
        int count = loginDao.checkLogin(username, password);
        if (count != 0) {
            sessionMap.put("userId", count);
            return "success";
        } else {
            message = "failed";
            return "failed";
        }

    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getModel() {
        return loginBean;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}
