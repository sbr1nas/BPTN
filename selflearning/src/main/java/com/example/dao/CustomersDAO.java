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

import com.example.bean.Customers;
import com.example.dao.mapper.CustomersMapper;


@Repository
public class CustomersDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	
	public List<Customers> listCustomers(){
		
		String sql = "SELECT * FROM \"Customers\"";
		
		return jdbcTemplate.query(sql, new CustomersMapper());
	}
	
	public Customers getCustomerByID(Long id) {
		String sql = "SELECT * FROM \"Customers\" WHERE id = ?";
		
		List<Customers> customer = jdbcTemplate.query(sql, new CustomersMapper(), id);
		
		return customer.isEmpty()?null:customer.get(0);
	}
	
	public Customers addCustomer(Customers customer) 
	{
		String sql = "INSERT INTO \"Customers\"(name, email) VALUES(:name, :email)";
		
		KeyHolder key = new GeneratedKeyHolder(); // to get generated ID from database
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", customer.getName())
				.addValue("email", customer.getEmail());
		namedTemplate.update(sql, param, key, new String[]{"id"});
		customer.setId(((Long) key.getKeys().get("id")).longValue());
		
		return customer;
		
	}
}
