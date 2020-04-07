package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MenuItemDao;
import com.example.demo.model.MenuItem;
import com.example.demo.service.MenuItemService;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	@Autowired
	MenuItemDao menuDao;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuDao.getMenuItemListAdmin();
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return menuDao.getMenuItemListCustomer();
	}

	@Override
	public int modifyMenuItem(MenuItem menuItem) {
		return menuDao.modifyMenuItem(menuItem);
	}

	@Override
	public int insertMenuItem(MenuItem menuItem) {
		return menuDao.insertMenuItem(menuItem);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		return menuDao.getMenuItem(menuItemId);
	}
}
