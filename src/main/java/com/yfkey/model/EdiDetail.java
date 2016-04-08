package com.yfkey.model;

import java.math.BigDecimal;
import java.util.List;

import com.progress.open4gl.Parameter;

public class EdiDetail extends BaseObject {

	private static final long serialVersionUID = -5381824063748689684L;
	private int id;					//主键
	private String domain; 			// 域
	private String ver;				//版本
    private String rlse_dt;			//文件发布日期
    private String part;			//物料号
    private String desc;			//物料描述
    private String ford_part;       //福特物料号
    private String um;				//单位
    private String plan_dt;			//计划日期
    private BigDecimal plan_qty;	//数量
    private BigDecimal cum_ship;	//累计发货数
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getRlse_dt() {
		return rlse_dt;
	}
	public void setRlse_dt(String rlse_dt) {
		this.rlse_dt = rlse_dt;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFord_part() {
		return ford_part;
	}
	public void setFord_part(String ford_part) {
		this.ford_part = ford_part;
	}
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public String getPlan_dt() {
		return plan_dt;
	}
	public void setPlan_dt(String plan_dt) {
		this.plan_dt = plan_dt;
	}
	public BigDecimal getPlan_qty() {
		return plan_qty;
	}
	public void setPlan_qty(BigDecimal plan_qty) {
		this.plan_qty = plan_qty;
	}
	public BigDecimal getCum_ship() {
		return cum_ship;
	}
	public void setCum_ship(BigDecimal cum_ship) {
		this.cum_ship = cum_ship;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EdiDetail other = (EdiDetail) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EdiDetail [id=" + id + "]";
	}
    
    
    
    
}
