package com.JewelleryServer.pojo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//{"pname":"necklace",
//"price":2000}
//{  "pid":2,
//	  "pname":"necklace",
//	"price":2000}
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
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "sid")
	private SubCategory subCategory;
	
	private String image;
	
	public Product(int pid, String pname, double price, Category category, SubCategory subCategory, String image) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Product() {
		super();
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
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category=" + category
				+ ", subCategory=" + subCategory + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(pid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return pid == other.pid;
	}
	
	
	
}
