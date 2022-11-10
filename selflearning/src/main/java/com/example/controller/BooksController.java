package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Books;
import com.example.service.BookService;

@RestController
@RequestMapping("/Blahmazon")
public class BooksController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value = "/Inventory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getBookInventory(){
		List<Books> inv = bookService.getAllBooks();
		return new ResponseEntity<>(inv, HttpStatus.OK);
	}
	
	@PostMapping(value = "/Inventory/Add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addBookToInventory(@RequestBody Books book){
		try 
		{
			Books added = bookService.addBook(book);
			String status = "Book has been added to inventory";
			
			Map<String, Object> addSuccess = new HashMap<String,Object>();
			addSuccess.put("STATUS: ", status);
			addSuccess.put("Book Details: ", added);
			
			return new ResponseEntity<>(addSuccess, HttpStatus.OK);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return new ResponseEntity<>("REQUEST DENIED: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}

}
