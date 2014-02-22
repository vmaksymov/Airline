package com.bionicuniversity.example_3_7.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import com.bionicuniversity.example_3_7.entity.DailyReport;
import com.bionicuniversity.example_3_7.entity.DestinationReport;
import com.bionicuniversity.example_3_7.service.BusinessAnalystService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@Scope("request")
public class BusinessAnalistBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
    private BusinessAnalystService businessAnalystService;
	private Date beginDate;
	private Date endDate;
	
	private Date dateDaily;
	private long countDaily;
	private long sumBookDaily;
	private List<DailyReport> listDaily;
	
	private String toFlightDestination;
	private long countDestination;
	private long sumBookDestination;
	private List<DestinationReport> listDestination;
	
	public List<DailyReport> getListDaily() {
		listDaily=businessAnalystService.findDailyReport();
		return listDaily;
	}
	public void setListDaily(List<DailyReport> listDaily) {
		this.listDaily = listDaily;
	}
	public List<DestinationReport> getListDestination() {
		listDestination=businessAnalystService.findDestinationReport(beginDate,endDate);
		return listDestination;
	}
	public void setListDestination(List<DestinationReport> listDestination) {
		this.listDestination = listDestination;
	}
			
	public Date getDateDaily() {
		return dateDaily;
	}
	public void setDateDaily(Date dateDaily) {
		this.dateDaily = dateDaily;
	}
	public long getCountDaily() {
		return countDaily;
	}
	public void setCountDaily(long countDaily) {
		this.countDaily = countDaily;
	}
	public long getSumBookDaily() {
		return sumBookDaily;
	}
	public void setSumBookDaily(long sumBookDaily) {
		this.sumBookDaily = sumBookDaily;
	}
	public String getToFlightDestination() {
		return toFlightDestination;
	}
	public void setToFlightDestination(String toFlightDestination) {
		this.toFlightDestination = toFlightDestination;
	}
	public long getCountDestination() {
		return countDestination;
	}
	public void setCountDestination(long countDestination) {
		this.countDestination = countDestination;
	}
	public long getSumBookDestination() {
		return sumBookDestination;
	}
	public void setSumBookDestination(long sumBookDestination) {
		this.sumBookDestination = sumBookDestination;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
