package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Orders;
import com.example.dto.Cart;
import com.example.service.CartService;
import com.example.service.OrderService;

@RestController
@RequestMapping("/Blahmazon")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping(value = "/Cart/{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCartByCustomer(@PathVariable("customerID") Long customerID){
		try 
		{
			List<Cart> cart = cartService.getCartByCustomer(customerID);
			double total = cartService.cartTotal(customerID);
		
			Map<String, Object> cartDetails = new HashMap<String,Object>();
			cartDetails.put("Cart Details: ", cart);
			cartDetails.put("Cart Total: ", ("$" + total));
		
			return new ResponseEntity<>(cartDetails, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/Order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> placeOrder(@RequestBody Orders order){
		try 
		{
			orderService.addOrder(order);
			return new ResponseEntity<>("Order added to Cart", HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>("REQUEST DENIED: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
