package com.example.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.bean.Payment;

public class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Payment payment = new Payment();
		
		payment.setPaymentID(rs.getInt("PaymentID"));
		payment.setPaymentType(rs.getString("PaymentType"));
		payment.setUserID(rs.getLong("UserID"));
		

		return payment;
	}

}
