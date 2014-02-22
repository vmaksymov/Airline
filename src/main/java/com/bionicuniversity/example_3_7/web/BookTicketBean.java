package com.bionicuniversity.example_3_7.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.rowexpansion.RowExpansion;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.SelectableDataModel;
import org.springframework.context.annotation.Scope;

import com.bionicuniversity.example_3_7.entity.Account;
import com.bionicuniversity.example_3_7.entity.Book;
import com.bionicuniversity.example_3_7.entity.Flights;
import com.bionicuniversity.example_3_7.entity.Ticket;
import com.bionicuniversity.example_3_7.service.CustomerService;
import com.bionicuniversity.example_3_7.service.OfficeAdministratorService;

import java.io.Serializable;

@Named
@Scope("request")
public class BookTicketBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
    private OfficeAdministratorService officeAdministratorService;
	
	@Inject
    private CustomerService customerService;
	
	private String numberFlight;
	private int id;
	private Flights selectedRow;
	
	public Flights getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(Flights selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> complete(String query) {  
        List<String> city=new ArrayList<String>();
		city.add("Kiev");
		city.add("Moscow");
		city.add("Minsk");  
        List<String> res=new ArrayList<String>();  
		for(String str:city){
			if (str.indexOf(query)>-1) res.add(str);
		}
        return res;  
    }  
	
	public String getNumberFlight() {
		return numberFlight;
	}
	public void setNumberFlight(String numberFlight) {
		this.numberFlight = numberFlight;
	}
	public String getFromFlight() {
		return fromFlight;
	}
	public void setFromFlight(String fromFlight) {
		this.fromFlight = fromFlight;
	}
	public String getToFlight() {
		return toFlight;
	}
	public void setToFlight(String toFlight) {
		this.toFlight = toFlight;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Flights> getList() {
		if (list==null) 
		list=officeAdministratorService.findAll();
		return list;
	}
	public void setList(ArrayList<Flights> list) {
		this.list = list;
	}
	
    public void onEdit(RowEditEvent event) { 
    	officeAdministratorService.updateFlight(id,numberFlight, fromFlight, toFlight, new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()), count, price);
        FacesMessage msg = new FacesMessage("Flight edited");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Flight cancelled");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
    public String onAdd() {  
    	officeAdministratorService.createFlight(numberFlight, fromFlight, toFlight, new java.sql.Date(fromDate.getTime()), new java.sql.Date(toDate.getTime()), count, price);
    	numberFlight="";
    	fromFlight="";
    	toFlight="";
    	fromDate=null;
    	toDate=null;
    	count=0;
    	price=0;
    	
    	FacesMessage msg = new FacesMessage("Flight added");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public String onCancelAdd() {  
    	
    	numberFlight="";
    	fromFlight="";
    	toFlight="";
    	fromDate=null;
    	toDate=null;
    	count=0;
    	price=0;
    	
    	FacesMessage msg = new FacesMessage("Flight canceled add");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public String removeEntity(int id) { 
    	
    	list.remove(id);
    	
    	FacesMessage msg = new FacesMessage("Flight removed");  
    	  
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	
    	return null;
    }
    
	private String fromFlight;
	private String toFlight;
	private Date fromDate;
	private Date toDate;
	private int count;
	private int price;
	private String createRowName;
	private String email;
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

	private List<Flights> list;
	
	private static List<Flights> ticket=new ArrayList<Flights>();

	public List<Flights> getTicket() {
		return ticket;
	}

	public void setTicket(List<Flights> ticket) {
		this.ticket = ticket;
	}

	public String onRowSelect(SelectEvent event) {
		label:
		do{
			for (Flights f:ticket){
				if (((Flights)event.getObject()).getId()==(f.getId())){
					f.setCount(f.getCount()+1);
					break label;
				}
			}
			Flights flight=(Flights)event.getObject();
			flight.setCount(1);
			ticket.add(flight);
		}while(false);
		
		
        FacesMessage msg = new FacesMessage("Car Selected",null);  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        return null;
    }  
  
    public void onRowUnselect() {  
        FacesMessage msg = new FacesMessage("Car Unselected", null);  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
    }
    
	public String onAddBook(){
		
		if (ticket==null || ticket.size()==0) return null; 
		
		customerService.createBook(createRowName, email, ticket);
		
		ticket=new ArrayList<Flights>();
		return null;
	}
	
	public void removeTicket(Flights f){
		for (Flights ff:ticket){
			if (ff.getId()==f.getId())
				ticket.remove(ff);
		}
	}
}
