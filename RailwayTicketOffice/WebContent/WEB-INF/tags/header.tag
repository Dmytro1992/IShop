<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<form action="Controller" method="get">
				<div class="navbar-header">
					<a class="navbar-brand"
						href="http://localhost:8080/SummaryTask/Controller?command=main_page"><i
						class="glyphicon glyphicon-home" aria-hidden="true"></i> Railway
						ticket office</a>

				</div>
				<c:if test="${sessionScope.loginIn == null}">
					<c:if test="${check != log}">
						<div class="collapse navbar-collapse" id="ishopNav">
							<a
								href="http://localhost:8080/SummaryTask/Controller?command=register_page"
								class="btn btn-primary navbar-btn navbar-right sign-in"><i
								class="glyphicon glyphicon-pencil" aria-hidden="true"></i>

								Registration </a>
						</div>
					</c:if>

					<c:if test="${check == log}">
						<div class="collapse navbar-collapse" id="ishopNav">
							<a
								href="http://localhost:8080/SummaryTask/Controller?command=login_page"
								class="btn btn-primary navbar-btn navbar-right sign-in"><i
								class="glyphicon glyphicon-pencil" aria-hidden="true"></i> Sign
								in </a>
						</div>
					</c:if>

				</c:if>
			</form>
			<c:if test="${sessionScope.loginIn != null}">
				<form action="Controller" method="post">
					<input class="btn btn-primary navbar-btn navbar-right "
						type="submit" name="command" value="logout"> <input
						class="btn btn-primary navbar-btn navbar-right " type="submit"
						name="command" value="${sessionScope.loginIn}">
				</form>
			</c:if>
		</div>
	</nav>
</header>
<a href="settings.jsp"><fmt:message key="index_jsp.link.settings"/></a> 