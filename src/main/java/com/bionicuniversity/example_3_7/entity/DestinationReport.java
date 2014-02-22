package com.bionicuniversity.example_3_7.entity;

public class DestinationReport {

	private String toFlight;
	private int countTickets;
	private int totalSum;
	
	public DestinationReport(String toFlight, int countTickets, int totalSum) {
		super();
		this.toFlight = toFlight;
		this.countTickets = countTickets;
		this.totalSum = totalSum;
	}
	
	public DestinationReport(){
		
	}

	public String getToFlight() {
		return toFlight;
	}

	public void setToFlight(String toFlight) {
		this.toFlight = toFlight;
	}

	public int getCountTickets() {
		return countTickets;
	}

	public void setCountTickets(int countTickets) {
		this.countTickets = countTickets;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	@Override
	public String toString() {
		return "DestinationReport [toFlight=" + toFlight + ", countTickets="
				+ countTickets + ", totalSum=" + totalSum + "]";
	}
	
}
