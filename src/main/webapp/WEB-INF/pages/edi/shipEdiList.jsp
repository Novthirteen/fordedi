<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="shipSummaryList.title" /></title>
<meta name="menu" content="EdiMenu" />
</head>
<body id="shipSummary">
	<h2>
		<fmt:message key="shipSummaryList.heading" />
	</h2>

	<s:form name="shipSummaryForm" action="shipEdis" method="post"
		validate="true">
		<div class="row">
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message
						key="shipSummary.shipto" /></label> <input id="shipto"
					name="shipSummary.shipto" value="${shipSummary.shipto}" type="text"
					class="col-md-12 form-control search-control" placeholder=""
					autocomplete="off" /> <input type="hidden" name="cb"
					value="${cbValue}">
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="plandt_fr"
					key="shipSummary.plandt_fr" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="plandt_to"
					key="shipSummary.plandt_to" />
			</div>
		</div>

		<div class="row">

			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="importdt_fr"
					key="shipSummary.importdt_fr" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="importdt_to"
					key="shipSummary.importdt_to" />
			</div>
			<div class="col-xs-3 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn" action="shipEdis"
					key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
		</div>
	</s:form>
	<hr>

	<display:table name="shipSummarys" cellspacing="0" cellpadding="0"
		requestURI="shipSummarys" defaultsort="1" id="shipSummary"
		pagesize="0" class="table table-condensed table-striped table-hover"
		export="false">

		<display:column property="ver" escapeXml="true" sortable="true"
			titleKey="shipSummary.ver"
			url="/edi/editShipEdi?from=list&cb=${cbValue}"
			paramId="key" paramProperty="key" />
		<display:column property="rlse_dt" escapeXml="true" sortable="true"
			titleKey="shipSummary.rlse_dt" />
		<display:column property="type" escapeXml="true" sortable="true"
			titleKey="shipSummary.type" />

		<display:column property="plandt" escapeXml="true" sortable="true"
			titleKey="shipSummary.plandt" />

		<display:column property="import_dt" escapeXml="true" sortable="true"
			titleKey="shipSummary.import_dt" />


		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="shipSummaryList.shipSummary" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="shipSummaryList.shipSummarys" />
		</display:setProperty>
		<display:setProperty name="export.excel.filename"
			value="ShipSummary List.xls" />

		<display:setProperty name="export.pdf" value="false" />
		<display:setProperty name="export.excel" value="true" />
		<display:setProperty name="export.csv" value="false" />
		<display:setProperty name="export.xml" value="false" />
	</display:table>



	<script>
		$('#shipto')
				.typeahead(
						{
							ajax : {
								url : "<c:url value="/services/api/supplys/getSupplyData.json"/>",
								method : 'get',
								preDispatch : function(e) {
									return {
										domain : "${sessionScope.selectedUserPlant}",
										usercode : "${pageContext.request.remoteUser}",
										query : e
									}
								},
								triggerLength : 1
							},
							displayField : 'label',
							valueField : 'value'
						//onSelect: displayResult
						});

		$('#plandt_fr').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#plandt_to').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#importdt_fr').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});

		$('#importdt_to').datepicker({
			format : "yyyymmdd",
			language : "${pageContext.response.locale}",
			autoclose : true,
			todayHighlight : true
		});
	</script>


</body>