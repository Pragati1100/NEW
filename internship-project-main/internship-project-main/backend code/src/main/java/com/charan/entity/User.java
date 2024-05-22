package com.charan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class User {
	private static final String user = null;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="userID")
	private String uid;
	@Column(name="name")
	private String usname;
	@Column(name="UserName")
	private String usrname;
	@Column(name="Password")
	private String pswrd;
	@Column(name="userMob")
	private String mobno;
	@Column(name="userAddress")
	private String addrs;
	
	public User() {
		super();}

	@JsonManagedReference
	@OneToMany(mappedBy="use",cascade=CascadeType.ALL)
	//@JoinColumn
	public List<Leave> leave;

	@JsonManagedReference
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	//@JoinColumn
	public List<Task> tasks;


	public User(Integer id, String uid, String usname, String usrname, String pswrd, String mobno, String addrs,
			List<Leave> leave, List<Task> tasks) {
		super();
		this.id = id;
		this.uid = uid;
		this.usname = usname;
		this.usrname = usrname;
		this.pswrd = pswrd;
		this.mobno = mobno;
		this.addrs = addrs;
		this.leave = leave;
		this.tasks = tasks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Leave> getLeave() {
		return leave;
	}

	public void setLeave(List<Leave> leave) {
		this.leave = leave;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public static String getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uid=" + uid + ", usname=" + usname + ", usrname=" + usrname + ", pswrd=" + pswrd
				+ ", mobno=" + mobno + ", addrs=" + addrs + ", leave=" + leave + ", tasks=" + tasks + ", getId()="
				+ getId() + ", getUid()=" + getUid() + ", getUsname()=" + getUsname() + ", getUsrname()=" + getUsrname()
				+ ", getPswrd()=" + getPswrd() + ", getMobno()=" + getMobno() + ", getAddrs()=" + getAddrs()
				+ ", getLeave()=" + getLeave() + ", getTasks()=" + getTasks() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
