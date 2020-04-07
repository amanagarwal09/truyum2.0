package com.example.demo.service;

import java.util.List;

import com.example.demo.model.MenuItem;

public interface MenuItemService {
	List<MenuItem> getMenuItemListAdmin();

	List<MenuItem> getMenuItemListCustomer();

	int modifyMenuItem(MenuItem menuItem);

	int insertMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuItemId);
}
