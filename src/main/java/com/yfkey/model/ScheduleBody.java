package com.yfkey.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleBody {
	private int scheduleItemId;
	private String itemCode;
	private String supplierItemCode;
	private String itemDescription;
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

	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getSupplierItemCode() {
		return supplierItemCode;
	}
	public void setSupplierItemCode(String supplierItemCode) {
		this.supplierItemCode = supplierItemCode;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
