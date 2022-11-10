package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Orders;
import com.example.dao.OrderDAO;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	public Orders getOrderByOrderID(Long orderID) {
		Orders order = orderDAO.findOrderByOrderID(orderID);
		return order;
	}
	
	public List<Orders> getOrdersByCustomer(Long customerID){
		List<Orders> customerOrders = orderDAO.findOrdersByCustomerID(customerID);
		return customerOrders;
	}
	
	public void addOrder(Orders order) throws Exception {
		if(!validateOrderRequest(order)) 
		{
			throw new Exception("INVALID REQUEST");
		}
		else 
		{
			orderDAO.addOrder(order);
		}
	}
	
	private boolean validateOrderRequest(Orders order) {
		if(order.getBookID() != 0 && order.getCustomerID() != 0) 
		{
			return true;
		}
		else return false;
	}
}
