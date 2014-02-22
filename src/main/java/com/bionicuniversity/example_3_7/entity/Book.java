package com.bionicuniversity.example_3_7.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String createRowName;
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeCreate;
	
	private int sumBook;
	private int state;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePaid;
	
	private String notePayment;
	
	public Book(String createRowName, String email, Date timeCreate,
			int sumBook, int state, Date datePaid, String notePayment) {
		super();
		this.createRowName = createRowName;
		this.email = email;
		this.timeCreate = timeCreate;
		this.sumBook = sumBook;
		this.state = state;
		this.datePaid = datePaid;
		this.notePayment = notePayment;
	}
	
	public Book(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateRowName() {
		return createRowName;
	}

	public void setCreateRowName(String createRowName) {
		this.createRowName = createRowName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public int getSumBook() {
		return sumBook;
	}

	public void setSumBook(int sumBook) {
		this.sumBook = sumBook;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getDatePaid() {
		return datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public String getNotePayment() {
		return notePayment;
	}

	public void setNotePayment(String notePayment) {
		this.notePayment = notePayment;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", createRowName=" + createRowName
				+ ", email=" + email + ", timeCreate=" + timeCreate
				+ ", sumBook=" + sumBook + ", state=" + state + ", datePaid="
				+ datePaid + ", notePayment=" + notePayment + "]";
	}
	
}
