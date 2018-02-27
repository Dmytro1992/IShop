<%@ include file="/WEB-INF/include/head.jspf"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<tag:css />
<title>Shopping-cart</title>
</head>
<body>

	<div class="wrapper">
		<tag:header />

		<div class="container-sign-in">
			<form action="Controller" method="get">
				<table>
					<tr>
						<th>Train number</th>
						<th>Starting station</th>
						<th>Departure time</th>
						<th>End station</th>
						<th>Arrival time</th>
						<th>Number ticket</th>
						<th>type</th>
						<th>quantity</th>
						<th>cost</th>
						<th></th>
					</tr>
					<c:set value="${0 }" var="total"/>
					<c:forEach items="${orderList}" var="ticket">
						<tr>
							<td>${ticket.trainNumber}</td>
							<td>${ticket.startingStation}</td>
							<td>${ticket.departureTime}</td>
							<td>${ticket.endStation}</td>
							<td>${ticket.arrivalTime}</td>
							<td>${ticket.numberTicket}</td>
							<td>${ticket.type}</td>
							<td>${ticket.quantity}</td>
							<td>${ticket.cost}</td>
							<td id="tdColor"><a href="http://localhost:8080/SummaryTask/Controller?command=remove&idTicket=${ticket.numberTicket}">
							remove</a></td>	
						</tr>
						
						<c:set value="${total+ ticket.cost}" var="total"/>
					</c:forEach>
					<tr>
						<td colspan="8" id="total">Total:</td>
						<td>${total }</td>
					</tr>
				</table>

			</form>

		</div>
		<div class="field">
			<tag:footer />
		</div>
	</div>

</body>
</html>