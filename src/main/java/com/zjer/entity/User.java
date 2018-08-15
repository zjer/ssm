package com.zjer.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author shijun
 * @date 2018/8/15 12:33
 * @param
 * @return
*/
public class User implements Serializable {
    private Integer id;
    private String name;
    private String pass;
    private Timestamp enrolldate;

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

    public Timestamp getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Timestamp enrolldate) {
        this.enrolldate = enrolldate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", enrolldate=" + enrolldate +
                '}';
    }
}