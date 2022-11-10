package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Payment;
import com.example.dao.PaymentDAO;

@Service
public class PaymentService {

	@Autowired
	PaymentDAO paymentDAO; 
	
	public List<Payment> getPaymentMethodsForCustomer (Long customerID){
		List<Payment> methods = paymentDAO.findPaymentMethodsByUserID(customerID);
		return methods;
	}
	
	public Payment addPaymentMethod(Payment pay) throws Exception {
		if(!validatePaymentRequest(pay)) 
		{
			throw new Exception("REQUEST INVALID");
		}
		else 
		{
			paymentDAO.addPayment(pay);
			return pay;
		}
	}
	
	private boolean validatePaymentRequest(Payment pay) 
	{
		if(pay.getPaymentID()!= 0 && pay.getPaymentType()!= null 
				&& !pay.getPaymentType().isEmpty() && pay.getUserID() != 0) 
		{
			return true;
		}	
		else return false; 
	}
}
