package com.bionicuniversity.example_3_7.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionicuniversity.example_3_7.entity.*;

@Repository
public class FlightDAO extends GenericDaoImpl<Flights> {

	public List<Flights> getListFlights(Date date){
		TypedQuery<Flights> query = em.createQuery(
				"SELECT f FROM Flights f WHERE f.fromDate>?1 ORDER BY f.numberFlight", Flights.class);
		query.setParameter(1, date);		
		return query.getResultList();
	}
	
	public List<Flights> getListFlights(String fromFlight, String toFlight, 
			Date fromDate, Date toDate, String nameFlight){
				String queryStr="SELECT f FROM Flights f WHERE f.ticket > 0 ";
				if (fromFlight!=null) queryStr+="AND f.fromFlight=fromFlight ";
				if (toFlight!=null) queryStr+="AND f.toFlight=toFlight ";
				if (fromDate!=null) queryStr+="AND f.fromDate>=fromDate ";
				if (toDate!=null) queryStr+="AND f.toDate<=toDate ";
				if (nameFlight!=null) queryStr+="AND f.nameFlight=nameFlight ";
				TypedQuery<Flights> query = em.createQuery(queryStr, Flights.class);
		return query.getResultList();
	}
}
