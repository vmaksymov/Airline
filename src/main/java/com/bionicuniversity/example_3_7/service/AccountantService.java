package com.bionicuniversity.example_3_7.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.bionicuniversity.example_3_7.dao.BookDAO;
import com.bionicuniversity.example_3_7.entity.Book;

@Named
@Scope("request")
public class AccountantService {
	@Inject
    private BookDAO bookDAO;
	
	@Transactional
	public void changeState(Book book, java.sql.Date date){
			book.setState(2);
			book.setDatePaid(date);
			bookDAO.update(book);
	}
	
	@Transactional
	public List<Book> findAll() {
        return bookDAO.getActualReservation();
    }
}
