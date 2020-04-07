package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MenuItemDao;
import com.example.demo.model.MenuItem;

@Repository
public class MenuItemDaoImpl implements MenuItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertMenuItem(MenuItem menuItem) {
		String sql = "insert into menuitem values(?,?,?,?,?,?,?)";
		int insert = jdbcTemplate.update(sql, menuItem.getId(), menuItem.getName(), menuItem.getPrice(),
				menuItem.isActive(), menuItem.getDateOfLaunch(), menuItem.getCategory(), menuItem.isFreeDelivery());
		return insert;
	}

	@Override
	public int modifyMenuItem(MenuItem menuItem) {
		System.out.println(menuItem);
		String sql = "UPDATE menuitem SET id = ?, name = ?, price = ?, active = ?, dateOfLaunch = ?, category=?, freeDilevry = ? where id = ?";
		int update = jdbcTemplate.update(sql, menuItem.getId(), menuItem.getName(), menuItem.getPrice(), menuItem.isActive(),
				menuItem.getDateOfLaunch(), menuItem.getCategory(), menuItem.isFreeDelivery(), menuItem.getId());
		return update;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		AdminRowMapper adminRowMapper = new AdminRowMapper();
		String sql = "SELECT * FROM menuitem";
		List<MenuItem> query = jdbcTemplate.query(sql, adminRowMapper);
		return query;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		AdminRowMapper adminRowMapper = new AdminRowMapper();
		String sql = "SELECT * FROM menuitem WHERE active = true and dateoflaunch < curdate()";
		List<MenuItem> query = jdbcTemplate.query(sql, adminRowMapper);
		return query;
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		return null;
	}

}
