package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleBody {
	private int scheduleItemId;
	private String part;
	private String ford_part;
	private String partDescription;
	private String releaseDate;
	private List<BigDecimal> planQtyList;
	private List<BigDecimal> totalQtyList;
	private String um;
	
	public ScheduleBody() {
		
	}
	public int getScheduleItemId() {
		return scheduleItemId;
	}

	public void setScheduleItemId(Integer scheduleItemId) {
		this.scheduleItemId = scheduleItemId;
	}


	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	
	public String getFord_part() {
		return ford_part;
	}
	public void setFord_part(String ford_part) {
		this.ford_part = ford_part;
	}
	
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<BigDecimal> getPlanQtyList() {
		return planQtyList;
	}
	public void setPlanQtyList(List<BigDecimal> qtyList) {
		this.planQtyList = qtyList;
	}
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public void addPlanQty(BigDecimal planQty) {
		if (planQtyList == null) {
			planQtyList = new ArrayList<BigDecimal>();
		}
		planQtyList.add(planQty);
	}
	public List<BigDecimal> getTotalQtyList() {
		return totalQtyList;
	}
	public void setTotalQtyList(List<BigDecimal> totalQtyList) {
		this.totalQtyList = totalQtyList;
	}
	public void addTotalQty(BigDecimal totalQty) {
		if (totalQtyList == null) {
			totalQtyList = new ArrayList<BigDecimal>();
		}
		totalQtyList.add(totalQty);
	}
}
