package com.bionicuniversity.example_3_7.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import com.bionicuniversity.example_3_7.entity.Flights;
import com.bionicuniversity.example_3_7.service.OfficeAdministratorService;

import java.io.Serializable;

@Named
@Scope("request")
public class FlightBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
    private OfficeAdministratorService officeAdministratorService;
	
	private String numberFlight;
	private int id;
	private String fromFlight;
	private String toFlight;
	private Date fromDate;
	private Date toDate;
	private int count;
	private int price;
	private List<Flights> list;
	
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
	
    public String onEdit(RowEditEvent event) {
    	System.out.println("eeeee");
    	officeAdministratorService.updateFlight(((Flights)event.getObject()).getId(),((Flights)event.getObject()).getNumberFlight(), ((Flights)event.getObject()).getFromFlight(), ((Flights)event.getObject()).getToFlight(), ((Flights)event.getObject()).getFromDate(), ((Flights)event.getObject()).getToDate(), ((Flights)event.getObject()).getCount(), ((Flights)event.getObject()).getPrice());
    	list=null;
    	FacesMessage msg = new FacesMessage("Flight edited");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        return null;
    }  
      
    public String onCancel(RowEditEvent event) { 
    	System.out.println("aaaa");
    	list=null;
        FacesMessage msg = new FacesMessage("Flight cancelled");  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        return null;
    }  
	
    public String onAdd() {  
    	officeAdministratorService.createFlight(numberFlight, fromFlight, toFlight, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()), count, price);
    	numberFlight="";
    	fromFlight="";
    	toFlight="";
    	fromDate=null;
    	toDate=null;
    	count=0;
    	price=0;
    	list=null;
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
    	list=null;
    	FacesMessage msg = new FacesMessage("Flight canceled add");    
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public String removeEntity(int id) { 
    	
    	officeAdministratorService.deleteFlight(id);
    	list=null;
    	FacesMessage msg = new FacesMessage("Flight removed");  
    	  
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	
    	return null;
    }
    

}
