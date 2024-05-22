package com.charan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="adminID")
	private Integer adid;
	@Column(name="adminName")
	private String adname;
	@Column(name="userName")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="mobileNo")
	private String mobno;
	@Column(name="address")
	private String addr;
	
	public Admin() {
		super();
	}

	public Admin(Integer id, Integer adid, String adname, String username, String password, String mobno, String addr) {
		super();
		this.id = id;
		this.adid = adid;
		this.adname = adname;
		this.username = username;
		this.password = password;
		this.mobno = mobno;
		this.addr = addr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdid() {
		return adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
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

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adid=" + adid + ", adname=" + adname + ", username=" + username + ", password="
				+ password + ", mobno=" + mobno + ", addr=" + addr + ", getId()=" + getId() + ", getAdid()=" + getAdid()
				+ ", getAdname()=" + getAdname() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getMobno()=" + getMobno() + ", getAddr()=" + getAddr() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
		
}
