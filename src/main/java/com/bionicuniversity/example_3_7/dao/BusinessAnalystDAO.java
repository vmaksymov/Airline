package com.bionicuniversity.example_3_7.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionicuniversity.example_3_7.entity.DailyReport;
import com.bionicuniversity.example_3_7.entity.DestinationReport;

@Repository
public class BusinessAnalystDAO{
	@PersistenceContext
    private EntityManager em;
	
	public List<Long> getCountBook(){
		TypedQuery<Long> query = em.createQuery(
				"SELECT count(b) FROM Book b ", Long.class);
		return query.getResultList();
	}
	
	public List<DailyReport> getDailyReport(){
		TypedQuery<DailyReport> query = em.createQuery(
				"SELECT new com.bionicuniversity.example_3_7.entity.DailyReport(b.datePaid, SUM(t.count), SUM(b.sumBook)) FROM Book b, Ticket t WHERE t.bookId=b.id GROUP BY b.datePaid  ", DailyReport.class);
		return query.getResultList();
	}

	public List<DestinationReport> getDestinationReport(Date beginDate, Date endDate){
		TypedQuery<DestinationReport> query = em.createQuery(
				"SELECT new com.bionicuniversity.example_3_7.entity.DestinationReport(f.toFlight, SUM(t.count), SUM(b.sumBook)) FROM Flight f, Book b, Ticket t WHERE (t.bookId=b.id AND t.flightId=f.id) GROUP BY f.toFlight ", DestinationReport.class);
		return query.getResultList();
	}
}
