package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDao;
import com.example.demo.model.MenuItem;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDao cartDao;
	
	@Override
	public int addCartItem(long userId, long menuItemId) {
		return cartDao.addCartItem(userId, menuItemId);
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		return cartDao.getAllCartItems(userId);
	}

	@Override
	public int removeCartItem(long userId, long menuItemId) {
		return cartDao.removeCartItem(userId, menuItemId);
	}

}
