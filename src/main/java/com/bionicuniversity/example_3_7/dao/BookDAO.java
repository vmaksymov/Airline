package com.bionicuniversity.example_3_7.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionicuniversity.example_3_7.entity.*;

@Repository
public class BookDAO extends GenericDaoImpl<Book> {
	
	public List<Book> getListReservation(Date date){
		TypedQuery<Book> query = em.createQuery(
				"SELECT b FROM Book b WHERE b.timeCreate<?1", Book.class);
		query.setParameter(1, date);		
		return query.getResultList();
	}
	
	public List<Book> getActualReservation(){
		TypedQuery<Book> query = em.createQuery(
				"SELECT b FROM Book b WHERE b.state = 1 ", Book.class);
		return query.getResultList();
	}
}
