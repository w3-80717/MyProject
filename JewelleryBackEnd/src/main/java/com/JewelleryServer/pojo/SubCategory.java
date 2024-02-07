package com.JewelleryServer.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubCategory {
	@Column(name="sid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

	private String sname;

	public SubCategory() {
		super();
	}

	public SubCategory(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
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

	@Override
	public String toString() {
		return "SubCategory [sid=" + sid + ", sname=" + sname + "]";
	}


}