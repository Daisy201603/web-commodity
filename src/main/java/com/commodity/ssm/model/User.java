package com.commodity.ssm.model;

import org.springframework.stereotype.Component;

/**
 * @author GongDiXin
 * @version 1.0
 * @created 2017/3/20 20:48
 * @description
 */

@Component
public class User {

    private Integer id;
    private String userName;
    private String birthday;
    private String sex;
    private String address;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
