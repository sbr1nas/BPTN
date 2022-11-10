package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Books;
import com.example.dao.BookDAO;

@Service
public class BookService {

	@Autowired
	BookDAO bookDAO;
	
	public List<Books> getAllBooks(){
		List<Books> bookList = bookDAO.listBooks();
		return bookList;
	}
	
	public Books addBook(Books book) throws Exception {
		if(!validateBookRequest(book)) 
		{
			throw new Exception("INVALID REQUEST");
		}
		else 
		{
			bookDAO.addBook(book);
			return book;
		}
	}

//only check for title + author. bookID generated by database
	private boolean validateBookRequest(Books book) {
		if(book.getTitle() != null && !book.getTitle().isEmpty() 
				&& book.getAuthor() !=null && !book.getAuthor().isEmpty() && book.getMSRP()!=0) 
		{
			return true;
		}
		else return false;
	}
}
