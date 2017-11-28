package com.example.lxqq.denglu.bean;

/**
 * Created by lenovo on 2017/11/28.
 */

public class ZhuBean {
    private int phone;
    private String password;

    public ZhuBean(int phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ZhuBean{" +
                "phone=" + phone +
                ", password='" + password + '\'' +
                '}';
    }
}
