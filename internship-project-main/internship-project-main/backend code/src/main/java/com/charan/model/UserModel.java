package com.charan.model;

import com.charan.entity.Leave;
import com.charan.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class UserModel {

    private Integer id;
    private String uid;

    private String usname;

    private String usrname;

    private String pswrd;

    private String mobno;

    private String addrs;
  @JsonIgnore
    public List<Leave> leave;
    @JsonIgnore
    public List<Task> tasks;

    public UserModel() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", usname='" + usname + '\'' +
                ", usrname='" + usrname + '\'' +
                ", pswrd='" + pswrd + '\'' +
                ", mobno='" + mobno + '\'' +
                ", addrs='" + addrs + '\'' +
                '}';
    }
}
