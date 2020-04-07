package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.MenuItem;

public class AdminRowMapper implements RowMapper<MenuItem>{

	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem menuItem = new MenuItem();
		menuItem.setId(rs.getLong(1));
		menuItem.setName(rs.getString(2));
		menuItem.setPrice(rs.getFloat(3));
		menuItem.setActive(rs.getBoolean(4));
		menuItem.setDateOfLaunch(rs.getDate(5));
		menuItem.setCategory(rs.getString(6));
		menuItem.setFreeDelivery(rs.getBoolean(7));
		return menuItem;
	}

}
