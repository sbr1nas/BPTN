package com.example.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.bean.Books;

public class BooksMapper implements RowMapper<Books> {

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Books book = new Books();
		
		book.setBookID(rs.getInt("BookID"));
		book.setTitle(rs.getString("Title"));
		book.setAuthor(rs.getString("Author"));
		book.setMSRP(rs.getDouble("MSRP"));
		
		return book;
	}

}
