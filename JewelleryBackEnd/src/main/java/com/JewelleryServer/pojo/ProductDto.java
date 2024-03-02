package com.JewelleryServer.pojo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductDto {
	 private String pname;
		private double price;
		private int cid;
		public ProductDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProductDto(String pname, double price, int cid, int sid) {
			super();
			this.pname = pname;
			this.price = price;
			this.cid = cid;
			this.sid = sid;
		}
		@Override
		public String toString() {
			return "ProductDto [pname=" + pname + ", price=" + price + ", cid=" + cid + ", sid=" + sid + "]";
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
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		private int sid;
}
