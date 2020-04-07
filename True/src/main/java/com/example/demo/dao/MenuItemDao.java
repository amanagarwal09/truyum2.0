package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MenuItem;

@Repository
public interface MenuItemDao {
	List<MenuItem> getMenuItemListAdmin();

	List<MenuItem> getMenuItemListCustomer();

	int modifyMenuItem(MenuItem menuItem);

	int insertMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuItemId);
}
