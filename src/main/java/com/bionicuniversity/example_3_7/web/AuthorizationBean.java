package com.bionicuniversity.example_3_7.web;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.bionicuniversity.example_3_7.service.AutorizationService;
import java.io.Serializable;

@Named
@Scope("session")
public class AuthorizationBean implements Serializable {
	@Inject
    private AutorizationService autorizationService;
	
	private static final long serialVersionUID = 1L;
	
	private int role;
	private String login;
	private String passwordHex;
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
	
	public void onLogin() {
//		if (autorizationService.getRole(login, passwordHex)!=0) this.role=autorizationService.getRole(login, passwordHex);
//		else this.role=0;
//		
//		System.out.println(this.role);
//		try {
//			switch (this.role){
//			case '1' : FacesContext.getCurrentInstance().getExternalContext().redirect("securityOfficer.xhtml");
//			        break;
//			case '2' : FacesContext.getCurrentInstance().getExternalContext().redirect("flight.xhtml");
//	           		break;
//			case '3' : FacesContext.getCurrentInstance().getExternalContext().redirect("accountant.xhtml");
//	           		break;
//			case '4' : FacesContext.getCurrentInstance().getExternalContext().redirect("bussinesAnalist.xhtml");
//	           		break;
//			default : FacesContext.getCurrentInstance().getExternalContext().redirect("customer.xhtml");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void onBack() {
		System.out.println("authorization back");
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
