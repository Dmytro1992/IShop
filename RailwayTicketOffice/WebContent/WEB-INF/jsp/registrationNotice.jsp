<%@ include file="/WEB-INF/include/head.jspf"%>
<!DOCTYPE html PUBLIC">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="7; URL='login.jsp'" />
<tag:css />
<title>Registration notice</title>

</head>

<body>
	<div class="wrapper">
		<div class="contentW">
			<tag:header />
			<div class="welcome_content">
				<h1 class="light">
					Registration notice!<br>
				</h1>

				<h2>
					A registration message has been sent to your email address: <c:out value="${applicationScope.user.email}" />
 
				</h2>

			</div>
		</div>
		<tag:footer />
	</div>
</body>
</html>