package com.bionicuniversity.example_3_7.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import com.bionicuniversity.example_3_7.dao.BusinessAnalystDAO;
import com.bionicuniversity.example_3_7.entity.DailyReport;
import com.bionicuniversity.example_3_7.entity.DestinationReport;

@Named
@Scope("request")
public class BusinessAnalystService {
	@Inject
    private BusinessAnalystDAO businessAnalystDAO;
	
	@Transactional
    public List<DestinationReport> findDestinationReport(Date beginDate, Date endDate) {
		if (beginDate==null) beginDate=new Date(0);
		if (endDate==null) endDate=new Date();
		if (businessAnalystDAO.getCountBook().get(0)>0)
        return businessAnalystDAO.getDestinationReport(beginDate, endDate);
		else return new ArrayList<DestinationReport>();
    }
	
	@Transactional
    public List<DailyReport> findDailyReport() {
		if (businessAnalystDAO.getCountBook().get(0)>0)
        return businessAnalystDAO.getDailyReport();
		else return new ArrayList<DailyReport>();
    }
}
