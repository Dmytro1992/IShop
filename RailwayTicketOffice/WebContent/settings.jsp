<%@ include file="/WEB-INF/include/head.jspf"%>
<html>
<head>
<tag:css />
</head>
<body>
<tag:header />
	<form action="changeLocale.jsp" method="post">
		<p id="set"><fmt:message key="settings_jsp.label.set_locale"/>:
		<select name="locale" id="setting">
			<c:forEach items="${applicationScope.locales}" var="locale">
				<c:set var="selected" value="${locale.key == currentLocale ? 'selected' : '' }"/>
				<option value="${locale.key}" ${selected}>${locale.value}</option>
			</c:forEach>
		</select>
		<input type="submit" value="<fmt:message key='settings_jsp.form.submit_save_locale'/>" id="setting">
		</p>
	</form>
</body>
</html>