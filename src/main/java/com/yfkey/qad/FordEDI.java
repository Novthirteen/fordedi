/*
**
**    Created by PROGRESS ProxyGen (Progress Version 11.4) Thu Apr 07 14:30:29 CST 2016
**
*/

package com.yfkey.qad;

import com.progress.open4gl.*;
import com.progress.common.ehnlog.IAppLogger;
import com.progress.common.ehnlog.LogUtils;
import com.progress.open4gl.dynamicapi.IPoolProps;
import com.progress.open4gl.javaproxy.Connection;
import com.progress.message.jcMsg;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.ResultSet;
import java.io.IOException;

//
// FordEDI
//
/**
*    
*
*    @author    Bob Bao
*    @version 1
*/
public class FordEDI implements SDOFactory
{
    // "This proxy version is not compatible with the current
    // version of the dynamic API."
    protected static final long m_wrongProxyVer = jcMsg.jcMSG079;

    private   static final int  PROXY_VER = 5;

    public FordEDIImpl m_FordEDIImpl;

    //---- Constructors
    public FordEDI(Connection connection)
        throws Open4GLException,
               ConnectException,
               SystemErrorException,
               IOException
    {
        /* we must do this here before we attempt to create the appobject */
        if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
            throw new Open4GLException(m_wrongProxyVer, null);

        String urlString = connection.getUrl();
        if (urlString == null || urlString.compareTo("") == 0)
            connection.setUrl("FordEDI");
        
    	connection.setIntProperty("PROGRESS.Session.sessionModel", QADConfg.getQadSessionMode());
    	
        m_FordEDIImpl = new FordEDIImpl(
                                  "FordEDI",
                                  connection,
                                  RunTimeProperties.tracer);
    }

    public FordEDI(String urlString,
                        String userId,
                        String password,
                        String appServerInfo)
        throws Open4GLException,
               ConnectException,
               SystemErrorException,
               IOException
    {
        Connection connection;

        /* we must do this here before we attempt to create the appobject */
        if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
            throw new Open4GLException(m_wrongProxyVer, null);

        connection = new Connection(urlString,
                                    userId,
                                    password,
                                    appServerInfo);

        m_FordEDIImpl = new FordEDIImpl(
                                  "FordEDI",
                                  connection,
                                  RunTimeProperties.tracer);

        /* release the connection since the connection object */
        /* is being destroyed.  the user can't do this        */
        connection.releaseConnection();
    }

    public FordEDI(String userId,
                        String password,
                        String appServerInfo)
        throws Open4GLException,
               ConnectException,
               SystemErrorException,
               IOException
    {
        Connection connection;

        /* we must do this here before we attempt to create the appobject */
        if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
            throw new Open4GLException(m_wrongProxyVer, null);

        connection = new Connection("FordEDI",
                                    userId,
                                    password,
                                    appServerInfo);

        m_FordEDIImpl = new FordEDIImpl(
                                  "FordEDI",
                                  connection,
                                  RunTimeProperties.tracer);

        /* release the connection since the connection object */
        /* is being destroyed.  the user can't do this        */
        connection.releaseConnection();
    }

    public FordEDI()
        throws Open4GLException,
               ConnectException,
               SystemErrorException,
               IOException
    {
        Connection connection;

        /* we must do this here before we attempt to create the appobject */
        if (RunTimeProperties.getDynamicApiVersion() != PROXY_VER)
            throw new Open4GLException(m_wrongProxyVer, null);

        connection = new Connection("FordEDI",
                                    null,
                                    null,
                                    null);
        
    	connection.setIntProperty("PROGRESS.Session.sessionModel", QADConfg.getQadSessionMode());
    	
        m_FordEDIImpl = new FordEDIImpl(
                                  "FordEDI",
                                  connection,
                                  RunTimeProperties.tracer);

        /* release the connection since the connection object */
        /* is being destroyed.  the user can't do this        */
        connection.releaseConnection();
    }

    public void _release() throws Open4GLException, SystemErrorException
    {
        m_FordEDIImpl._release();
    }

    //---- Get Connection Id
    public Object _getConnectionId() throws Open4GLException
    {
        return (m_FordEDIImpl._getConnectionId());
    }

    //---- Get Request Id
    public Object _getRequestId() throws Open4GLException
    {
        return (m_FordEDIImpl._getRequestId());
    }

    //---- Get SSL Subject Name
    public Object _getSSLSubjectName() throws Open4GLException
    {
        return (m_FordEDIImpl._getSSLSubjectName());
    }

    //---- Is there an open output temp-table?
    public boolean _isStreaming() throws Open4GLException
    {
        return (m_FordEDIImpl._isStreaming());
    }

    //---- Stop any outstanding request from any object that shares this connection.
    public void _cancelAllRequests() throws Open4GLException
    {
        m_FordEDIImpl._cancelAllRequests();
    }

    //---- Return the last Return-Value from a Progress procedure
    public String _getProcReturnString() throws Open4GLException
    {
        return (m_FordEDIImpl._getProcReturnString());
    }

    //---- Create an SDO ResultSet object - There are 3 overloaded variations
    public SDOResultSet _createSDOResultSet(String procName)
        throws Open4GLException, ProSQLException
    {
        return (m_FordEDIImpl._createSDOResultSet(procName, null, null, null));
    }

    public SDOResultSet _createSDOResultSet(String procName,
                                            String whereClause,String sortBy)
        throws Open4GLException, ProSQLException
    {
        return (m_FordEDIImpl._createSDOResultSet(procName, whereClause, sortBy, null));
    }

    public SDOResultSet _createSDOResultSet(String procName,
                                          String whereClause,
                                          String sortBy,
                                          SDOParameters params)
        throws Open4GLException, ProSQLException
    {
        return (m_FordEDIImpl._createSDOResultSet(procName, whereClause, sortBy, params));
    }

    // Create the ProcObject that knows how to talk to SDO's.
    public SDOInterface _createSDOProcObject(String procName)
        throws Open4GLException
    {
        return (m_FordEDIImpl._createSDOProcObject(procName));
    }

	/**
	*	
	*	
	*/
	public String xxediford_plandet(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		return m_FordEDIImpl.xxediford_plandet( input_param,  export_param);
	}

	/**
	*	
	*	
	*/
	public String xxediford_plansum(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		return m_FordEDIImpl.xxediford_plansum( input_param,  export_param);
	}

	/**
	*	
	*	
	*/
	public String xxediford_shipcon(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		return m_FordEDIImpl.xxediford_shipcon( input_param,  export_param);
	}

	/**
	*	
	*	
	*/
	public String xxediford_shipdet(ProDataGraph input_param, ProDataGraphHolder export_param)
		throws Open4GLException, RunTime4GLException, SystemErrorException
	{
		return m_FordEDIImpl.xxediford_shipdet( input_param,  export_param);
	}



}
