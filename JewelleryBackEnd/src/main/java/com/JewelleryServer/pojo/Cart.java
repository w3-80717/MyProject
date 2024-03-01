package com.JewelleryServer.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "cart")
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	@OneToOne
	@JoinColumn(name = "uid")
	@JsonIgnore
	private User user;

	@OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "cart_id")
	private Set<CartItem> items;

	public Cart() {
		super();
	}

	public Cart(int cid, User user, Set<CartItem> items) {
		super();
		this.cid = cid;
		this.user = user;
		this.items = items;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getItems() {
		return items;
	}

	public void setItems(Set<CartItem> items) {
		this.items = items;
	}

}
