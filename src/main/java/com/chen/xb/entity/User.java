package com.chen.xb.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class User implements Serializable {

    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private String qqOpenid;
    private String wxOpenid;
    private String realName;
    private Long age;
    private String phone;
    private String gender;
    private String info;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginTime;
    private String pic;
    private Long look;
    private String isSecret;
    private String deptName;
    private Long deptId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getLook() {
        return look;
    }

    public void setLook(Long look) {
        this.look = look;
    }

    public String getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(String isSecret) {
        this.isSecret = isSecret;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(qqOpenid, user.qqOpenid) &&
                Objects.equals(wxOpenid, user.wxOpenid) &&
                Objects.equals(realName, user.realName) &&
                Objects.equals(age, user.age) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(info, user.info) &&
                Objects.equals(registerTime, user.registerTime) &&
                Objects.equals(loginTime, user.loginTime) &&
                Objects.equals(pic, user.pic) &&
                Objects.equals(look, user.look) &&
                Objects.equals(isSecret, user.isSecret) &&
                Objects.equals(deptName, user.deptName) &&
                Objects.equals(deptId, user.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, qqOpenid, wxOpenid, realName, age, phone, gender, info, registerTime, loginTime, pic, look, isSecret, deptName, deptId);
    }
}