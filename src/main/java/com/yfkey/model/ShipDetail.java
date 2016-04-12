package com.yfkey.model;

import java.math.BigDecimal;

public class ShipDetail extends BaseObject {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5826491249926044712L;
	private int id;                                	//主键
	private String ver;							   	//版本号
    private String part;                           	//物料号    
    private String desc;							//物料描述
    private String ford_part;						//福特物料号
    private String rec_palnt;						//收货工厂
    private String ship_fr;							//发货工厂
    private BigDecimal plan_qty;					//计划数
    private BigDecimal cum_ship;					//本次发货数
    private String um;							    //单位
    private String purpose;							//目的
    private BigDecimal unit_gw;						//单位毛重
    private BigDecimal unit_nw;						//单位净重
    private String wt_um;							//重量单位
    private String package_type;					//包装类型
    private String lading_qty;							//提单数量
    private String carrier;							//承运商代码
    private String trans_mthd;						//运输方式
    private String units_per;					//容器单位
    private String pur_order;						//采购订单
    private String equip;							//运载媒介
   
    private String ship_qty;						//本次发货数
    private String shipper;						    //装箱单号
    private String bl;								//提单号
    private String gw;							//毛重
    private String nw;							//净重
    private String conv_nbr;						//车牌号码
    private String airport;							//运载媒介

    private String nbr;								//订单号
    private String ln;								//订单行
    private String site;							//地点
    private String loc;								//库位

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
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
	public String getRec_palnt() {
		return rec_palnt;
	}
	public void setRec_palnt(String rec_palnt) {
		this.rec_palnt = rec_palnt;
	}
	public String getShip_fr() {
		return ship_fr;
	}
	public void setShip_fr(String ship_fr) {
		this.ship_fr = ship_fr;
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
	public String getUm() {
		return um;
	}
	public void setUm(String um) {
		this.um = um;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public BigDecimal getUnit_gw() {
		return unit_gw;
	}
	public void setUnit_gw(BigDecimal unit_gw) {
		this.unit_gw = unit_gw;
	}
	public BigDecimal getUnit_nw() {
		return unit_nw;
	}
	public void setUnit_nw(BigDecimal unit_nw) {
		this.unit_nw = unit_nw;
	}
	public String getWt_um() {
		return wt_um;
	}
	public void setWt_um(String wt_um) {
		this.wt_um = wt_um;
	}
	public String getPackage_type() {
		return package_type;
	}
	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}
	public String getLading_qty() {
		return lading_qty;
	}
	public void setLading_qty(String lading_qty) {
		this.lading_qty = lading_qty;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getTrans_mthd() {
		return trans_mthd;
	}
	public void setTrans_mthd(String trans_mthd) {
		this.trans_mthd = trans_mthd;
	}
	public String getUnits_per() {
		return units_per;
	}
	public void setUnits_per(String units_per) {
		this.units_per = units_per;
	}
	public String getPur_order() {
		return pur_order;
	}
	public void setPur_order(String pur_order) {
		this.pur_order = pur_order;
	}
	public String getEquip() {
		return equip;
	}
	public void setEquip(String equip) {
		this.equip = equip;
	}
	
	
	public String getShip_qty() {
		return ship_qty;
	}
	public void setShip_qty(String ship_qty) {
		this.ship_qty = ship_qty;
	}
	public String getShipper() {
		return shipper;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public String getBl() {
		return bl;
	}
	public void setBl(String bl) {
		this.bl = bl;
	}
	public String getGw() {
		return gw;
	}
	public void setGw(String gw) {
		this.gw = gw;
	}
	public String getNw() {
		return nw;
	}
	public void setNw(String nw) {
		this.nw = nw;
	}
	public String getConv_nbr() {
		return conv_nbr;
	}
	public void setConv_nbr(String conv_nbr) {
		this.conv_nbr = conv_nbr;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public String getNbr() {
		return nbr;
	}
	public void setNbr(String nbr) {
		this.nbr = nbr;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
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
		ShipDetail other = (ShipDetail) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShipDetail [id=" + id + "]";
	}

    
    
}
