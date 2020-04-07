package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CartDao;
import com.example.demo.model.MenuItem;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int addCartItem(long userId, long menuItemId) {
		AdminRowMapper adminRowMapper = new AdminRowMapper();
		String sql1 = "SELECT * FROM MenuItem WHERE id in (select itemid from user where userid= ?)";
		List<MenuItem> l = jdbcTemplate.query(sql1, adminRowMapper, userId);
		for(MenuItem i: l)
		{
			if(i.getId()==menuItemId)
			{
				return 0;
			}
		}
		String sql = "insert into user values(?, ?)";
		return jdbcTemplate.update(sql, userId, menuItemId);
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) {
		AdminRowMapper adminRowMapper = new AdminRowMapper();
		String sql = "SELECT * FROM MenuItem WHERE id in (select itemid from user where userid= ?)";
		return jdbcTemplate.query(sql, adminRowMapper, userId);
		
	}

	@Override
	public int removeCartItem(long userId, long menuItemId) {
		String sql = "DELETE FROM user WHERE userid = ? AND itemid = ?";
		return jdbcTemplate.update(sql, userId, menuItemId);
	}

}
