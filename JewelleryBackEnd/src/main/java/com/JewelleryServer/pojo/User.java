package com.JewelleryServer.pojo;


//package com.JewelleryBackEnd.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="users")
public class User {
//	uid int primary key auto_increment,
//	uname varchar(20),
//	role varchar(10),
//	mobile varchar(15),
//	email varchar(50),
//	password varchar(100),
//	address varchar(200)
//	);
    @Id
    private int uid;
    private String uname;
    private String role;
    private String mobile;
    private String email;
    private String password;
    private String address;
    
	public User() {
		super();
	}

	public User(int uid, String uname, String role, String mobile, String email, String password, String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", role=" + role + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", address=" + address + "]";
	}
  
    
}
