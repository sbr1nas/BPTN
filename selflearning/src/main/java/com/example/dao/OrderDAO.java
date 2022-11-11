package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.bean.Orders;
import com.example.dao.mapper.OrdersMapper;

@Repository
public class OrderDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	public Orders findOrderByOrderID(Long orderID) {
		int id = orderID.intValue();
		String sql = "SELECT * FROM \"Orders\" WHERE \"orderID\" = "+ id;
		
		List<Orders> orders = jdbcTemplate.query(sql, new OrdersMapper(), orderID);
		
		return orders.isEmpty()?null:orders.get(0);
		
	}
	
	public List<Orders> findOrdersByCustomerID(Long customerID){
		int id = customerID.intValue();
		String sql = "SELECT * FROM \"Orders\" WHERE \"customerID\" = " + id;
		
		return jdbcTemplate.query(sql, new OrdersMapper());
	}
	
	public void addOrder(Orders order) {
		String sql = "INSERT INTO \"Orders\"(\"bookID\", \"customerID\") VALUES(:bookID, :customerID)";
		
		KeyHolder key = new GeneratedKeyHolder(); // to get generated ID from database
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("bookID", order.getBookID())
				.addValue("customerID", order.getCustomerID());
		namedTemplate.update(sql, param, key, new String[] {"orderID"});
		order.setOrderID(key.getKeyAs(Integer.class));
		
		String view = "REFRESH MATERIALIZED VIEW \"cart\"";
		jdbcTemplate.update(view);
	}

}
