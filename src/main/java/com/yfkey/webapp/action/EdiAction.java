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

	public  List<EdiDetail> getEdiDetails() {
		return ediDetails;
	}

	public  void setEdiDetails(List<EdiDetail> ediDetails) {
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

				setEdiAndDetail();
				
				edi = new Edi();
				edi.setVer(ver);
//				ediDetails = new ArrayList<EdiDetail>();
//
//				if (ConnectQAD()) {
//					ProDataGraph exDataGraph;
//					ProDataGraphHolder outputData = new ProDataGraphHolder();
//
//					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xasndet_DSMetaData1());
//
//					ProDataObject object = exDataGraph.createProDataObject("tt_xasndet_in");
//
//					object.setString(0, ver);
//
//					exDataGraph.addProDataObject(object);
//
//					yfkssScp.xxview_xasndet(exDataGraph, outputData);
//
//					@SuppressWarnings("unchecked")
//					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
//							.getProDataObjects("tt_xasndet_out");
//					if (outDataList != null && outDataList.size() > 0) {
//						edi.setVer(ver);
//						ediDetails = QADUtil.ConvertToEdiDetail(outDataList);
//					}
//				}
//			} else {
//				edi = new Edi();
//				ediDetails = new ArrayList<EdiDetail>();
			}

		}catch (Exception e) {
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

		query1();
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

		query2();
		return SUCCESS;
	}

	public String cancel() {
		return CANCEL;
	}
	

	public String shipEdit() throws IOException {

		try {

			if (ver == null) {

				if (ConnectQAD()) {

					ProDataGraph exDataGraph;
					ProDataGraphHolder outputData = new ProDataGraphHolder();

					exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxinqury_xpyhddet2_DSMetaData1());

					ProDataObject object = exDataGraph.createProDataObject("tt_xpyhddet_in");

					object.setString(0, ver);
					object.setString(1, plandt_fr);
					object.setString(2, plandt_to);

					exDataGraph.addProDataObject(object);

					yfkssScp.xxinqury_xpyhddet2(exDataGraph, outputData);

					@SuppressWarnings("unchecked")
					List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
							.getProDataObjects("tout3");

					if (shipSummary != null && shipSummary.getHasShipError() != null && shipSummary.getHasShipError()) {
						shipSummary.setHasShipError(false);

						List<ShipDetail> oldShipDetails = QADUtil.ConvertToShipDetail(outDataList);
						for (ShipDetail d : shipDetails) {
							for (ShipDetail o : oldShipDetails) {
								if (o.getPart().equals(d.getPart())) {
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
//						shipSummary.setVer(ver);
//						shipDetails = QADUtil.ConvertToShipDetail(outDataList);
						setShipDetail();
					}
				}
			} else {
//				shipSummary = new ShipSummary();
//				shipDetails = new ArrayList<ShipDetail>();
				setShipDetail();
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

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxcreate_xasndet_DSMetaData1());

				if (shipDetails != null && shipDetails.size() > 0) {
					for (ShipDetail sd : shipDetails) {
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
						object.setBigDecimal(12, sd.getGw());
						object.setBigDecimal(13, sd.getNw());
						object.setString(14, sd.getWt_um());
						object.setString(15, sd.getPackage_type());
						object.setInt(16, sd.getLading_qty());
						object.setString(17, sd.getCarrier());
						object.setString(18, sd.getTrans_mthd());
						object.setString(19, sd.getConv_nbr());
						object.setBigDecimal(20, sd.getUnits_per());
						object.setString(21, sd.getAirport());
						object.setString(22, sd.getPur_order());
						object.setString(23, sd.getEquip());
						object.setString(24, sd.getNbr());
						object.setString(25, sd.getLn());
						object.setString(26,sd.getSite());
					    object.setString(27,sd.getLoc());
					
						exDataGraph.addProDataObject(object);
					}
				}

				yfkssScp.xxcreate_xasndet(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("tout4");

				List<Object> args = new ArrayList<Object>();

				if (outDataList != null && outDataList.size() > 0) {
					ProDataObject p = outDataList.get(0);
					String suc = p.getString("tout4_suc");
					args.add(suc);
				}
				saveMessage(getText("ship.success", args));
			} else {
				shipSummary = new ShipSummary();
			}

		} catch (ShipNotValidException ex) {
			addActionError(ex.getMessage());
			shipSummary.setHasShipError(true);
			shipEdit();
			return INPUT;
		} catch (Exception ex) {
			saveErrorForUnexpectException(ex);
			return INPUT;
		}
		return SUCCESS;
	}

	
	private void query1(){
		edis = new ArrayList<Edi>();
		Edi newEdi = new Edi();
		newEdi.setVer("1001");
		newEdi.setPlandt("2016/04/01~2016/04/30");
		newEdi.setRlse_dt("2016/03/01");
		newEdi.setImport_dt("2016/03/10 08:00:25");
		newEdi.setType("天");
		edis.add(newEdi);
	}
	
	private void query2(){
		shipSummarys = new ArrayList<ShipSummary>();
		ShipSummary newShipSummary = new ShipSummary();
		newShipSummary.setVer("1001");
		newShipSummary.setPlandt("2016/04/01~2016/04/30");
		newShipSummary.setRlse_dt("2016/03/01");
		newShipSummary.setImport_dt("2016/03/10 08:00:25");
		newShipSummary.setType("天");
		shipSummarys.add(newShipSummary);
	}
	
	private void setShipDetail(){
		shipSummary = new ShipSummary();
		shipSummary.setVer(ver);
		
		shipDetails = new ArrayList<ShipDetail>();
		ShipDetail sd1 = new ShipDetail();
		sd1.setId(1001);
		sd1.setPart("10001");
		sd1.setDesc("测试物料1");
		sd1.setFord_part("Ford001");
		sd1.setUm("EA");
		sd1.setPlan_qty(new BigDecimal(100));
		sd1.setCum_ship(new BigDecimal(200));
		shipDetails.add(sd1);
		
		ShipDetail sd2 = new ShipDetail();
		sd1.setId(1002);
		sd2.setPart("10002");
		sd2.setDesc("测试物料2");
		sd2.setFord_part("Ford002");
		sd2.setUm("EA");
		sd2.setPlan_qty(new BigDecimal(200));
		sd2.setCum_ship(new BigDecimal(300));
		shipDetails.add(sd2);
	}
	
	private void setEdiAndDetail(){
		
		 scheduleView = new ScheduleView();
		
		ScheduleHead scheduleHead = new ScheduleHead();
		List<ScheduleBody> scheduleBodyList =  new ArrayList<ScheduleBody>();
		List<Map<String, Object>> headList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> head1 = new HashMap<String, Object>();
		head1.put("scheduleType", "Firm");
		head1.put("dateFrom", "2016-04-10");
		head1.put("dateTo","2016-04-10");
		headList.add(head1);
		
		Map<String, Object> head2 = new HashMap<String, Object>();
		head2.put("scheduleType", "Firm");
		head2.put("dateFrom", "2016-04-11");
		head2.put("dateTo","2016-04-11");
		headList.add(head2);
		
		Map<String, Object> head3 = new HashMap<String, Object>();
		head3.put("scheduleType", "Firm");
		head3.put("dateFrom", "2016-04-13");
		head3.put("dateTo","2016-04-13");
		headList.add(head3);
		
		scheduleHead.setHeadList(headList);
		
		ScheduleBody sb1 = new ScheduleBody();
		sb1.setItemCode("100001");
		sb1.setItemDescription("测试零件号1");
		sb1.setSupplierItemCode("Ford001");
		sb1.setReleaseDate("2016-04-10");
		sb1.setUm("EA");
		List<BigDecimal> planQtyList1 = new ArrayList<BigDecimal>();
		planQtyList1.add(new BigDecimal(101));
		planQtyList1.add(new BigDecimal(102));
		planQtyList1.add(new BigDecimal(103));
		sb1.setPlanQtyList(planQtyList1);
		scheduleBodyList.add(sb1);
		
		ScheduleBody sb2 = new ScheduleBody();
		sb2.setItemCode("100001");
		sb1.setUm("EA");
		sb2.setItemDescription("测试零件号1");
		sb2.setSupplierItemCode("Ford001");
		sb2.setReleaseDate("2016-04-10");
		List<BigDecimal> totalQtyList1 = new ArrayList<BigDecimal>();
		totalQtyList1.add(new BigDecimal(101));
		totalQtyList1.add(new BigDecimal(203));
		totalQtyList1.add(new BigDecimal(306));
		sb2.setTotalQtyList(totalQtyList1);
		scheduleBodyList.add(sb2);
		
		
		ScheduleBody sb3 = new ScheduleBody();
		sb3.setItemCode("100002");
		sb3.setItemDescription("测试零件号2");
		sb3.setSupplierItemCode("Ford002");
		sb3.setReleaseDate("2016-04-11");
		sb1.setUm("EA");
		List<BigDecimal> planQtyList2 = new ArrayList<BigDecimal>();
		planQtyList2.add(new BigDecimal(101));
		planQtyList2.add(new BigDecimal(102));
		planQtyList2.add(new BigDecimal(103));
		sb3.setPlanQtyList(planQtyList2);
		scheduleBodyList.add(sb3);
		
		ScheduleBody sb4 = new ScheduleBody();
		sb4.setItemCode("100002");
		sb4.setItemDescription("测试零件号2");
		sb4.setSupplierItemCode("Ford002");
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

				exDataGraph = new ProDataGraph(yfkssScp.m_YFKSSSCPImpl.getXxview_xasndet_DSMetaData1());

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

				// yfkssScp.xxinqury_xasnmstr(exDataGraph, outputData);

				@SuppressWarnings("unchecked")
				List<ProDataObject> outDataList = (List<ProDataObject>) outputData.getProDataGraphValue()
						.getProDataObjects("???????");

				edis = QADUtil.ConverToEdi(outDataList);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void checkShipQty(List<ShipDetail> shipDetails) throws ShipNotValidException {

		for (ShipDetail d : shipDetails) {
			List<Object> args = new ArrayList<Object>();

			try {
				BigDecimal shipQty = new BigDecimal(d.getShip_qty());

				if (shipQty instanceof BigDecimal == false) {
					args.add(String.valueOf(d.getPart()));
					throw new ShipNotValidException(getText("edi.shipqty_format_error", args));
				}

				if (shipQty.compareTo(BigDecimal.ZERO) < 1) {
					args.add(String.valueOf(d.getPart()));
					throw new ShipNotValidException(getText("edi.shipqty_less_than_zero", args));
				} else if (shipQty.compareTo(d.getPlan_qty()) > 0) {
					args.add(d.getPart());
					throw new ShipNotValidException(getText("edi.planqty_less_than_shipqty", args));

				}
			} catch (NumberFormatException e) {
				args.add(d.getPart());
				throw new ShipNotValidException(getText("edi.shipqty_format_error", args));
			}

		}

	}
	
}
