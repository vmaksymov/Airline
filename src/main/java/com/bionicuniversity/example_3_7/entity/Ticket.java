package com.bionicuniversity.example_3_7.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int bookId;
	private int flightId;
	private int count;
		
	public Ticket(int bookId, int flightId, int count) {
		super();
		this.bookId = bookId;
		this.flightId = flightId;
		this.count = count;
	}
	
	public Ticket(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", bookId=" + bookId + ", flightId="
				+ flightId + ", count=" + count + "]";
	}
	
}
