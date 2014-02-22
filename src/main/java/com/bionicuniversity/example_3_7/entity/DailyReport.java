package com.bionicuniversity.example_3_7.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DailyReport {

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReport;
	
	private long countTickets;
	private long totalSum;
	
	public DailyReport(Date dateReport, long countTickets, long totalSum) {
		super();
		this.dateReport = dateReport;
		this.countTickets = countTickets;
		this.totalSum = totalSum;
	}
    
	public DailyReport(){
		
	}

	public Date getDateReport() {
		return dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

	public long getCountTickets() {
		return countTickets;
	}

	public void setCountTickets(int countTickets) {
		this.countTickets = countTickets;
	}

	public long getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	@Override
	public String toString() {
		return "DailyReport [dateReport=" + dateReport + ", countTickets="
				+ countTickets + ", totalSum=" + totalSum + "]";
	}
	
}
