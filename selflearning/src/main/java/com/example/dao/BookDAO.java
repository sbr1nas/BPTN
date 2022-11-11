package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.bean.Books;
import com.example.dao.mapper.BooksMapper;

@Repository
public class BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	public List<Books> listBooks(){
		String sql = "SELECT * FROM \"Books\"";
		
		return jdbcTemplate.query(sql, new BooksMapper());
	}

	public Books addBook(Books book) {
		String sql = "INSERT INTO \"Books\"(\"Title\", \"Author\", \"MSRP\") VALUES(:title, :author, :MSRP)";
		
		KeyHolder key = new GeneratedKeyHolder(); // to get generated ID from database
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("title", book.getTitle())
				.addValue("author", book.getAuthor())
				.addValue("MSRP", book.getMSRP());
		namedTemplate.update(sql, param, key, new String[]{"BookID"});
			//need to have String array with name of column so you don't get multiple key exception
		book.setBookID(key.getKeyAs(Integer.class));
		
		return book;
	}
}


