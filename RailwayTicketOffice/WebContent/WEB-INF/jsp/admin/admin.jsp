<%@ include file="/WEB-INF/include/head.jspf"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<tag:css />
<title>Admin</title>
</head>
<body>

	<div class="wrapper">
		<tag:header />
		
		<form action="Controller" method="post">
			<nav class="two">
				<ul>
					<li><input name="command" value="Show train route"
						type="submit" /></li>
					<li><input name="command" value="Delete train route"
						type="submit" /></li>
					<li><input name="command" value="Add a new route"
						type="submit" /></li>
					<li><input name="command" value="Correct train route"
						type="submit" /></li>
				</ul>
			</nav>
		</form>
		<div class="container-sign-in">
			<!-- Show list station -->
			<c:if test="${sessionScope.order == 1}">
				<table>
					<c:set var="count" value="1" />
					<c:forEach items="${showRoute}" var="item">
						<tr>

							<td colspan="6"><fmt:message
									key="table.train_route.name_table_route" /></td>
						</tr>
						<tr>
							<th>#</th>
							<th><fmt:message key="table.train_route.number_route" /></th>
							<th><fmt:message key="table.train_route.starting_station" /></th>
							<th><fmt:message key="table.train_route.departure_time" /></th>
							<th><fmt:message key="table.train_route.end_station" /></th>
							<th><fmt:message key="table.train_route.arrival_time" /></th>
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
							<td colspan="6"><fmt:message
									key="table.train_station.name_table_station" /></td>
						</tr>

						<tr>
							<th>#</th>
							<th><fmt:message key="table.train_station.number_station" /></th>
							<th><fmt:message key="table.train_station.station" /></th>
							<th><fmt:message key="table.train_station.arrival_time" /></th>
							<th><fmt:message key="table.train_station.parking_time" /></th>
							<th><fmt:message key="table.train_station.departure_time" /></th>
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
					</c:forEach>
				</table>
			</c:if>
			<!-- Delete station -->
			<c:if test="${sessionScope.order == 2}">
				<form action="Controller" method="post">
					<table>
						<tr>
							<th><fmt:message
									key="admin_jsp.route.input_name.put_in_number_route" /></th>
						</tr>
						<tr>
							<td><fmt:message
									key="admin_jsp.route.input_name.number_route" /></td>
							<td id="tdColor"><input type="text" name="deleteRoute"></td>
						</tr>
					</table>
					<input type="submit" value="Delete route" name="command"
						id="buttonOrder2" />

					<table>
						<tr>
							<th><fmt:message
									key="admin_jsp.station.input_name.put_in_number_station" /></th>
						</tr>
						<tr>
							<td><fmt:message
									key="admin_jsp.station.input_name.number_station" /></td>
							<td id="tdColor"><input type="text" name="deleteStation"></td>
						</tr>
					</table>
					<input type="submit" value="Delete station" name="command"
						id="buttonOrder2" />
				</form>
			</c:if>
			<!-- Add station -->
			<c:if test="${sessionScope.order == 3}">
				<form action="Controller" method="post">
					<table>
						<tr>
							<td><fmt:message key="table.train_station.station" /></td>
							<td><fmt:message key="table.train_station.arrival_time" /></td>
							<td><fmt:message key="table.train_station.parking_time" /></td>
							<td><fmt:message key="table.train_station.departure_time" /></td>
						</tr>
						<tr>

							<td id="tdColor"><input type="text" name="startingStantion"></td>
							<td id="tdColor"><input type="time" name="departureTime"></td>
							<td id="tdColor"><input type="text" name="endStation"></td>
							<td id="tdColor"><input type="time" name="arrivalTime"></td>
						</tr>
					</table>
					<input type="submit" value="Add route" name="command"
						id="buttonOrder3" />
				</form>
				<form action="Controller" method="post">
					<table>
						<tr>
							<td><fmt:message
									key="admin_jsp.route.input_name.number_route" /></td>
							<td><fmt:message key="table.train_station.station_name" /></td>
							<td><fmt:message key="table.train_station.arrival_time" /></td>
							<td><fmt:message key="table.train_station.parking_time" /></td>
							<td><fmt:message key="table.train_station.departure_time" /></td>
						</tr>
						<tr>
							<td id="tdColor"><input type="text" name="numberRout"></td>
							<td id="tdColor"><input type="text" name="stationName"></td>
							<td id="tdColor"><input type="time"
								name="stationArrivalTime"></td>
							<td id="tdColor"><input type="time" name="parkingTime1">
								<input type="time" name="parkingTime2"></td>
							<td id="tdColor"><input type="time"
								name="stationDepartureTime"></td>
						</tr>
					</table>
					<input type="submit" value="Add station" name="command"
						id="buttonOrder3" />
				</form>
			</c:if>
			<!-- Correct station -->

			<c:if test="${sessionScope.order == 4}">

				<div class=main>
					<form action="Controller" method="post">

						<div class="field">
							<label id="order4"><fmt:message key="admin_jsp.route.update_route_label_name" /></label>
						</div>
						<div class="field">
							<label><fmt:message
									key="admin_jsp.route.update_route_label_name.enter_number" /></label>
							<input type="text" name="id" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="starting_station">
							<label><fmt:message
									key="table.train_route.starting_station" /></label> <input type="text"
								name="starting_station" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="departure_time">
							<label><fmt:message
									key="table.train_route.departure_time" /></label> <input type="time"
								name="departure_time" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="end_station" checked>
							<label><fmt:message key="table.train_route.end_station" /></label>
							<input type="text" name="end_station" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="arrival_time"
								checked> <label><fmt:message
									key="table.train_route.arrival_time" /></label> <input type="time"
								name="arrival_time" />
						</div>
						<div class="field">
							<input type="submit" value="Update route" name="command"
								id="order4Sub">
						</div>
					</form>
					<form action="Controller" method="post">
						<br>
						<div class="field">
							<label id="order4"><fmt:message
									key="admin_jsp.route.update_station_label_name" /></label>
						</div>
						<div class="field">
							<label><fmt:message
									key="admin_jsp.route.update_station_label_name.enter_station" /></label>
							<input type="text" name="id" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="station"> <label><fmt:message
									key="table.train_station.station" /></label> <input type="text"
								name="station" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="arrival_time">
							<label><fmt:message
									key="table.train_station.arrival_time" /></label> <input type="time"
								name="arrival_time" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="parking_time"
								checked> <label><fmt:message
									key="table.train_station.parking_time" /></label> <input type="time"
								name="parking_time1" /> - <input type="time"
								name="parking_time2" />
						</div>
						<div class="field">
							<input name="chooseItem" type="radio" value="departure_time"
								checked><label> <fmt:message
									key="table.train_station.departure_time" /></label> <input type="time"
								name="departure_time" />
						</div>
						<div class="field">
							<input type="submit" value="Update station" name="command"
								id="order4Sub">
						</div>

					</form>
				</div>
			</c:if>

		</div>
		<div class="field">
			<tag:footer />
		</div>
	</div>

</body>
</html>
