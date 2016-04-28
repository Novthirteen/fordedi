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
				edi.setImport_dt(o.getString("tout1_import_dt") + " " + o.getString("tout1_import_tm"));
				edi.setKey(o.getString("tout1_ver_tp"));
				ediList.add(edi);
			}
		}
		return ediList;
	}

	public static ScheduleView ConvertToEdiDetail(List<ProDataObject> proDataObjectList) {

		ScheduleView scheduleView = new ScheduleView();
		List<String> dateList = new ArrayList<String>();
		List<String> ford_partList = new ArrayList<String>();
		ScheduleHead scheduleHead = new ScheduleHead();
		List<ScheduleBody> scheduleBodyList = new ArrayList<ScheduleBody>();
		List<Map<String, Object>> headList = new ArrayList<Map<String, Object>>();

		if (proDataObjectList != null && proDataObjectList.size() > 0) {

			for (ProDataObject o : proDataObjectList) {
				String ford_part = o.getString("tout2_ford_part");
				String plan_dt = o.getString("tout2_plan_dt");
				if (!dateList.contains(plan_dt)) {
					dateList.add(plan_dt);
				}
				if (!ford_partList.contains(ford_part)) {
					ford_partList.add(ford_part);
				}
			}

			Collections.sort(dateList);
			Collections.sort(ford_partList);
			for (String d : dateList) {
				Map<String, Object> head = new HashMap<String, Object>();
				head.put("scheduleType", "Firm");
				head.put("dateFrom", d);
				head.put("dateTo", d);
				headList.add(head);
			}

			for (String p : ford_partList) {

				List<BigDecimal> planQtyList = new ArrayList<BigDecimal>();
				List<BigDecimal> totalQtyList = new ArrayList<BigDecimal>();
				String desc = "";
				String part = "";
				String rlse_dt = "";
				String um = "";
				for (String d : dateList) {
					for (ProDataObject o : proDataObjectList) {
						String ford_part = o.getString("tout2_ford_part");
						String plan_dt = o.getString("tout2_plan_dt");

						if (p.equals(ford_part) && d.equals(plan_dt)) {
							desc = o.getString("tout2_desc");
							part = o.getString("tout2_part");
							rlse_dt = o.getString("tout2_rlse_dt");
							um = o.getString("tout2_um");
							BigDecimal planQty = o.getBigDecimal("tout2_plan_qty");
							BigDecimal totalQty = o.getBigDecimal("tout2_cum_ship");
							planQtyList.add(planQty);
							totalQtyList.add(totalQty);
							break;
						}
					}
				}
					ScheduleBody sb1 = new ScheduleBody();
					sb1.setPart(part);
					sb1.setPartDescription(desc);
					sb1.setFord_part(p);
					sb1.setReleaseDate(rlse_dt);
					sb1.setUm(um);
					sb1.setPlanQtyList(planQtyList);
					scheduleBodyList.add(sb1);

					ScheduleBody sb2 = new ScheduleBody();
					sb2.setPart(part);
					sb2.setPartDescription(desc);
					sb2.setFord_part(p);
					sb2.setReleaseDate(rlse_dt);
					sb2.setUm(um);
					sb2.setTotalQtyList(totalQtyList);
					scheduleBodyList.add(sb2);
				}
			

			scheduleHead.setHeadList(headList);
			scheduleView.setScheduleHead(scheduleHead);
			scheduleView.setScheduleBodyList(scheduleBodyList);

		}
		return scheduleView;

	}

	public static List<ShipSummary> ConverToShipSummary(List<ProDataObject> proDataObjectList) {

		List<ShipSummary> ediList = new ArrayList<ShipSummary>();
		if (proDataObjectList != null && proDataObjectList.size() > 0) {
			for (ProDataObject o : proDataObjectList) {
				ShipSummary shipSummary = new ShipSummary();
				shipSummary.setVer(o.getString("tout5_ver"));
				shipSummary.setRlse_dt(o.getString("tout5_rlse_dt"));
				shipSummary.setType(o.getString("tout5_type"));
				shipSummary.setPlandt(o.getString("tout5_plandt_fr") + "~" + o.getString("tout5_plandt_to"));
				shipSummary.setImport_dt(o.getString("tout5_import_dt") + " " + o.getString("tout5_import_tm"));
				shipSummary.setKey(o.getString("tout5_ver_tp"));
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
				shipDetail.setUnit_gw(o.getBigDecimal("tout3_unit_gw"));
				shipDetail.setUnit_nw(o.getBigDecimal("tout3_unit_nw"));
				shipDetail.setWt_um(o.getString("tout3_wt_um"));
				shipDetail.setPackage_type(o.getString("tout3_package_type"));
				shipDetail.setId(o.getInt("tout3_lading_qty"));
				shipDetail.setCarrier(o.getString("tout3_carrier"));
				shipDetail.setTrans_mthd(o.getString("tout3_trans_mthd"));
				shipDetail.setUnits_per(o.getBigDecimal("tout3_units_per").toString());
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
