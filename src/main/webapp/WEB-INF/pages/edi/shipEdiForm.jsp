<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="shipSummaryList.title" /></title>
<meta name="menu" content="AsnMenu" />
</head>

<h2>
	<fmt:message key="shipSummaryList.heading" />
</h2>

<s:form name="shipEdiForm" action="editShipEdi" method="post"
	validate="true" cssClass="well form-horizontal" autocomplete="off">
	<input type="hidden" name="from" value="${param.from}" />
	<div class="row">
		<div class="col-xs-4 search-group">
			<s:textfield key="shipSummary.ver" cssClass="form-control"
				readonly="true" />
			<s:hidden key="shipSummary.ver" />
		</div>
		<div class="col-xs-4 search-group"></div>
	</div>


	<hr>
	<div id="actions" class="form-group form-actions">
		<s:submit type="button" cssClass="btn btn-primary" action="shipEdi"
			key="button.ship" theme="simple">
			<i class="icon-print icon-white"></i>
			<fmt:message key="button.ship" />
		</s:submit>


		<s:submit type="button" cssClass="btn" method="cancel"
			key="button.back" theme="simple">
			<i class=" icon-arrow-left"></i>
			<fmt:message key="button.back" />
		</s:submit>
	</div>



	<display:table name="shipDetails" cellspacing="0" cellpadding="0"
		requestURI="editShipSummary" id="shipDetail" pagesize="0"
		class="table table-condensed table-striped table-hover" export="false">
		<display:column property="part" escapeXml="true"
			titleKey="shipDetail.part" style="min-width:50px" />
		<display:column property="desc" escapeXml="true"
			titleKey="shipDetail.desc" style="min-width:100px" />
		<display:column property="ford_part" escapeXml="true"
			titleKey="shipDetail.ford_part" style="min-width:80px" />
		<display:column property="rec_palnt" escapeXml="true"
			titleKey="shipDetail.rec_palnt" style="min-width:60px" />
		<display:column property="ship_fr" escapeXml="true"
			titleKey="shipDetail.ship_fr" style="min-width:60px" />
		<display:column property="plan_qty" escapeXml="true"
			titleKey="shipDetail.plan_qty" style="min-width:50px" />
		<display:column property="cum_ship" escapeXml="true"
			titleKey="shipDetail.cum_ship" style="min-width:50px" />

		<display:column titleKey="shipDetail.ship_qty">
			<input type="text" style="margin: 0px; width: 80px;"
				name="shipDetails[${shipDetail_rowNum - 1}].ship_qty"
				value="${shipDetail.ship_qty}" class="text medium" />
			<input type="hidden" name="shipDetails[${shipDetail_rowNum - 1}].id"
				value="${shipDetail.id}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].part"
				value="${shipDetail.part}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].desc"
				value="${shipDetail.desc}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].ford_part"
				value="${shipDetail.ford_part}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].rec_palnt"
				value="${shipDetail.rec_palnt}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].ship_fr"
				value="${shipDetail.ship_fr}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].plan_qty"
				value="${shipDetail.plan_qty}" />
			<input type="hidden"
				name="shipDetails[${shipDetail_rowNum - 1}].cum_ship"
				value="${shipDetail.cum_ship}" />
		</display:column>
		<display:column titleKey="shipDetail.um">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].um"
				value="${shipDetail.um}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.shipper">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].shipper"
				value="${shipDetail.shipper}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.bl">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].bl"
				value="${shipDetail.bl}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.purpose">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].purpose"
				value="${shipDetail.purpose}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.gw">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].gw"
				value="${shipDetail.gw}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.nw">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].nw"
				value="${shipDetail.nw}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.wt_um">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].wt_um"
				value="${shipDetail.wt_um}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.package_type">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].package_type"
				value="${shipDetail.package_type}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.lading_qty">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].lading_qty"
				value="${shipDetail.lading_qty}" class="text medium" />
		</display:column>
		<display:column titleKey="shipDetail.carrier">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].carrier"
				value="${shipDetail.carrier}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.trans_mthd">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].trans_mthd"
				value="${shipDetail.trans_mthd}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.conv_nbr">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].conv_nbr"
				value="${shipDetail.conv_nbr}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.units_per">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].units_per"
				value="${shipDetail.units_per}" class="text medium" />
		</display:column>

		<display:column titleKey="shipDetail.airport">
			<input type="text" style="margin: 0px; width: 60px;"
				name="shipDetails[${shipDetail_rowNum - 1}].airport"
				value="${shipDetail.airport}" class="text medium" />
		</display:column>

	</display:table>
</s:form>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("input[type='text']:visible:enabled:first",
						document.forms['asnForm']).focus();
			});
</script>
