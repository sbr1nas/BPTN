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

import com.example.bean.Customers;
import com.example.bean.Payment;
import com.example.service.CustomerService;
import com.example.service.PaymentService;

@RestController
@RequestMapping("/Blahmazon")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping(value="/Customers", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCustomers(){
		List<Customers> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	
	@GetMapping(value="/Account/{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCustomerDetails(@PathVariable("customerID") Long customerID){
		Customers customer = customerService.getCustomerByID(customerID);
		List<Payment> paymentMethods = paymentService.getPaymentMethodsForCustomer(customerID);
		
		Map<String, Object> accountDetails = new HashMap<String,Object>();
		accountDetails.put("Customer Info", customer);
		accountDetails.put("Saved Payment Methods", paymentMethods);
		
		return new ResponseEntity<>(accountDetails, HttpStatus.OK);
	}
	
	@PostMapping(value="/Register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewCustomer(@RequestBody Customers customer){
		try 
		{
			Customers added = customerService.addCustomer(customer);
			String status = "Congratulations! Your account at Blahmazon is now active. Happy Shopping!!";
			
			Map<String, Object> addSuccess = new HashMap<String,Object>();
			addSuccess.put("STATUS: ", status);
			addSuccess.put("Customer Details: ", added);
			
			return new ResponseEntity<>(addSuccess, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>("REQUEST DENIED: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value="/Account/PaymentMethod", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewPaymentMethod(@RequestBody Payment pay){
		try 
		{
			Payment added = paymentService.addPaymentMethod(pay);
			String status = "Thank you! Account details have been updated with new payment method";
			
			Map<String, Object> addSuccess = new HashMap<String, Object>();
			addSuccess.put("STATUS", status);
			addSuccess.put("Added Payment Method: ", added);
			
			return new ResponseEntity<>(addSuccess, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>("REQUEST DENIED: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
