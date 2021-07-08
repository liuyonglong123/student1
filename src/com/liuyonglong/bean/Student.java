package com.liuyonglong.bean;

import java.util.Date;

public class Student {
    private Integer sid;
    private String sname;
    private String gender;
    private Date sbir;
    private String hobby;
    private String photo;

    public Student() {
    }

    public Student(Integer sid ,String sname, String gender, Date sbir, String hobby, String photo) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.sbir = sbir;
        this.hobby = hobby;
        this.photo = photo;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getSbir() {
        return sbir;
    }

    public void setSbir(Date sbir) {
        this.sbir = sbir;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
