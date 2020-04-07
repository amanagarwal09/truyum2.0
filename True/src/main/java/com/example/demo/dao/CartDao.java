package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MenuItem;

@Repository
public interface CartDao {
	int addCartItem(long userId, long menuItemId);

	List<MenuItem> getAllCartItems(long userId);

	int removeCartItem(long userId, long menuItemId);
}
