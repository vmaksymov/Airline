package com.bionicuniversity.example_3_7.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flights {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result
				+ ((fromFlight == null) ? 0 : fromFlight.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((numberFlight == null) ? 0 : numberFlight.hashCode());
		result = prime * result + price;
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result
				+ ((toFlight == null) ? 0 : toFlight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flights other = (Flights) obj;
		if (count != other.count)
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (fromFlight == null) {
			if (other.fromFlight != null)
				return false;
		} else if (!fromFlight.equals(other.fromFlight))
			return false;
		if (id != other.id)
			return false;
		if (numberFlight == null) {
			if (other.numberFlight != null)
				return false;
		} else if (!numberFlight.equals(other.numberFlight))
			return false;
		if (price != other.price)
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (toFlight == null) {
			if (other.toFlight != null)
				return false;
		} else if (!toFlight.equals(other.toFlight))
			return false;
		return true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String numberFlight;
	private String fromFlight;
	private String toFlight;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fromDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date toDate;
	
	private int count;
	private int price;
	
	public Flights(String numberFlight, String fromFlight,
			String toFlight, Date fromDate, Date toDate, int count, int price) {
		super();
		this.numberFlight = numberFlight;
		this.fromFlight = fromFlight;
		this.toFlight = toFlight;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.count = count;
		this.price = price;
	}

	public Flights(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Flights [id=" + id + ", numberFlight=" + numberFlight
				+ ", fromFlight=" + fromFlight + ", toFlight=" + toFlight
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", count="
				+ count + ", price=" + price + "]";
	}
	
}
