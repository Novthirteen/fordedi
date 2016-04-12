package com.yfkey.webapp.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.progress.open4gl.ProDataGraph;
import com.progress.open4gl.ProDataGraphHolder;
import com.progress.open4gl.ProDataObject;
import com.yfkey.model.ShipDetail;
import com.yfkey.model.ShipSummary;
import com.yfkey.qad.FordEDIImpl;
import com.yfkey.webapp.util.QADUtil;
import com.yfkey.exception.ShipNotValidException;
import com.yfkey.exception.SupplierAuthorityException;
import com.yfkey.model.Edi;
import com.yfkey.model.EdiDetail;
import com.yfkey.model.ScheduleBody;
import com.yfkey.model.ScheduleHead;
import com.yfkey.model.ScheduleView;

/**
 * Action for facilitating Role Management feature.
 */
public class EdiAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7707143528903966154L;

	private List<Edi> edis;
	private List<ShipSummary> shipSummarys;
	private static List<EdiDetail> ediDetails;
	private List<ShipDetail> shipDetails;
	private Edi edi;
	private ShipSummary shipSummary;
	private String ver;
	private String plandt_fr;
	private String plandt_to;

	private ScheduleView scheduleView;

	public List<Edi> getEdis() {
		return edis;
	}

	public void setEdis(List<Edi> edis) {
		this.edis = edis;
	}

	public List<EdiDetail> getEdiDetails() {
		return ediDetails;
	}

	public void setEdiDetails(List<EdiDetail> ediDetails) {
		EdiAction.ediDetails = ediDetails;
	}

	public Edi getEdi() {
		return edi;
	}

	public void setEdi(Edi edi) {
		this.edi = edi;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
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

	public List<ShipSummary> getShipSummarys() {
		return shipSummarys;
	}

	public void setShipSummarys(List<ShipSummary> shipSummarys) {
		this.shipSummarys = shipSummarys;
	}

	public List<ShipDetail> getShipDetails() {
		return shipDetails;
	}

	public void setShipDetails(List<ShipDetail> shipDetails) {
		this.shipDetails = shipDetails;
	}

	public ShipSummary getShipSummary() {
		return shipSummary;
	}

	public void setShipSummary(ShipSummary shipSummary) {
		this.shipSummary = shipSummary;
	}

	public ScheduleView getScheduleView() {
		return scheduleView;
	}

	public void setScheduleView(ScheduleView scheduleView) {
		this.scheduleView = scheduleView;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws IOException {

		try {

			if (ver != null) {

				// setEdiAndDetail();
				//
				// edi = new Edi();
				// edi.setVer(ver);
				// ediDetails = new ArrayList<EdiDetail>();

				if (ConnectQAD()) {
					ProDataGraph exDataGraph;
					ProDataGraphHolder outputData = new ProDataGraphHolder();

					exDataGraph = new ProDataGraph(yfkssFordEdi.m_FordEDIImpl.getXxediford_plandet_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tin2");

					String domain = getCurrentDomain();
					object.setString(0, domain);
					object.setString(1, ver);

					exDataGraph.addProDataObject(object);

					yfkssFordEdi.xxediford_plandet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tout2");
					if (outDataList != null && outDataList.size() > 0) {
						edi = new Edi();
						edi.setVer(ver);
						scheduleView = QADUtil.ConvertToEdiDetail(outDataList);
					}
				}
			} else {
				edi = new Edi();
				edi.setVer(ver);
				ediDetails = new ArrayList<EdiDetail>();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {

		if (edi == null) {
			edi = new Edi();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			Calendar fca = Calendar.getInstance();
			fca.setTime(date);
			fca.add(Calendar.MONTH, -1);
			String fromDate = sdf.format(fca.getTime());

			Calendar tca = Calendar.getInstance();
			tca.setTime(date);
			String toDate = sdf.format(tca.getTime());

			edi.setPlandt_fr(fromDate);
			edi.setPlandt_to(toDate);
		}

		// autocomplete
		if (edi.getShipto() != null && !edi.getShipto().equals("")) {
			String shipto = edi.getShipto();
			if (shipto.contains("(")) {
				edi.setShipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}

		query();
		return SUCCESS;
	}

	public String shipEdilist() {

		if (shipSummary == null) {
			shipSummary = new ShipSummary();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			Calendar fca = Calendar.getInstance();
			fca.setTime(date);
			fca.add(Calendar.MONTH, -1);
			String fromDate = sdf.format(fca.getTime());

			Calendar tca = Calendar.getInstance();
			tca.setTime(date);
			String toDate = sdf.format(tca.getTime());

			shipSummary.setPlandt_fr(fromDate);
			shipSummary.setPlandt_to(toDate);
		}

		// autocomplete
		if (shipSummary.getShipto() != null && !shipSummary.getShipto().equals("")) {
			String shipto = edi.getShipto();
			if (shipto.contains("(")) {
				shipSummary.setShipto(shipto.substring(0, shipto.indexOf("(")));
			}
		}

		setPlandt_fr(shipSummary.getPlandt_fr());
		setPlandt_to(shipSummary.getPlandt_to());

		shipQuery();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}

	public String shipEdit() throws IOException {

		try {

			if (ver != null) {

				if (ConnectQAD()) {

					ProDataGraph exDataGraph;
					ProDataGraphHolder outputData = new ProDataGraphHolder();

					exDataGraph = new ProDataGraph(yfkssFordEdi.m_FordEDIImpl.getXxediford_shipdet_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tin3");
					String domain = getCurrentDomain();

					object.setString(0, domain);
					object.setString(1, plandt_fr);
					object.setString(2, plandt_to);
					object.setString(3, ver);

					exDataGraph.addProDataObject(object);

					yfkssFordEdi.xxediford_shipdet(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tout3");

					if (shipSummary != null && shipSummary.getHasShipError() != null && shipSummary.getHasShipError()) {
						shipSummary.setHasShipError(false);

						List<ShipDetail> oldShipDetails = QADUtil.ConvertToShipDetail(outDataList);
						for (ShipDetail d : shipDetails) {
							for (ShipDetail o : oldShipDetails) {
								if (o.getPart().equals(d.getPart())) {
									// d.setPart(o.getPart());
									// d.setDesc(o.getDesc());
									// d.setFord_part(o.getFord_part());
									// d.setRec_palnt(o.getRec_palnt());
									// d.setShip_fr(o.getShip_fr());
									// d.setTt_xpyhddeto_seq(o.getTt_xpyhddeto_seq());
									// d.setTt_xpyhddeto_partnbr(o.getTt_xpyhddeto_partnbr());
									// d.setTt_xpyhddeto_partdesc(o.getTt_xpyhddeto_partdesc());
									// d.setTt_xpyhddeto_supppart(o.getTt_xpyhddeto_supppart());
									// d.setTt_xpyhddeto_uom(o.getTt_xpyhddeto_uom());
									// d.setTt_xpyhddeto_spq(o.getTt_xpyhddeto_spq());
									// d.setTt_xpyhddeto_toloc(o.getTt_xpyhddeto_toloc());
									// d.setTt_xpyhddeto_openqty(o.getTt_xpyhddeto_openqty());
									break;
								}
							}
						}
					} else {
						shipSummary = new ShipSummary();
						shipSummary.setVer(ver);
						shipDetails = QADUtil.ConvertToShipDetail(outDataList);

					}
				}
			} else {
				shipSummary = new ShipSummary();
				shipSummary.setVer(ver);
				shipDetails = new ArrayList<ShipDetail>();
				// setShipDetail();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String ship() throws Exception {
		try {
			checkShipQty(shipDetails);
			String domain = getCurrentDomain();
			String userCode = this.getRequest().getRemoteUser();
			if (ConnectQAD()) {

				ProDataGraph exDataGraph; // 杈撳叆鍙傛暟
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 杈撳嚭鍙傛暟

				exDataGraph = new ProDataGraph(yfkssFordEdi.m_FordEDIImpl.getXxediford_shipcon_DSMetaData1());

				if (shipDetails != null && shipDetails.size() > 0) {
					for (ShipDetail sd : shipDetails) {
						if (!sd.getShip_qty().equals("")) {
							ProDataObject object = exDataGraph.createProDataObject("tin4");
							object.setString(0, domain);
							object.setString(1, userCode);
							object.setString(2, sd.getPart());
							object.setString(3, sd.getFord_part());
							object.setString(4, sd.getRec_palnt());
							object.setString(5, sd.getShip_fr());
							object.setBigDecimal(6, new BigDecimal(sd.getShip_qty()));
							object.setBigDecimal(7, sd.getCum_ship());
							object.setString(8, sd.getUm());
							object.setString(9, sd.getShipper());
							object.setString(10, sd.getBl());
							object.setString(11, sd.getPurpose());
							object.setBigDecimal(12, new BigDecimal(sd.getGw()));
							object.setBigDecimal(13, new BigDecimal(sd.getNw()));
							object.setString(14, sd.getWt_um());
							object.setString(15, sd.getPackage_type());
							object.setInt(16, Integer.parseInt(sd.getLading_qty()));
							object.setString(17, sd.getCarrier());
							object.setString(18, sd.getTrans_mthd());
							object.setString(19, sd.getConv_nbr());
							object.setBigDecimal(20, new BigDecimal(sd.getUnits_per()));
							object.setString(21, sd.getAirport());
							object.setString(22, sd.getPur_order());
							object.setString(23, sd.getEquip());
							object.setString(24, sd.getNbr());
							object.setString(25, sd.getLn());
							object.setString(26, sd.getSite());
							object.setString(27, sd.getLoc());
							object.setString(28, shipSummary.getVer());
							exDataGraph.addProDataObject(object);
						}
					}
				}

				yfkssFordEdi.xxediford_shipcon(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tout4");

				// List<Object> args = new ArrayList<Object>();

				// if (outDataList != null && outDataList.size() > 0) {
				// ProDataObject p = outDataList.get(0);
				// String suc = ;
				// args.add(suc);
				// }
				if (outDataList != null && outDataList.size() > 0) {
					ProDataObject p = outDataList.get(0);
					Boolean isSuccess = p.getBoolean("tout4_suc");
					if (isSuccess) {
						saveMessage(getText("edi.ship.success"));
					} else {
						String errorMsg = p.getString("tout4_err");
						throw new ShipNotValidException(errorMsg);
					}
				}
			} else {
				shipSummary = new ShipSummary();
			}

		} catch (ShipNotValidException ex) {
			addActionError(ex.getMessage());
			ver = shipSummary.getVer();
			shipSummary.setHasShipError(true);
			shipEdit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}
		return SUCCESS;
	}

	private void query1() {
		edis = new ArrayList<Edi>();
		Edi newEdi = new Edi();
		newEdi.setVer("1001");
		newEdi.setPlandt("2016/04/01~2016/04/30");
		newEdi.setRlse_dt("2016/03/01");
		newEdi.setImport_dt("2016/03/10 08:00:25");
		newEdi.setType("天");
		edis.add(newEdi);
	}

	private void query2() {
		shipSummarys = new ArrayList<ShipSummary>();
		ShipSummary newShipSummary = new ShipSummary();
		newShipSummary.setVer("1001");
		newShipSummary.setPlandt("2016/04/01~2016/04/30");
		newShipSummary.setRlse_dt("2016/03/01");
		newShipSummary.setImport_dt("2016/03/10 08:00:25");
		newShipSummary.setType("天");
		shipSummarys.add(newShipSummary);
	}

	private void setShipDetail() {
		shipSummary = new ShipSummary();
		shipSummary.setVer(ver);

		shipDetails = new ArrayList<ShipDetail>();
		ShipDetail sd1 = new ShipDetail();
		sd1.setId(1001);
		sd1.setPart("10001");
		sd1.setDesc("测试物料1");
		sd1.setFord_part("Ford001");
		sd1.setUm("EA");
		sd1.setPurpose("05");
		sd1.setPlan_qty(new BigDecimal(100));
		sd1.setCum_ship(new BigDecimal(200));
		shipDetails.add(sd1);

		ShipDetail sd2 = new ShipDetail();
		sd1.setId(1002);
		sd2.setPart("10002");
		sd2.setDesc("测试物料2");
		sd2.setFord_part("Ford002");
		sd2.setUm("EA");
		sd2.setPurpose("12");
		sd2.setPlan_qty(new BigDecimal(200));
		sd2.setCum_ship(new BigDecimal(300));
		shipDetails.add(sd2);
	}

	private void setEdiAndDetail() {

		scheduleView = new ScheduleView();

		ScheduleHead scheduleHead = new ScheduleHead();
		List<ScheduleBody> scheduleBodyList = new ArrayList<ScheduleBody>();
		List<Map<String, Object>> headList = new ArrayList<Map<String, Object>>();

		Map<String, Object> head1 = new HashMap<String, Object>();
		head1.put("scheduleType", "Firm");
		head1.put("dateFrom", "2016-04-10");
		head1.put("dateTo", "2016-04-10");
		headList.add(head1);

		Map<String, Object> head2 = new HashMap<String, Object>();
		head2.put("scheduleType", "Firm");
		head2.put("dateFrom", "2016-04-11");
		head2.put("dateTo", "2016-04-11");
		headList.add(head2);

		Map<String, Object> head3 = new HashMap<String, Object>();
		head3.put("scheduleType", "Firm");
		head3.put("dateFrom", "2016-04-13");
		head3.put("dateTo", "2016-04-13");
		headList.add(head3);

		scheduleHead.setHeadList(headList);

		ScheduleBody sb1 = new ScheduleBody();
		sb1.setPart("100001");
		sb1.setPartDescription("测试零件号1");
		sb1.setFord_part("Ford001");
		sb1.setReleaseDate("2016-04-10");
		sb1.setUm("EA");
		List<BigDecimal> planQtyList1 = new ArrayList<BigDecimal>();
		planQtyList1.add(new BigDecimal(101));
		planQtyList1.add(new BigDecimal(102));
		planQtyList1.add(new BigDecimal(103));
		sb1.setPlanQtyList(planQtyList1);
		scheduleBodyList.add(sb1);

		ScheduleBody sb2 = new ScheduleBody();
		sb2.setPart("100001");
		sb1.setUm("EA");
		sb2.setPartDescription("测试零件号1");
		sb2.setFord_part("Ford001");
		sb2.setReleaseDate("2016-04-10");
		List<BigDecimal> totalQtyList1 = new ArrayList<BigDecimal>();
		totalQtyList1.add(new BigDecimal(101));
		totalQtyList1.add(new BigDecimal(203));
		totalQtyList1.add(new BigDecimal(306));
		sb2.setTotalQtyList(totalQtyList1);
		scheduleBodyList.add(sb2);

		ScheduleBody sb3 = new ScheduleBody();
		sb3.setPart("100002");
		sb3.setPartDescription("测试零件号2");
		sb3.setFord_part("Ford002");
		sb3.setReleaseDate("2016-04-11");
		sb1.setUm("EA");
		List<BigDecimal> planQtyList2 = new ArrayList<BigDecimal>();
		planQtyList2.add(new BigDecimal(101));
		planQtyList2.add(new BigDecimal(102));
		planQtyList2.add(new BigDecimal(103));
		sb3.setPlanQtyList(planQtyList2);
		scheduleBodyList.add(sb3);

		ScheduleBody sb4 = new ScheduleBody();
		sb4.setPart("100002");
		sb4.setPartDescription("测试零件号2");
		sb4.setFord_part("Ford002");
		sb4.setReleaseDate("2016-04-11");
		sb1.setUm("EA");
		List<BigDecimal> totalQtyList2 = new ArrayList<BigDecimal>();
		totalQtyList2.add(new BigDecimal(201));
		totalQtyList2.add(new BigDecimal(303));
		totalQtyList2.add(new BigDecimal(406));
		sb4.setTotalQtyList(totalQtyList2);
		scheduleBodyList.add(sb4);

		scheduleView.setScheduleBodyList(scheduleBodyList);
		scheduleView.setScheduleHead(scheduleHead);

	}

	private void query() {
		try {
			if (ConnectQAD()) {

				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssFordEdi.m_FordEDIImpl.getXxediford_plansum_DSMetaData1());

				ProDataObject objectMstr = exDataGraph.createProDataObject("tin1");
				if (edi != null) {
					objectMstr.setString(0, domain);
					objectMstr.setString(1, edi.getShipto() == null ? "" : edi.getShipto().trim());
					objectMstr.setString(2, edi.getPlandt_fr() == null ? "" : edi.getPlandt_fr().trim());
					objectMstr.setString(3, edi.getPlandt_to() == null ? "" : edi.getPlandt_to().trim());
					objectMstr.setString(4, edi.getImportdt_fr() == null ? "" : edi.getImportdt_fr().trim());
					objectMstr.setString(5, edi.getImportdt_to() == null ? "" : edi.getImportdt_to().trim());

				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssFordEdi.xxediford_plansum(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tout1");

				edis = QADUtil.ConverToEdi(outDataList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void shipQuery() {
		try {
			if (ConnectQAD()) {

				String domain = getCurrentDomain();

				ProDataGraph exDataGraph; // 输入参数
				ProDataGraphHolder outputData = new ProDataGraphHolder(); // 输出参数

				exDataGraph = new ProDataGraph(yfkssFordEdi.m_FordEDIImpl.getXxediford_plansum_DSMetaData1());

				ProDataObject objectMstr = exDataGraph.createProDataObject("tin1");
				if (shipSummary != null) {
					objectMstr.setString(0, domain);
					objectMstr.setString(1, shipSummary.getShipto() == null ? "" : shipSummary.getShipto().trim());
					objectMstr.setString(2,
							shipSummary.getPlandt_fr() == null ? "" : shipSummary.getPlandt_fr().trim());
					objectMstr.setString(3,
							shipSummary.getPlandt_to() == null ? "" : shipSummary.getPlandt_to().trim());
					objectMstr.setString(4,
							shipSummary.getImportdt_fr() == null ? "" : shipSummary.getImportdt_fr().trim());
					objectMstr.setString(5,
							shipSummary.getImportdt_to() == null ? "" : shipSummary.getImportdt_to().trim());

				}

				exDataGraph.addProDataObject(objectMstr);

				yfkssFordEdi.xxediford_plansum(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tout1");

				shipSummarys = QADUtil.ConverToShipSummary(outDataList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void checkShipQty(List<ShipDetail> shipDetails) throws ShipNotValidException {

		Boolean allZero = true;
		for (ShipDetail d : shipDetails) {
			if (!d.getShip_qty().equals("")) {
				List<Object> args = new ArrayList<Object>();

				try {

					if (d.getUm().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.um_empty_error", args));
					}

					if (d.getShipper().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.shipper_empty_error", args));
					}

					if (d.getBl().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.bl_empty_error", args));
					}

					if (d.getPackage_type().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.package_type_empty_error", args));
					}

					if (d.getTrans_mthd().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.trans_method_empty_error", args));
					}
					if (d.getConv_nbr().equals("") ) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.conv_nbr_empty_error", args));
					}

					if (d.getGw().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.gw_empty", args));
					}
					try {
						BigDecimal gw = new BigDecimal(d.getGw());

						if (gw instanceof BigDecimal == false) {
							args.add(String.valueOf(d.getPart()));
							throw new ShipNotValidException(getText("edi.gw_format_error", args));
						}
						if (gw.compareTo(BigDecimal.ZERO) < 1) {
							args.add(String.valueOf(d.getPart()));
							throw new ShipNotValidException(getText("edi.gw_less_than_zero", args));
						}

					} catch (NumberFormatException e) {
						args.add(d.getPart());
						throw new ShipNotValidException(getText("edi.gw_format_error", args));
					}

					if (d.getNw().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.nw_empty", args));
					}

					try {
						BigDecimal nw = new BigDecimal(d.getNw());
						if (nw instanceof BigDecimal == false) {
							args.add(String.valueOf(d.getPart()));
							throw new ShipNotValidException(getText("edi.nw_format_error", args));
						}
						if (nw.compareTo(BigDecimal.ZERO) < 1) {
							args.add(String.valueOf(d.getPart()));
							throw new ShipNotValidException(getText("edi.nw_less_than_zero", args));
						}
					} catch (NumberFormatException e) {
						args.add(d.getPart());
						throw new ShipNotValidException(getText("edi.nw_format_error", args));
					}

					if (d.getUnits_per().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.units_per_empty", args));
					}
					try{
					BigDecimal units_per = new BigDecimal(d.getUnits_per());
					if (units_per instanceof BigDecimal == false) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.units_per_format_error", args));
					}
					if (units_per.compareTo(BigDecimal.ZERO) < 1) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.units_per_less_than_zero", args));
					}
					} catch (NumberFormatException e) {
						args.add(d.getPart());
						throw new ShipNotValidException(getText("edi.units_per_format_error", args));
					}


					if (d.getLading_qty().equals("")) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.lading_qty_empty", args));
					}
					try{
					Integer ladingQty = Integer.parseInt(d.getLading_qty());
					if (ladingQty instanceof Integer == false) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.lading_qty_format_error", args));
					}
					if (ladingQty <= 0) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.lading_qty_less_than_zero", args));
					}
					}catch (NumberFormatException e) {
						args.add(d.getPart());
						throw new ShipNotValidException(getText("edi.lading_qty_format_error", args));
					}


					BigDecimal shipQty = new BigDecimal(d.getShip_qty());
					if (shipQty instanceof BigDecimal == false) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.shipqty_format_error", args));
					}

					if (shipQty.compareTo(BigDecimal.ZERO) < 1) {
						args.add(String.valueOf(d.getPart()));
						throw new ShipNotValidException(getText("edi.shipqty_less_than_zero", args));
					}
					// else if (shipQty.compareTo(d.getPlan_qty()) > 0) {
					// args.add(d.getPart());
					// throw new
					// ShipNotValidException(getText("edi.planqty_less_than_shipqty",
					// args));
					//
					// }
					if (shipQty.compareTo(BigDecimal.ZERO) >= 1 && allZero) {
						allZero = false;
					}

				} catch (NumberFormatException e) {
					args.add(d.getPart());
					throw new ShipNotValidException(getText("edi.qty_format_error", args));
				}
			}
		}

		if (allZero) {
			throw new ShipNotValidException(getText("edi.qty_all_empty"));
		}
	}

}
