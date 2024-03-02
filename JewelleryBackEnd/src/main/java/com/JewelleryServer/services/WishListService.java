package com.JewelleryServer.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JewelleryServer.dao.ProductDao;
import com.JewelleryServer.dao.UserDao;
import com.JewelleryServer.dao.WishListDao;
import com.JewelleryServer.pojo.Product;
import com.JewelleryServer.pojo.User;
import com.JewelleryServer.pojo.WishList;
import com.JewelleryServer.pojo.WishListItem;

@Service
@Transactional
public class WishListService {

	@Autowired
	private WishListDao wishLDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	public WishList addProductToWishList(int pid, User u) {

		// check if user exists in the database
		u = userDao.findById(u.getUid()).orElse(null);
		if (u == null)
			return null;

		// if user exists then get it's cart
		WishList wl = wishLDao.findByUser(u);

		// if cart does not exist then create a new cart and save in the database
		if (wl == null) {
			wl = new WishList();
			wl.setUser(u);
			wl.setItems(new HashSet<>());
		}
		Set<WishListItem> items = wl.getItems();

		// cart items are lazy fetch so call any method
		items.toString();

		Product p = productDao.findById(pid).orElse(null);
		if (p == null)
			return null;

		WishListItem newItem = new WishListItem();
		newItem.setProduct(p);
		items.add(newItem);
		wishLDao.save(wl);

		return wl;
	}

	public WishList getWishList(User u) {
		// check if user exists in the database
		u = userDao.findById(u.getUid()).orElse(null);
		if (u == null)
			return null;

		// if user exists then get it's cart
		WishList wl = wishLDao.findByUser(u);
		return wl;
	}

	public WishList deleteWishListItem(int wiid, User u) {
		// check if user exists in the database
				u = userDao.findById(u.getUid()).orElse(null);
				System.out.println(u);
				if (u == null)
					return null;
				
				// if user exists then get it's cart
				WishList wl = wishLDao.findByUser(u);
				System.out.println(wl);
				Set<WishListItem> items = wl.getItems();
				items.toString();
				System.out.println(items);
				for(WishListItem item : items) {
					if(item.getWiid()==wiid) {
						System.out.println(item);
						items.remove(item);
						return wishLDao.save(wl);
					}
				}
		return null;
	}

}
