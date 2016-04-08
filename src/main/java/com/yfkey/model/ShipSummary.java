package com.yfkey.model;

import java.math.BigDecimal;
import java.util.List;

import com.progress.open4gl.Parameter;

public class ShipSummary extends BaseObject {

	private static final long serialVersionUID = 4422345525144936486L;
	
	private String domain; // 域
	private String shipto; // 收货工厂
	private String plandt_fr; // 计划日期从
	private String plandt_to; // 计划日期到
	private String importdt_fr; // 导入日期从
	private String importdt_to; // 导入日期到

	private String ver; // 版本
	private String rlse_dt; // 文件发布日期
	private String type; // 类型
	private String import_dt; // 导入日期
	private String plandt; // 计划日期
	
	private Boolean hasShipError;//发货错误
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getShipto() {
		return shipto;
	}
	public void setShipto(String shipto) {
		this.shipto = shipto;
	}
	public String getPlandt_fr() {
		return plandt_fr;
	}
	public void setPlandt_fr(String plandt_fr) {
		this.plandt_fr = plandt_fr;
	}
	public String getPlandt_to() {
		return plandt_to;
	}
	public void setPlandt_to(String plandt_to) {
		this.plandt_to = plandt_to;
	}
	public String getImport_dt() {
		return import_dt;
	}

	public void setImport_dt(String import_dt) {
		this.import_dt = import_dt;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getHasShipError() {
		return hasShipError;
	}

	public void setHasShipError(Boolean hasShipError) {
		this.hasShipError = hasShipError;
	}
	
	public String getImportdt_fr() {
		return importdt_fr;
	}
	public void setImportdt_fr(String importdt_fr) {
		this.importdt_fr = importdt_fr;
	}
	public String getImportdt_to() {
		return importdt_to;
	}
	public void setImportdt_to(String importdt_to) {
		this.importdt_to = importdt_to;
	}
	public String getPlandt() {
		return plandt;
	}
	public void setPlandt(String plandt) {
		this.plandt = plandt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ver == null) ? 0 : ver.hashCode());
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
		ShipSummary other = (ShipSummary) obj;
		if (ver == null) {
			if (other.ver != null)
				return false;
		} else if (!ver.equals(other.ver))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Edi [ver=" + ver + "]";
	}

  
    
}
