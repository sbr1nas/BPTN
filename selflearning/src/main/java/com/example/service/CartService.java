package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CartDAO;
import com.example.dto.Cart;

@Service
public class CartService {
	//cart should be by customer ID - list all orders and books associated w/ orders

	@Autowired
	CartDAO cartDAO;
	
	public List<Cart> getCartByCustomer(Long customerID) throws Exception{
		List<Cart> cart = cartDAO.cartByCustomer(customerID);
		if(!cart.isEmpty()) 
		{
			return cart;
		}
		else throw new Exception("Cart empty. BUY SOMETHING!");
	}
	
	public double cartTotal (Long customerID) 
	{
		double total = cartDAO.totalCost(customerID);
		return total;
	}
}
