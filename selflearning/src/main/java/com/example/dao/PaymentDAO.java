package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bean.Payment;
import com.example.dao.mapper.PaymentMapper;

@Repository
public class PaymentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Payment> findPaymentMethodsByUserID (Long userID) {
		int id = userID.intValue();
		String sql = "SELECT * FROM public.\"Payment\" WHERE \"Payment\".\"UserID\" = " + id;
		
		return jdbcTemplate.query(sql, new PaymentMapper());
	}
	
	public Payment addPayment (Payment pay) {
		String sql = "INSERT INTO \"Payment\"(\"PaymentID\", \"PaymentType\", \"UserID\") " + "VALUES(?,?,?)";
		
		jdbcTemplate.update(sql, new Object[] {pay.getPaymentID(), pay.getPaymentType(), pay.getUserID()});
		
		return pay;
	}

}
