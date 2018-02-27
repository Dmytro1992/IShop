<%@ include file="/WEB-INF/include/head.jspf"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<tag:css />
<title>Show route</title>
</head>
<body>

	<div class="wrapper">
		<tag:header />
		
		<div class="container-sign-in">
		
			<table>
					<c:set var="count" value="1" />
					<c:set value="${railway}" var="item"/>
						<tr>
							<td colspan="6">Train route</td>
						</tr>
						<tr>
							<th>№</th>
							<th>number route</th>
							<th>starting station</th>
							<th>departure time</th>
							<th>end station</th>
							<th>arrival time</th>
						</tr>

						<tr>
							<td><c:out value="${count}" /></td>
							<td>${item.numberWay}</td>
							<td>${item.startingStation}</td>
							<td>${item.departureTime}</td>
							<td>${item.endStation}</td>
							<td>${item.arrivalTime}</td>
						</tr>
						<tr>
							<td colspan="6">Intermediate station</td>
						</tr>

						<tr>
							<th>№</th>
							<th>Number station</th>
							<th>station</th>
							<th>arrival time</th>
							<th>parking time</th>
							<th>departure time</th>
						</tr>
						<c:set var="index" value="1" />
						<c:forEach items="${item.intermediateStations}" var="items2">
							<tr>
								<td><c:out value="${count}" />.<c:out value="${index}" /></td>
								<td>${items2.numberStation}</td>
								<td>${items2.stationName}</td>
								<td>${items2.arrivalTime}</td>
								<td>${items2.parkingTime}</td>
								<td>${items2.departureTime}</td>
							</tr>
							<c:set var="index" value="${index+1}" />
						</c:forEach>
						<c:set var="count" value="${count+1}" />
					
				</table>
		</div>
		<div class = "field" >
		<tag:footer />
		</div>
	</div>

</body>
</html>