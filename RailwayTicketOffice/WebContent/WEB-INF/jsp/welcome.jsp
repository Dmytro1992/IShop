<%@ include file="/WEB-INF/include/head.jspf"%>
<!DOCTYPE html PUBLIC">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="7; URL='login.jsp'" />
<tag:css />
<title>Welcome</title>

</head>

<body>
	<div class="wrapper">
		<div class="contentW">
			<tag:header />
			<div class="welcome_content">
				<h1 class="light">
					Welcome!<br>
				</h1>

				<h2>
					Congratulations registration was successful!
				</h2>
				<h2>You registered under login: <c:out value="${login}" /></h2>
				<h2>Sign in to buy a ticket</h2>

			</div>
		</div>
		<tag:footer />
	</div>
</body>
</html>