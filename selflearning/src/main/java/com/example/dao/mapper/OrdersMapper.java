package com.example.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.bean.Orders;

public class OrdersMapper implements RowMapper<Orders> {

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Orders order = new Orders();
		
		order.setOrderID(rs.getInt("orderID"));
		order.setBookID(rs.getInt("bookID"));
		order.setCustomerID(rs.getLong("customerID"));
		
		return order;
	}

}
