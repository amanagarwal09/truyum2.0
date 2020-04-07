package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MenuItem;

public interface CartService {
	int addCartItem(long userId, long menuItemId);

	List<MenuItem> getAllCartItems(long userId);

	int removeCartItem(long userId, long menuItemId);
}
