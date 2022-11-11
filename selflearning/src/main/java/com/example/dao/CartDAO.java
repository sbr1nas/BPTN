package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.mapper.CartMapper;
import com.example.dto.Cart;

@Repository
public class CartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Cart> cartByCustomer(Long customerID){
		int id = (int)customerID.intValue();
		String sql = "SELECT \"orderID\", \"bookID\", \"Title\", \"MSRP\" FROM \"cart\" WHERE \"cart\".\"customerID\" = " +id;
		
		//String sql = "SELECT \"orderID\", \"bookID\", \"Title\", \"MSRP\" FROM \"cart\" WHERE \"cart\".\"customerID\" = ?";
		//above to illustrate SQL error with data type that needs to be cast to int
		return jdbcTemplate.query(sql, new CartMapper());
	}
	
	public double totalCost (Long customerID) {
		int id = (int)customerID.intValue();
		String sql = "SELECT SUM (\"MSRP\")FROM \"cart\" WHERE \"cart\".\"customerID\" = "+ id; 
		
		return jdbcTemplate.queryForObject(sql, double.class);
	}
	
}

