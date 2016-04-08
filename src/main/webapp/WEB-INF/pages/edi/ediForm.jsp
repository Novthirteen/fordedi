<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="ediList.title" /></title>
<meta name="menu" content="EdiMenu" />
</head>

<h2>
	<fmt:message key="ediList.heading" />
</h2>

<s:form name="ediForm" action="editEdi" method="post" validate="true"
	cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:label key="edi.ver" cssClass="form-control" readonly="true" />
			<s:hidden key="edi.ver" />
		</div>
		<div class="col-xs-4 search-group"></div>
	</div>
	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>
</s:form>

<table id="ediDetails" cellpadding="0" class="table" cellspacing="0">
	<thead>
		<tr>
			<th nowrap="nowrap"><fmt:message key="ediDetail.rlse_dt" /></th>
			<th nowrap="nowrap"><fmt:message key="ediDetail.part" /></th>
			<th nowrap="nowrap"><fmt:message key="ediDetail.desc" /></th>
			<th nowrap="nowrap"><fmt:message key="ediDetail.ford_part" /></th>
			<th nowrap="nowrap"><fmt:message key="scheduleDetail.um" /></th>
			<s:iterator id="head" value="%{scheduleView.scheduleHead.headList}">

				<th>${head.dateFrom}</th>
			
			</s:iterator>

		</tr>
	</thead>
	<tbody>
		<s:iterator id="scheduleBody" value="%{scheduleView.scheduleBodyList}"
			status="rowstatus">
			<s:if test="#rowstatus.odd == true">
				<tr class="odd">
					<td nowrap="nowrap">${scheduleBody.releaseDate}</td>
					<td nowrap="nowrap">${scheduleBody.itemCode}</td>
					<td nowrap="nowrap">${scheduleBody.itemDescription}</td>
					<td nowrap="nowrap">${scheduleBody.supplierItemCode}</td>
					<td nowrap="nowrap">${scheduleBody.um}</td>
					<s:iterator id="planQty" value="#scheduleBody.planQtyList">
						<td><fmt:formatNumber value="${planQty}" pattern="#,###.##" /></td>
					</s:iterator>
				</tr>
			</s:if>
			<s:else>
				<tr class="even">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<s:iterator id="totalQty" value="#scheduleBody.totalQtyList">
						<td><fmt:formatNumber value="${totalQty}" pattern="#,###.##" /></td>
					</s:iterator>
				</tr>
			</s:else>




		</s:iterator>
	</tbody>
</table>

