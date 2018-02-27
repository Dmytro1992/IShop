<%@ include file="/WEB-INF/include/head.jspf"%>
<!DOCTYPE html PUBLIC">
<html>

<head>
<tag:css />
<title>Page error</title>
</head>
<div class="wrapper">
	<div class="contentW">
		<tag:header />
		<h2 class="light" >The following error occurred</h2>
		<h2 class="message-error"><c:out value="${messageError}"/></h2>
	</div>
	
	<tag:footer />
</div>
</body>
</html>
