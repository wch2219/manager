package com.zzwch.manager.entry.ResultEntry;


import java.lang.String;

public class TUser {

  private long userId;
  private String userRealname;
  private String userNickname;
  private String userPhone;
  private long userRank;
  private String userEmail;
//  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone="GMT+8")//将String转换成String 一般后台传值给前台时
  private String userCreateTime;
//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
  private String userUptime;
  private String token;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserRealname() {
    return userRealname;
  }

  public void setUserRealname(String userRealname) {
    this.userRealname = userRealname;
  }


  public String getUserNickname() {
    return userNickname;
  }

  public void setUserNickname(String userNickname) {
    this.userNickname = userNickname;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public long getUserRank() {
    return userRank;
  }

  public void setUserRank(long userRank) {
    this.userRank = userRank;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserCreateTime() {
    return userCreateTime;
  }

  public void setUserCreateTime(String userCreateTime) {
    this.userCreateTime = userCreateTime;
  }


  public String getUserUptime() {
    return userUptime;
  }

  public void setUserUptime(String userUptime) {
    this.userUptime = userUptime;
  }




  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
