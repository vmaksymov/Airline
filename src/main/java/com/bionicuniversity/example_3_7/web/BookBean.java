package com.bionicuniversity.example_3_7.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionicuniversity.example_3_7.entity.Book;
import com.bionicuniversity.example_3_7.service.AccountantService;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Named
@Scope("request")
public class BookBean implements Serializable {
	@Inject
    private AccountantService accountantService;
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String createRowName;
	private String email;
	private Date timeCreate;
	private int sumBook;
	private int state;
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
	public List<Book> getList() {
		list=accountantService.findAll();
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	private Date datePaid;
	private String notePayment;
	private List<Book> list;
	
	public String onApply() { 
//		System.out.println("ddd"+id);
//		System.out.println(this.passwordHex);
//		accountService.updateAccount(id, login, passwordHex, role);
    	FacesMessage msg = new FacesMessage("book pay");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
	
	public String onCancel() { 
   	   	FacesMessage msg = new FacesMessage("back");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }

}
