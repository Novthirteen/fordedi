package com.yfkey.webapp.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.progress.open4gl.Parameter;
import com.progress.open4gl.ProDataObject;
import com.yfkey.Constants;
import com.yfkey.model.Edi;
import com.yfkey.model.EdiDetail;
import com.yfkey.model.Gender;
import com.yfkey.model.LabelValue;
import com.yfkey.model.ScheduleBody;
import com.yfkey.model.ScheduleHead;
import com.yfkey.model.ScheduleView;
import com.yfkey.model.ShipDetail;
import com.yfkey.model.ShipSummary;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Convenience class for setting and retrieving cookies.
 */
/**
 * @author druidwang
 *
 */
public final class QADUtil {

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private QADUtil() {
	}

	
	public static List<Edi> ConverToEdi(List<ProDataObject> proDataObjectList) {

		List<Edi> ediList = new ArrayList<Edi>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			for (ProDataObject o : proDataObjectList) {
				Edi edi = new Edi();
				edi.setVer(o.getString("tout1_ver"));
				edi.setRlse_dt(o.getString("tout1_rlse_dt"));
				edi.setType(o.getString("tout1_type"));
				edi.setPlandt(o.getString("tout1_plandt_fr") + "~" + o.getString("tout1_plandt_to"));
				edi.setImport_dt(o.getString("tout1_import_dt") + " "+  o.getString("tout1_import_tm"));
				
				ediList.add(edi);
			}
		}
		return ediList;
	}

	public static ScheduleView ConvertToEdiDetail(List<ProDataObject> proDataObjectList) {
	
		ScheduleView scheduleView = new ScheduleView();
		List<String> dateList = new ArrayList<String>();
		List<String> partList = new ArrayList<String>();
		ScheduleHead scheduleHead = new ScheduleHead();
		List<ScheduleBody> scheduleBodyList =  new ArrayList<ScheduleBody>();
		List<Map<String, Object>> headList = new ArrayList<Map<String, Object>>();
	
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			
			for (ProDataObject o : proDataObjectList) {
				String part = o.getString("tout2_part");
				String plan_dt  = o.getString("tout2_plan_dt");
				if(!dateList.contains(plan_dt))
				{
					dateList.add(plan_dt);
				}
				if(!partList.contains(part))
				{
					partList.add(part);
				}
			}
			
			Collections.sort(dateList);
			Collections.sort(partList);
			for(String d : dateList)
			{
				Map<String, Object> head = new HashMap<String, Object>();
				head.put("scheduleType", "Firm");
				head.put("dateFrom", d);
				head.put("dateTo", d);
				headList.add(head);
				
				for(String p:partList)
				{
				
					
					List<BigDecimal> planQtyList = new ArrayList<BigDecimal>();
					List<BigDecimal> totalQtyList = new ArrayList<BigDecimal>();
					for (ProDataObject o : proDataObjectList) 
					{
						String part = o.getString("tout2_part");
						String plan_dt  = o.getString("tout2_plan_dt");
						String desc  = o.getString("tout2_desc");
						if(p.equals(part) && d.equals(plan_dt))
						{
							BigDecimal planQty = o.getBigDecimal("tout2_plan_qty");
							BigDecimal totalQty = o.getBigDecimal("tout2_cum_ship");
							planQtyList.add(planQty);
							totalQtyList.add(totalQty);
							break;
						}
					}
					ScheduleBody sb1 = new ScheduleBody();
					sb1.setItemCode(p);
					sb1.setPlanQtyList(planQtyList);
					scheduleBodyList.add(sb1);
					
					ScheduleBody sb2 = new ScheduleBody();
					sb2.setItemCode(p);
					sb2.setTotalQtyList(totalQtyList);
					scheduleBodyList.add(sb2);
				}
				
			
			}
			
			scheduleHead.setHeadList(headList);
			scheduleView.setScheduleBodyList(scheduleBodyList);
			
		}
		return scheduleView;

	}

	public static List<ShipSummary> ConverToShipSummary(List<ProDataObject> proDataObjectList) {

		List<ShipSummary> ediList = new ArrayList<ShipSummary>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			for (ProDataObject o : proDataObjectList) {
				ShipSummary shipSummary = new ShipSummary();
				shipSummary.setVer(o.getString("tout1_ver"));
				shipSummary.setRlse_dt(o.getString("tout1_rlse_dt"));
				shipSummary.setType(o.getString("tout1_type"));
				shipSummary.setPlandt(o.getString("tout1_plandt_fr") + "~" + o.getString("tout1_plandt_to"));
				shipSummary.setImport_dt(o.getString("tout1_import_dt") + " "+  o.getString("tout1_import_tm"));
				ediList.add(shipSummary);
			}
		}
		return ediList;
	}
	
	
	
	public static List<ShipDetail> ConvertToShipDetail(List<ProDataObject> proDataObjectList) {
		
		List<ShipDetail> shipDetailList = new ArrayList<ShipDetail>();		
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			
			for (ProDataObject o : proDataObjectList) {
				ShipDetail shipDetail = new ShipDetail();
				shipDetail.setPart(o.getString("tout3_part"));
				shipDetail.setDesc(o.getString("tout3_desc"));
				shipDetail.setFord_part(o.getString("tout3_ford_part"));
				shipDetail.setRec_palnt(o.getString("tout3_rec_plant"));
				shipDetail.setShip_fr(o.getString("tout3_ship_fr"));
				shipDetail.setPlan_qty(o.getBigDecimal("tout3_plan_qty"));
				shipDetail.setCum_ship(o.getBigDecimal("tout3_cum_ship"));
				shipDetail.setUm(o.getString("tout3_um"));
				shipDetail.setPurpose(o.getString("tout3_purpose"));
				shipDetail.setGw(o.getBigDecimal("tout3_unit_gw"));
				shipDetail.setNw(o.getBigDecimal("tout3_unit_nw"));
				shipDetail.setWt_um(o.getString("tout3_wt_um"));
				shipDetail.setPackage_type(o.getString("tout3_package_type"));
				shipDetail.setId(o.getInt("tout3_lading_qty"));
				shipDetail.setCarrier(o.getString("tout3_carrier"));
				shipDetail.setTrans_mthd(o.getString("tout3_trans_mthd"));
				shipDetail.setPur_order(o.getString("tout3_pur_order"));
				shipDetail.setEquip(o.getString("tout3_equip"));
				shipDetail.setNbr(o.getString("tout3_nbr"));
				shipDetail.setLn(o.getString("tout3_ln"));
				shipDetail.setSite(o.getString("tout3_site"));
				shipDetail.setLoc(o.getString("tout3_loc"));
				shipDetailList.add(shipDetail);
						
			}
		}
		return shipDetailList;

	}

	
	
}
