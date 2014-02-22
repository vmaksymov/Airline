package com.bionicuniversity.example_3_7.web;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import com.bionicuniversity.example_3_7.entity.Account;
import com.bionicuniversity.example_3_7.service.AccountService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Scope("request")
public class AccountBean implements Serializable {
	@Inject
    private AccountService accountService;
	
	private static final long serialVersionUID = 1L;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String login;
	private String passwordHex;
	private int role;
	private boolean del;
	private List<Account> list;
	
	public void setList(List<Account> list) {
		this.list = list;
	}

	public List<Account> getList() {
		if (list==null)
		list=(ArrayList<Account>)accountService.findAll();
		return list;
	}
		
	public boolean getDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswordHex() {
		return passwordHex;
	}
	public void setPasswordHex(String passwordHex) {
		this.passwordHex = passwordHex;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public String onAdd() {    	
		accountService.createAccount(login, passwordHex, role);
    	login="";
    	passwordHex="";
    	list=null;
    	FacesMessage msg = new FacesMessage("create account");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
	
	public String onCancelAdd() { 
    	login="";
    	passwordHex="";
    	list=null;
    	FacesMessage msg = new FacesMessage("back");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
	
	public void selectDelete(int id) { 
		accountService.deleteAccount(id);
		list=null;
    	FacesMessage msg = new FacesMessage("delete account");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public String onEdit(RowEditEvent event) { 
		accountService.updateAccount(((Account)event.getObject()).getId(), ((Account)event.getObject()).getLogin(), ((Account)event.getObject()).getPasswordHex(), ((Account)event.getObject()).getRole());
		list=null;
    	FacesMessage msg = new FacesMessage("edit account");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
	
	public String onCancel() { 
   	   	FacesMessage msg = new FacesMessage("back");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
	
	public String getRoleString(int i){
		switch (i){
		case 1: return "Security";
		case 2: return "Admin";
		case 3: return "Accountant";
		case 4: return "Business analyst";
		default : return "unknow";
		}
	}
}
