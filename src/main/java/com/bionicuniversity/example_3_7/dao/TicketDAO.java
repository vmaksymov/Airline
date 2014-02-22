package com.bionicuniversity.example_3_7.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.bionicuniversity.example_3_7.entity.*;

@Repository
public class TicketDAO extends GenericDaoImpl<Ticket> {

	public List<Ticket> getTicketFlight(int id){
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE t.flightId = ?1 ", Ticket.class);
		query.setParameter(1, id);		
		return query.getResultList();
	}
	
	public List<Ticket> getTicketFromBook(int id){
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE t.bookId = ?1 ", Ticket.class);
		query.setParameter(1, id);		
		return query.getResultList();
	}
	
	public List<Ticket> getTicket(int idBook, int idFlight){
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE t.bookId = ?1 AND t.flightId = ?2 ", Ticket.class);
		query.setParameter(1, idBook);
		query.setParameter(2, idFlight);
		return query.getResultList();
	}
}
