package com.example.edit.beans;

import javax.xml.crypto.Data;
import java.util.Date;

public class User {
    private int userid;
    private String username;
    private String password;
    private String name;
    private Date issueAt;
    private int expiration;
    private int roleId;
    private String secondName;
    private Date dateOfBirth;
    private String email;
    private int otp;
    private int otpExp;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(Date issueAt) {
        this.issueAt = issueAt;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getOtpExp() {
        return otpExp;
    }

    public void setOtpExp(int otpExp) {
        this.otpExp = otpExp;
    }

    public User(int userid, String username, String password, String name, Date issueAt, int expiration, int roleId, String secondName, Date dateOfBirth, String email, int otp, int otpExp) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.issueAt = issueAt;
        this.expiration = expiration;
        this.roleId = roleId;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.otp = otp;
        this.otpExp = otpExp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", issueAt=" + issueAt +
                ", expiration=" + expiration +
                ", roleId=" + roleId +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", otp=" + otp +
                ", otpExp=" + otpExp +
                '}';
    }
}
