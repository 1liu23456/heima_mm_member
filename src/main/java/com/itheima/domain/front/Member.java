package com.itheima.domain.front;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 刘旭阳
 * @Date: 2021/9/25 10:10
 * @Package: com.itheima.domain
 * @ClassName: Member
 * @Description: TODO
 * @Version: 2021/9/25
 */
public class Member implements Serializable {
    private String id;
    private String nickName;
    private String password;
    private Date birthday;
    private String gender;
    private String email;
    private String telephone;
    private String address;
    private Date registerDate;
    private String state;

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", registerDate=" + registerDate +
                ", state='" + state + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
