<%@ page language="java" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<title><fmt:message key="errorPage.title" /></title>
</head>
<body id="error">
	<div class="container">
		<h1>
			<fmt:message key="errorPage.heading" />
		</h1>
		<%@ include file="/common/messages.jsp"%>

		<p>
			<fmt:message key="errorPage.message" />
		</p>

		<c:set var="exception"
			value="${requestScope['javax.servlet.error.exception']}" />
		<jsp:scriptlet>exception.printStackTrace(new java.io.PrintWriter(out));</jsp:scriptlet>
	</div>
</body>
</html>
