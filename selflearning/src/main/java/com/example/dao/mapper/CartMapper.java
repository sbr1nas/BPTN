package com.example.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.dto.Cart;

public class CartMapper implements RowMapper<Cart> {

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Cart cart = new Cart();
		
		cart.setOrderID(rs.getInt("orderID"));
		cart.setBookID(rs.getInt("bookID"));
		cart.setTitle(rs.getString("Title"));
		cart.setMSRP(rs.getDouble("MSRP"));
		
		return cart;
	}

}
