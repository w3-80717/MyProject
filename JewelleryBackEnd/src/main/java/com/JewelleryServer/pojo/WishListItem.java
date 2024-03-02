package com.JewelleryServer.pojo;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "wish_list_items")
public class WishListItem {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wiid;
	
	@ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "pid")
	private Product product;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishListItem other = (WishListItem) obj;
		return Objects.equals(product, other.product);
	}

	public WishListItem() {
		super();
	}

	public WishListItem(int wiid, Product product, int quantity) {
		super();
		this.wiid = wiid;
		this.product = product;
		this.quantity = quantity;
	}

	public int getWiid() {
		return wiid;
	}

	public void setWiid(int wiid) {
		this.wiid = wiid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private int quantity;
}
