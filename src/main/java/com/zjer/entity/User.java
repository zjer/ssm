package com.zjer.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author shijun
 * @date 2018/8/1 23:18
 * @param
 * @return
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String pass;
    private String nick;
    private String sex;
    private String place;
    private String birth;
    private Timestamp enrolldate;
    private Timestamp lastdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Timestamp getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Timestamp enrolldate) {
        this.enrolldate = enrolldate;
    }

    public Timestamp getLastdate() {
        return lastdate;
    }

    public void setLastdate(Timestamp lastdate) {
        this.lastdate = lastdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", nick='" + nick + '\'' +
                ", sex='" + sex + '\'' +
                ", place='" + place + '\'' +
                ", birth='" + birth + '\'' +
                ", enrolldate=" + enrolldate +
                ", lastdate=" + lastdate +
                '}';
    }
}
