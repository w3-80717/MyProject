package com.JewelleryServer.pojo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ciid;
	
	@ManyToOne
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
		CartItem other = (CartItem) obj;
		return Objects.equals(product, other.product);
	}

	public CartItem() {
		super();
	}

	public CartItem(int ciid, Product product, int quantity) {
		super();
		this.ciid = ciid;
		this.product = product;
		this.quantity = quantity;
	}

	public int getCiid() {
		return ciid;
	}

	public void setCiid(int ciid) {
		this.ciid = ciid;
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
