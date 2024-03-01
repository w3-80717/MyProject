package com.JewelleryServer.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.CartDao;
import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.dao.UserDao;
import com.JewelleryServer.pojo.Cart;
import com.JewelleryServer.pojo.CartItem;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.User;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartDao cartDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	public Cart addProductToCart(int pid, int qty, User u) {

		// check if user exists in the database
		u = userDao.findById(u.getUid()).orElse(null);
		if (u == null)
			return null;

		// if user exists then get it's cart
		Cart cart = cartDao.findByUser(u);

		// if cart does not exist then create a new cart and save in the database
		if (cart == null) {
			cart = new Cart();
			cart.setUser(u);
			cart.setItems(new HashSet<>());
		}
		Set<CartItem> items = cart.getItems();

		// cart items are lazy fetch so call any method
		items.toString();

		Product p = productDao.findById(pid).orElse(null);
		if (p == null)
			return null;

		CartItem newItem = new CartItem();
		newItem.setProduct(p);

		for (CartItem item : items) {
			if (item.equals(newItem)) {
				newItem = item;
			}
		}
		newItem.setQuantity(qty);
		if(!items.contains(newItem))
		items.add(newItem);
		cartDao.save(cart);

		return cart;
	}

	public Cart getCart(User u) {
		// check if user exists in the database
		u = userDao.findById(u.getUid()).orElse(null);
		if (u == null)
			return null;

		// if user exists then get it's cart
		Cart cart = cartDao.findByUser(u);
		return cart;
	}

	public Cart deleteItem(int ciid, User u) {
		// check if user exists in the database
				u = userDao.findById(u.getUid()).orElse(null);
				System.out.println(u);
				if (u == null)
					return null;
				
				// if user exists then get it's cart
				Cart cart = cartDao.findByUser(u);
				System.out.println(cart);
				Set<CartItem> items = cart.getItems();
				items.toString();
				System.out.println(items);
				for(CartItem item : items) {
					if(item.getCiid()==ciid) {
						System.out.println(item);
						items.remove(item);
						return cartDao.save(cart);
					}
				}
		return null;
	}

}
