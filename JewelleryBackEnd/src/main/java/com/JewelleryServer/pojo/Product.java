package com.JewelleryServer.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//{"pname":"necklace",
//"price":2000}
@Entity
@Table(name = "products")
public class Product {
//	pid int primary key auto_increment,
//	pname varchar(50),
//	price double
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

    private int pid;
    private String pname;
	private double price;
	
	public Product() {
		super();
	}

	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
	
}
