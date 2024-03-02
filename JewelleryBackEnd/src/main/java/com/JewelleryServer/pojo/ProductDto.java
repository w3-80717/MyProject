package com.JewelleryServer.pojo;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
	 public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public ProductDto(String pname, double price, int cid, MultipartFile image, int sid) {
		super();
		this.pname = pname;
		this.price = price;
		this.cid = cid;
		this.image = image;
		this.sid = sid;
	}
	private String pname;
		private double price;
		private int cid;
		private MultipartFile image;
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
