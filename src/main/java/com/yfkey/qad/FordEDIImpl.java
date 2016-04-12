package com.yfkey.qad;

import com.progress.open4gl.dynamicapi.*;
import com.progress.open4gl.javaproxy.*;
import com.progress.open4gl.*;
import com.progress.common.ehnlog.IAppLogger;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.sql.ResultSet;

//
// FordEDI
//
public final class FordEDIImpl extends AppObject
{

    // Create a MetaData object for each temp-table parm used in any and all methods.
    // Create a Schema object for each method call that has temp-table parms which
    // points to one or more temp-tables used in that method call.


	static ProDataGraphMetaData xxediford_plandet_DSMetaData1;

	static ProDataObjectMetaData xxediford_plandet_MetaData11;

	static ProDataGraphMetaData xxediford_plandet_DSMetaData2;

	static ProDataObjectMetaData xxediford_plandet_MetaData21;


	
	static
	{
		xxediford_plandet_DSMetaData1 = new ProDataGraphMetaData(0, "input_param", 1, ParameterSet.INPUT);
		xxediford_plandet_MetaData11 = new ProDataObjectMetaData("tin2", 2, false, 0, null, null, null);
		xxediford_plandet_MetaData11.setFieldDesc(1, "tin2_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_plandet_MetaData11.setFieldDesc(2, "tin2_ver", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_plandet_DSMetaData1.addTable(xxediford_plandet_MetaData11);
		xxediford_plandet_DSMetaData2 = new ProDataGraphMetaData(0, "export_param", 2, ParameterSet.OUTPUT);
		xxediford_plandet_MetaData21 = new ProDataObjectMetaData("tout2", 8, false, 1, "0,tout2_part,tout2_plan_dt:tout2", null, null);
		xxediford_plandet_MetaData21.setFieldDesc(1, "tout2_rlse_dt", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_plandet_MetaData21.setFieldDesc(2, "tout2_part", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_plandet_MetaData21.setFieldDesc(3, "tout2_desc", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_plandet_MetaData21.setFieldDesc(4, "tout2_ford_part", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_plandet_MetaData21.setFieldDesc(5, "tout2_um", 0, Parameter.PRO_CHARACTER,4,0);
		xxediford_plandet_MetaData21.setFieldDesc(6, "tout2_plan_dt", 0, Parameter.PRO_CHARACTER,5,0);
		xxediford_plandet_MetaData21.setFieldDesc(7, "tout2_plan_qty", 0, Parameter.PRO_DECIMAL,6,0);
		xxediford_plandet_MetaData21.setFieldDesc(8, "tout2_cum_ship", 0, Parameter.PRO_DECIMAL,7,0);
		xxediford_plandet_DSMetaData2.addTable(xxediford_plandet_MetaData21);

	}

	static ProDataGraphMetaData xxediford_plansum_DSMetaData1;

	static ProDataObjectMetaData xxediford_plansum_MetaData11;

	static ProDataGraphMetaData xxediford_plansum_DSMetaData2;

	static ProDataObjectMetaData xxediford_plansum_MetaData21;


	static
	{
		xxediford_plansum_DSMetaData1 = new ProDataGraphMetaData(0, "input_param", 1, ParameterSet.INPUT);
		xxediford_plansum_MetaData11 = new ProDataObjectMetaData("tin1", 6, false, 0, null, null, null);
		xxediford_plansum_MetaData11.setFieldDesc(1, "tin1_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_plansum_MetaData11.setFieldDesc(2, "tin1_shipto", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_plansum_MetaData11.setFieldDesc(3, "tin1_plandt_fr", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_plansum_MetaData11.setFieldDesc(4, "tin1_plandt_to", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_plansum_MetaData11.setFieldDesc(5, "tin1_importdt_fr", 0, Parameter.PRO_CHARACTER,4,0);
		xxediford_plansum_MetaData11.setFieldDesc(6, "tin1_importdt_to", 0, Parameter.PRO_CHARACTER,5,0);
		xxediford_plansum_DSMetaData1.addTable(xxediford_plansum_MetaData11);
		xxediford_plansum_DSMetaData2 = new ProDataGraphMetaData(0, "export_param", 2, ParameterSet.OUTPUT);
		xxediford_plansum_MetaData21 = new ProDataObjectMetaData("tout1", 7, false, 1, "0,tout1_ver:tout1", null, null);
		xxediford_plansum_MetaData21.setFieldDesc(1, "tout1_ver", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_plansum_MetaData21.setFieldDesc(2, "tout1_rlse_dt", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_plansum_MetaData21.setFieldDesc(3, "tout1_type", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_plansum_MetaData21.setFieldDesc(4, "tout1_plandt_fr", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_plansum_MetaData21.setFieldDesc(5, "tout1_plandt_to", 0, Parameter.PRO_CHARACTER,4,0);
		xxediford_plansum_MetaData21.setFieldDesc(6, "tout1_import_dt", 0, Parameter.PRO_CHARACTER,5,0);
		xxediford_plansum_MetaData21.setFieldDesc(7, "tout1_import_tm", 0, Parameter.PRO_CHARACTER,6,0);
		xxediford_plansum_DSMetaData2.addTable(xxediford_plansum_MetaData21);

	}

	static ProDataGraphMetaData xxediford_shipcon_DSMetaData1;

	static ProDataObjectMetaData xxediford_shipcon_MetaData11;

	static ProDataGraphMetaData xxediford_shipcon_DSMetaData2;

	static ProDataObjectMetaData xxediford_shipcon_MetaData21;


	static
	{
		xxediford_shipcon_DSMetaData1 = new ProDataGraphMetaData(0, "input_param", 1, ParameterSet.INPUT);
		xxediford_shipcon_MetaData11 = new ProDataObjectMetaData("tin4", 29, false, 1, "0,tin4_part:tin4_part", null, null);
		xxediford_shipcon_MetaData11.setFieldDesc(1, "tin4_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_shipcon_MetaData11.setFieldDesc(2, "tin4_user", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_shipcon_MetaData11.setFieldDesc(3, "tin4_part", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_shipcon_MetaData11.setFieldDesc(4, "tin4_ford_part", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_shipcon_MetaData11.setFieldDesc(5, "tin4_rec_plant", 0, Parameter.PRO_CHARACTER,4,0);
		xxediford_shipcon_MetaData11.setFieldDesc(6, "tin4_ship_fr", 0, Parameter.PRO_CHARACTER,5,0);
		xxediford_shipcon_MetaData11.setFieldDesc(7, "tin4_ship_qty", 0, Parameter.PRO_DECIMAL,6,0);
		xxediford_shipcon_MetaData11.setFieldDesc(8, "tin4_cum_ship", 0, Parameter.PRO_DECIMAL,7,0);
		xxediford_shipcon_MetaData11.setFieldDesc(9, "tin4_um", 0, Parameter.PRO_CHARACTER,8,0);
		xxediford_shipcon_MetaData11.setFieldDesc(10, "tin4_shipper", 0, Parameter.PRO_CHARACTER,9,0);
		xxediford_shipcon_MetaData11.setFieldDesc(11, "tin4_bl", 0, Parameter.PRO_CHARACTER,10,0);
		xxediford_shipcon_MetaData11.setFieldDesc(12, "tin4_purpose", 0, Parameter.PRO_CHARACTER,11,0);
		xxediford_shipcon_MetaData11.setFieldDesc(13, "tin4_gw", 0, Parameter.PRO_DECIMAL,12,0);
		xxediford_shipcon_MetaData11.setFieldDesc(14, "tin4_nw", 0, Parameter.PRO_DECIMAL,13,0);
		xxediford_shipcon_MetaData11.setFieldDesc(15, "tin4_wt_um", 0, Parameter.PRO_CHARACTER,14,0);
		xxediford_shipcon_MetaData11.setFieldDesc(16, "tin4_package_type", 0, Parameter.PRO_CHARACTER,15,0);
		xxediford_shipcon_MetaData11.setFieldDesc(17, "tin4_lading_qty", 0, Parameter.PRO_INTEGER,16,0);
		xxediford_shipcon_MetaData11.setFieldDesc(18, "tin4_carrier", 0, Parameter.PRO_CHARACTER,17,0);
		xxediford_shipcon_MetaData11.setFieldDesc(19, "tin4_trans_mthd", 0, Parameter.PRO_CHARACTER,18,0);
		xxediford_shipcon_MetaData11.setFieldDesc(20, "tin4_conv_nbr", 0, Parameter.PRO_CHARACTER,19,0);
		xxediford_shipcon_MetaData11.setFieldDesc(21, "tin4_units_per", 0, Parameter.PRO_DECIMAL,20,0);
		xxediford_shipcon_MetaData11.setFieldDesc(22, "tin4_airport", 0, Parameter.PRO_CHARACTER,21,0);
		xxediford_shipcon_MetaData11.setFieldDesc(23, "tin4_pur_order", 0, Parameter.PRO_CHARACTER,22,0);
		xxediford_shipcon_MetaData11.setFieldDesc(24, "tin4_equip", 0, Parameter.PRO_CHARACTER,23,0);
		xxediford_shipcon_MetaData11.setFieldDesc(25, "tin4_nbr", 0, Parameter.PRO_CHARACTER,24,0);
		xxediford_shipcon_MetaData11.setFieldDesc(26, "tin4_ln", 0, Parameter.PRO_INTEGER,25,0);
		xxediford_shipcon_MetaData11.setFieldDesc(27, "tin4_site", 0, Parameter.PRO_CHARACTER,26,0);
		xxediford_shipcon_MetaData11.setFieldDesc(28, "tin4_loc", 0, Parameter.PRO_CHARACTER,27,0);
		xxediford_shipcon_MetaData11.setFieldDesc(29, "tin4_ver", 0, Parameter.PRO_CHARACTER,28,0);
		xxediford_shipcon_DSMetaData1.addTable(xxediford_shipcon_MetaData11);
		xxediford_shipcon_DSMetaData2 = new ProDataGraphMetaData(0, "export_param", 2, ParameterSet.OUTPUT);
		xxediford_shipcon_MetaData21 = new ProDataObjectMetaData("tout4", 2, false, 0, null, null, null);
		xxediford_shipcon_MetaData21.setFieldDesc(1, "tout4_suc", 0, Parameter.PRO_LOGICAL,0,0);
		xxediford_shipcon_MetaData21.setFieldDesc(2, "tout4_err", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_shipcon_DSMetaData2.addTable(xxediford_shipcon_MetaData21);

	}

	static ProDataGraphMetaData xxediford_shipdet_DSMetaData1;

	static ProDataObjectMetaData xxediford_shipdet_MetaData11;

	static ProDataGraphMetaData xxediford_shipdet_DSMetaData2;

	static ProDataObjectMetaData xxediford_shipdet_MetaData21;


	static
	{
		xxediford_shipdet_DSMetaData1 = new ProDataGraphMetaData(0, "input_param", 1, ParameterSet.INPUT);
		xxediford_shipdet_MetaData11 = new ProDataObjectMetaData("tin3", 4, false, 0, null, null, null);
		xxediford_shipdet_MetaData11.setFieldDesc(1, "tin3_domain", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_shipdet_MetaData11.setFieldDesc(2, "tin3_plandt_fr", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_shipdet_MetaData11.setFieldDesc(3, "tin3_plandt_to", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_shipdet_MetaData11.setFieldDesc(4, "tin3_ver", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_shipdet_DSMetaData1.addTable(xxediford_shipdet_MetaData11);
		xxediford_shipdet_DSMetaData2 = new ProDataGraphMetaData(0, "export_param", 2, ParameterSet.OUTPUT);
		xxediford_shipdet_MetaData21 = new ProDataObjectMetaData("tout3", 23, false, 1, "0,tout3_ford_part:tout3", null, null);
		xxediford_shipdet_MetaData21.setFieldDesc(1, "tout3_part", 0, Parameter.PRO_CHARACTER,0,0);
		xxediford_shipdet_MetaData21.setFieldDesc(2, "tout3_desc", 0, Parameter.PRO_CHARACTER,1,0);
		xxediford_shipdet_MetaData21.setFieldDesc(3, "tout3_ford_part", 0, Parameter.PRO_CHARACTER,2,0);
		xxediford_shipdet_MetaData21.setFieldDesc(4, "tout3_rec_plant", 0, Parameter.PRO_CHARACTER,3,0);
		xxediford_shipdet_MetaData21.setFieldDesc(5, "tout3_ship_fr", 0, Parameter.PRO_CHARACTER,4,0);
		xxediford_shipdet_MetaData21.setFieldDesc(6, "tout3_plan_qty", 0, Parameter.PRO_DECIMAL,5,0);
		xxediford_shipdet_MetaData21.setFieldDesc(7, "tout3_cum_ship", 0, Parameter.PRO_DECIMAL,6,0);
		xxediford_shipdet_MetaData21.setFieldDesc(8, "tout3_um", 0, Parameter.PRO_CHARACTER,7,0);
		xxediford_shipdet_MetaData21.setFieldDesc(9, "tout3_purpose", 0, Parameter.PRO_CHARACTER,8,0);
		xxediford_shipdet_MetaData21.setFieldDesc(10, "tout3_unit_gw", 0, Parameter.PRO_DECIMAL,9,0);
		xxediford_shipdet_MetaData21.setFieldDesc(11, "tout3_unit_nw", 0, Parameter.PRO_DECIMAL,10,0);
		xxediford_shipdet_MetaData21.setFieldDesc(12, "tout3_wt_um", 0, Parameter.PRO_CHARACTER,11,0);
		xxediford_shipdet_MetaData21.setFieldDesc(13, "tout3_package_type", 0, Parameter.PRO_CHARACTER,12,0);
		xxediford_shipdet_MetaData21.setFieldDesc(14, "tout3_lading_qty", 0, Parameter.PRO_INTEGER,13,0);
		xxediford_shipdet_MetaData21.setFieldDesc(15, "tout3_carrier", 0, Parameter.PRO_CHARACTER,14,0);
		xxediford_shipdet_MetaData21.setFieldDesc(16, "tout3_trans_mthd", 0, Parameter.PRO_CHARACTER,15,0);
		xxediford_shipdet_MetaData21.setFieldDesc(17, "tout3_units_per", 0, Parameter.PRO_DECIMAL,16,0);
		xxediford_shipdet_MetaData21.setFieldDesc(18, "tout3_pur_order", 0, Parameter.PRO_CHARACTER,17,0);
		xxediford_shipdet_MetaData21.setFieldDesc(19, "tout3_equip", 0, Parameter.PRO_CHARACTER,18,0);
		xxediford_shipdet_MetaData21.setFieldDesc(20, "tout3_nbr", 0, Parameter.PRO_CHARACTER,19,0);
		xxediford_shipdet_MetaData21.setFieldDesc(21, "tout3_ln", 0, Parameter.PRO_INTEGER,20,0);
		xxediford_shipdet_MetaData21.setFieldDesc(22, "tout3_site", 0, Parameter.PRO_CHARACTER,21,0);
		xxediford_shipdet_MetaData21.setFieldDesc(23, "tout3_loc", 0, Parameter.PRO_CHARACTER,22,0);
		xxediford_shipdet_DSMetaData2.addTable(xxediford_shipdet_MetaData21);

	}

	
	

    //---- Constructor

    public static ProDataGraphMetaData getXxediford_plandet_DSMetaData1() {
		return xxediford_plandet_DSMetaData1;
	}


	public static void setXxediford_plandet_DSMetaData1(ProDataGraphMetaData xxediford_plandet_DSMetaData1) {
		FordEDIImpl.xxediford_plandet_DSMetaData1 = xxediford_plandet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxediford_plandet_MetaData11() {
		return xxediford_plandet_MetaData11;
	}


	public static void setXxediford_plandet_MetaData11(ProDataObjectMetaData xxediford_plandet_MetaData11) {
		FordEDIImpl.xxediford_plandet_MetaData11 = xxediford_plandet_MetaData11;
	}


	public static ProDataGraphMetaData getXxediford_plandet_DSMetaData2() {
		return xxediford_plandet_DSMetaData2;
	}


	public static void setXxediford_plandet_DSMetaData2(ProDataGraphMetaData xxediford_plandet_DSMetaData2) {
		FordEDIImpl.xxediford_plandet_DSMetaData2 = xxediford_plandet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxediford_plandet_MetaData21() {
		return xxediford_plandet_MetaData21;
	}


	public static void setXxediford_plandet_MetaData21(ProDataObjectMetaData xxediford_plandet_MetaData21) {
		FordEDIImpl.xxediford_plandet_MetaData21 = xxediford_plandet_MetaData21;
	}


	public static ProDataGraphMetaData getXxediford_plansum_DSMetaData1() {
		return xxediford_plansum_DSMetaData1;
	}


	public static void setXxediford_plansum_DSMetaData1(ProDataGraphMetaData xxediford_plansum_DSMetaData1) {
		FordEDIImpl.xxediford_plansum_DSMetaData1 = xxediford_plansum_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxediford_plansum_MetaData11() {
		return xxediford_plansum_MetaData11;
	}


	public static void setXxediford_plansum_MetaData11(ProDataObjectMetaData xxediford_plansum_MetaData11) {
		FordEDIImpl.xxediford_plansum_MetaData11 = xxediford_plansum_MetaData11;
	}


	public static ProDataGraphMetaData getXxediford_plansum_DSMetaData2() {
		return xxediford_plansum_DSMetaData2;
	}


	public static void setXxediford_plansum_DSMetaData2(ProDataGraphMetaData xxediford_plansum_DSMetaData2) {
		FordEDIImpl.xxediford_plansum_DSMetaData2 = xxediford_plansum_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxediford_plansum_MetaData21() {
		return xxediford_plansum_MetaData21;
	}


	public static void setXxediford_plansum_MetaData21(ProDataObjectMetaData xxediford_plansum_MetaData21) {
		FordEDIImpl.xxediford_plansum_MetaData21 = xxediford_plansum_MetaData21;
	}


	public static ProDataGraphMetaData getXxediford_shipcon_DSMetaData1() {
		return xxediford_shipcon_DSMetaData1;
	}


	public static void setXxediford_shipcon_DSMetaData1(ProDataGraphMetaData xxediford_shipcon_DSMetaData1) {
		FordEDIImpl.xxediford_shipcon_DSMetaData1 = xxediford_shipcon_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxediford_shipcon_MetaData11() {
		return xxediford_shipcon_MetaData11;
	}


	public static void setXxediford_shipcon_MetaData11(ProDataObjectMetaData xxediford_shipcon_MetaData11) {
		FordEDIImpl.xxediford_shipcon_MetaData11 = xxediford_shipcon_MetaData11;
	}


	public static ProDataGraphMetaData getXxediford_shipcon_DSMetaData2() {
		return xxediford_shipcon_DSMetaData2;
	}


	public static void setXxediford_shipcon_DSMetaData2(ProDataGraphMetaData xxediford_shipcon_DSMetaData2) {
		FordEDIImpl.xxediford_shipcon_DSMetaData2 = xxediford_shipcon_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxediford_shipcon_MetaData21() {
		return xxediford_shipcon_MetaData21;
	}


	public static void setXxediford_shipcon_MetaData21(ProDataObjectMetaData xxediford_shipcon_MetaData21) {
		FordEDIImpl.xxediford_shipcon_MetaData21 = xxediford_shipcon_MetaData21;
	}


	public static ProDataGraphMetaData getXxediford_shipdet_DSMetaData1() {
		return xxediford_shipdet_DSMetaData1;
	}


	public static void setXxediford_shipdet_DSMetaData1(ProDataGraphMetaData xxediford_shipdet_DSMetaData1) {
		FordEDIImpl.xxediford_shipdet_DSMetaData1 = xxediford_shipdet_DSMetaData1;
	}


	public static ProDataObjectMetaData getXxediford_shipdet_MetaData11() {
		return xxediford_shipdet_MetaData11;
	}


	public static void setXxediford_shipdet_MetaData11(ProDataObjectMetaData xxediford_shipdet_MetaData11) {
		FordEDIImpl.xxediford_shipdet_MetaData11 = xxediford_shipdet_MetaData11;
	}


	public static ProDataGraphMetaData getXxediford_shipdet_DSMetaData2() {
		return xxediford_shipdet_DSMetaData2;
	}


	public static void setXxediford_shipdet_DSMetaData2(ProDataGraphMetaData xxediford_shipdet_DSMetaData2) {
		FordEDIImpl.xxediford_shipdet_DSMetaData2 = xxediford_shipdet_DSMetaData2;
	}


	public static ProDataObjectMetaData getXxediford_shipdet_MetaData21() {
		return xxediford_shipdet_MetaData21;
	}


	public static void setXxediford_shipdet_MetaData21(ProDataObjectMetaData xxediford_shipdet_MetaData21) {
		FordEDIImpl.xxediford_shipdet_MetaData21 = xxediford_shipdet_MetaData21;
	}


	public FordEDIImpl(String     appName,
                            IPoolProps props,
                            IAppLogger log)
        throws Open4GLException, ConnectException, SystemErrorException
    {
        super(appName,
              props,
              log,
              null);
    }


	/* 
	*/
	public String xxediford_plandet(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_param, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxediford_plandet_MetaSchema = new MetaSchema();
		xxediford_plandet_MetaSchema.addProDataGraphSchema(xxediford_plandet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxediford_plandet_MetaSchema.addProDataGraphSchema(xxediford_plandet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxediford_plandet.p", params, xxediford_plandet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_param.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxediford_plansum(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_param, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxediford_plansum_MetaSchema = new MetaSchema();
		xxediford_plansum_MetaSchema.addProDataGraphSchema(xxediford_plansum_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxediford_plansum_MetaSchema.addProDataGraphSchema(xxediford_plansum_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxediford_plansum.p", params, xxediford_plansum_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_param.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxediford_shipcon(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_param, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxediford_shipcon_MetaSchema = new MetaSchema();
		xxediford_shipcon_MetaSchema.addProDataGraphSchema(xxediford_shipcon_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxediford_shipcon_MetaSchema.addProDataGraphSchema(xxediford_shipcon_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxediford_shipcon.p", params, xxediford_shipcon_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_param.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}

	/* 
	*/
	public String xxediford_shipdet(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		RqContext rqCtx = null;
		com.progress.open4gl.dynamicapi.ResultSet lastResultSet = null;

		if (isSessionAvailable() == false)
			throw new Open4GLException(m_notAvailable, null);

		Object outValue;
		ParameterSet params = new ParameterSet(2);

		// Set up input parameters
		params.setDataGraphParameter(1, input_param, ParameterSet.INPUT, false);


		// Set up input/output parameters


		// Set up Out parameters
		params.setDataGraphParameter(2, null, ParameterSet.OUTPUT, false);


		// Setup local MetaSchema if any params are tables
		MetaSchema xxediford_shipdet_MetaSchema = new MetaSchema();
		xxediford_shipdet_MetaSchema.addProDataGraphSchema(xxediford_shipdet_DSMetaData1, 1, ParameterSet.INPUT , false);
		xxediford_shipdet_MetaSchema.addProDataGraphSchema(xxediford_shipdet_DSMetaData2, 2, ParameterSet.OUTPUT , false);


		// Set up return type
		

		// Run procedure
		rqCtx = runProcedure("xxediford_shipdet.p", params, xxediford_shipdet_MetaSchema);


		// Get output parameters
		outValue = params.getOutputParameter(2);
		export_param.setValue(outValue);


		// Session-Managed always returns null
		if (rqCtx != null)
		{
			if (!rqCtx._isStreaming())
				rqCtx._release();
			else
			{
				// If set, there's a ResultSetHolder parm
				lastResultSet = null;
				if (lastResultSet != null)
					lastResultSet.setRqContext(rqCtx);
			}
		}

		// Return output value
		return (String)(params.getProcedureReturnValue());

	}



}
