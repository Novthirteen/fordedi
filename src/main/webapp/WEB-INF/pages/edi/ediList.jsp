<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="ediList.title" /></title>
<meta name="menu" content="EdiMenu" />
</head>
<body id="edi">
	<h2>
		<fmt:message key="ediList.heading" />
	</h2>

	<s:form name="ediForm" action="edis" method="post" validate="true">
		<div class="row">
			<div class="col-xs-3 search-group">
				<label class="control-label"><fmt:message key="edi.shipto" /></label>
				<input id="shipto" name="edi.shipto" value="${edi.shipto}"
					type="text" class="col-md-12 form-control search-control"
					placeholder="" autocomplete="off" /> <input type="hidden"
					name="cb" value="${cbValue}">
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="plandt_fr"
					key="edi.plandt_fr" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="plandt_to"
					key="edi.plandt_to" />
			</div>
		</div>

		<div class="row">

			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="importdt_fr"
					key="edi.importdt_fr" />
			</div>
			<div class="col-xs-3 search-group">
				<s:textfield cssClass="form-control search-control" id="importdt_to"
					key="edi.importdt_to" />
			</div>
			<div class="col-xs-3 search-group layouttrim">
				<input type="hidden" name="from" value="list" />
				<s:submit type="button" cssClass="btn" action="edis"
					key="button.search" theme="simple">
					<i class="icon-search"></i>
					<fmt:message key="button.search" />
				</s:submit>
			</div>
		</div>
	</s:form>
	<hr>

	<display:table name="edis" cellspacing="0" cellpadding="0"
		requestURI="edis" defaultsort="1" id="edi" pagesize="0"
		class="table table-condensed table-striped table-hover" export="false">
	
		<display:column property="ver" escapeXml="true"
			sortable="true" titleKey="edi.ver"
			url="/edi/editEdi?from=list&cb=${cbValue}"
			paramId="key"
			paramProperty="key" />
		<display:column property="rlse_dt" escapeXml="true"
			sortable="true" titleKey="edi.rlse_dt" />
		<display:column property="type" escapeXml="true"
			sortable="true" titleKey="edi.type" />
		
		<display:column property="plandt" escapeXml="true"
			sortable="true" titleKey="edi.plandt" />
		
		<display:column property="import_dt" escapeXml="true"
			sortable="true" titleKey="edi.import_dt" />
		

		<display:setProperty name="paging.banner.placement" value="both" />
		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="ediList.edi" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="ediList.edis" />
		</display:setProperty>
		
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