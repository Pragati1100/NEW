package com.charan.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="Leaves")
public class Leave {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="leaveID")
	private String lid;
	@Column(name="description")
	private String levdesc;
	@Column(name="reqstDt")
	private String reqdt;
	@Column(name="startDt")
	private String stdte;
	@Column(name="endDt")
	private String endt;
	private String status;
	
	public Leave() {
		super();
	}
	
 @JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id1")
	private User use;


	public Leave(Integer id, String lid, String levdesc, String reqdt, String stdte, String endt, String status,
			User use) {
		super();
		this.id = id;
		this.lid = lid;
		this.levdesc = levdesc;
		this.reqdt = reqdt;
		this.stdte = stdte;
		this.endt = endt;
		this.status = status;
		this.use = use;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLevdesc() {
		return levdesc;
	}

	public void setLevdesc(String levdesc) {
		this.levdesc = levdesc;
	}

	public String getReqdt() {
		return reqdt;
	}

	public void setReqdt(String reqdt) {
		this.reqdt = reqdt;
	}

	public String getStdte() {
		return stdte;
	}

	public void setStdte(String stdte) {
		this.stdte = stdte;
	}

	public String getEndt() {
		return endt;
	}

	public void setEndt(String endt) {
		this.endt = endt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUse() {
		return use;
	}

	public void setUse(User use) {
		this.use = use;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", lid=" + lid + ", levdesc=" + levdesc + ", reqdt=" + reqdt + ", stdte=" + stdte
				+ ", endt=" + endt + ", status=" + status + ", use=" + use + ", getId()=" + getId() + ", getLid()="
				+ getLid() + ", getLevdesc()=" + getLevdesc() + ", getReqdt()=" + getReqdt() + ", getStdte()="
				+ getStdte() + ", getEndt()=" + getEndt() + ", getStatus()=" + getStatus() + ", getUse()=" + getUse()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
