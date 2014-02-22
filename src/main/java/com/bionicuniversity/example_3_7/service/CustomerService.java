package com.bionicuniversity.example_3_7.service;

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
public class CustomerService {
	@Inject
	private TicketDAO ticketDao;
	@Inject
	private BookDAO bookDao;
	@Inject
	private FlightDAO flightDao;
	
	@Transactional
	public List<Ticket> getTicketFromBook(int idBook) {
		return ticketDao.getTicketFromBook(idBook);
	}

	@Transactional
	public List<Flights> getListFlights(String fromFlight, String toFlight, 
			Date fromDate, Date toDate, String nameFlight){
		return flightDao.getListFlights(fromFlight, toFlight, fromDate, toDate, nameFlight);
	}
	
	@Transactional
	public Book addNewBook(String createRowName, String email, String notePayment){
		Book book=new Book();
		book.setCreateRowName(createRowName);
		book.setEmail(email);
		book.setTimeCreate(new Date());
		book.setState(1);
		book.setNotePayment(notePayment);
		System.out.println(book);
		return bookDao.create(book);
	}
	
	@Transactional
	public Ticket getTicket(int idBook, int idFlight){
		List<Ticket> result=ticketDao.getTicket(idBook, idFlight);
		if (result!=null && result.size()>0)
		return result.get(0);
		else return new Ticket();
	}
	
	@Transactional
	public void addTicketToBook(int idBook, int idFlight, int count){
		Ticket ticket=new Ticket();
		ticket.setBookId(idBook);
		ticket.setFlightId(idFlight);
		ticket.setCount(count);
		ticketDao.create(ticket);
	}
	
	@Transactional
	public void changeCountTicketToBook(int idTicket, int count){
		Ticket ticket=ticketDao.read(idTicket);
		ticket.setCount(count);
		ticketDao.update(ticket);
	}
	
	@Transactional
	public void removeTicketFromBook(int idTicket){
		Ticket ticket=ticketDao.read(idTicket);
		ticketDao.delete(ticket);
	}
	
	@Transactional
	public void submitAndReservation(int idBook){
		Book book=bookDao.read(idBook);
		book.setState(2);
		book.setDatePaid(new Date());
		bookDao.update(book);
	}
	
	@Transactional
	public void createBook(String createRowName,String email,List<Flights> ticket){
		Book book=new Book();
		book.setCreateRowName(createRowName);
		book.setEmail(email);
		book.setTimeCreate(new Date());
		book.setState(1);
		book.setNotePayment("");
		System.out.println(book);
		book=bookDao.create(book);
		int i=book.getId();
		int total=0;
		for (Flights t : ticket){
			Ticket tick=new Ticket();
			tick.setBookId(i);
			tick.setFlightId(t.getId());
			tick.setCount(t.getId());
			ticketDao.create(tick);
			Flights ff= flightDao.read(t.getId());
			ff.setCount(ff.getCount()-t.getCount());
			flightDao.update(ff);
			total+=t.getCount()*t.getPrice();
		}
		book.setSumBook(total);
	}
	
}
