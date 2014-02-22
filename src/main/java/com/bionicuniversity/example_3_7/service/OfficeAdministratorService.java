package com.bionicuniversity.example_3_7.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.bionicuniversity.example_3_7.dao.BookDAO;
import com.bionicuniversity.example_3_7.dao.FlightDAO;
import com.bionicuniversity.example_3_7.dao.TicketDAO;
import com.bionicuniversity.example_3_7.entity.Book;
import com.bionicuniversity.example_3_7.entity.Flights;
import com.bionicuniversity.example_3_7.entity.Ticket;

@Named
@Scope("request")
public class OfficeAdministratorService {
	@Inject
    private FlightDAO flightDAO;
	@Inject
    private TicketDAO ticketDAO;
	@Inject
	private BookDAO bookDAO;
	
	@Transactional
    public void createFlight(String numberFlight, String fromFlight, String toFlight,
    		Date fromDate, Date toDate, int count, int price) {
        Flights flight = new Flights();
        flight.setNumberFlight(numberFlight); 
        flight.setFromFlight(fromFlight);
        flight.setToFlight(toFlight);
        flight.setFromDate(fromDate);
        flight.setToDate(toDate);
        flight.setCount(count);
        flight.setPrice(price);
		flightDAO.create(flight);
		System.out.println(flight);
    }
	
	
	@Transactional
    public void updateFlight(int id, String numberFlight, String fromFlight, String toFlight,
    		Date fromDate, Date toDate, int count, int price) {
		Flights flight=flightDAO.read(id);
		List<Ticket> listT=ticketDAO.getTicketFlight(flight.getId());
		if (listT==null || listT.size()<=0){
		flight.setNumberFlight(numberFlight); 
        flight.setFromFlight(fromFlight);
        flight.setToFlight(toFlight);
        flight.setFromDate(fromDate);
        flight.setToDate(toDate);
        flight.setCount(count);
        flight.setPrice(price);
        System.out.println(flight);
        flightDAO.update(flight);
		}
    }
	
	@Transactional
    public void deleteFlight(int id) {
//		List<Ticket> listT=ticketDAO.getTicketFlight(flight.getId());
//		if (listT==null || listT.size()<=0){
			flightDAO.delete(id);
//		}
    }

	@Transactional
	public void changeCountTicket(int id, int count){
		Flights flight=flightDAO.read(id);
		List<Ticket> listT=ticketDAO.getTicketFlight(flight.getId());
		if (listT==null || listT.size()<=0){
			flight.setCount(count);
	        flightDAO.update(flight);
		}
	}
	
	@Transactional
	private void removeReservation(Date date){
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-3);
		java.sql.Date startDate=new java.sql.Date(calendar.getTimeInMillis());
		
		List<Book> listB=bookDAO.getListReservation(startDate);
		if (listB!=null){
			for (Book b:listB){
				bookDAO.delete(b);
			}
		}
	}
	
	@Transactional
    public List<Flights> findAll() {
        return flightDAO.getListFlights(new Date());
    }
}
