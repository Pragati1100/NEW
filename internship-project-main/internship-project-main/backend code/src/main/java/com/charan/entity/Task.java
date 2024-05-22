package com.charan.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="tskID")
	private String tsid;
	@Column(name="tskDesc")
	private String desc;
	@Column(name="stDate")
	private String stdate;
	@Column(name="endDate")
	private String endate;
	@Column(name="Status") 
	private String stts;
	
	public Task() {
		super();
	}
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id1")
	private User user;


	public Task(Integer id, String tsid, String desc, String stdate, String endate, String stts, User user) {
		super();
		this.id = id;
		this.tsid = tsid;
		this.desc = desc;
		this.stdate = stdate;
		this.endate = endate;
		this.stts = stts;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStdate() {
		return stdate;
	}

	public void setStdate(String stdate) {
		this.stdate = stdate;
	}

	public String getEndate() {
		return endate;
	}

	public void setEndate(String endate) {
		this.endate = endate;
	}

	public String getStts() {
		return stts;
	}

	public void setStts(String stts) {
		this.stts = stts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", tsid=" + tsid + ", desc=" + desc + ", stdate=" + stdate + ", endate=" + endate
				+ ", stts=" + stts + ", user=" + user + ", getId()=" + getId() + ", getTsid()=" + getTsid()
				+ ", getDesc()=" + getDesc() + ", getStdate()=" + getStdate() + ", getEndate()=" + getEndate()
				+ ", getStts()=" + getStts() + ", getUser()=" + getUser() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
				
}
