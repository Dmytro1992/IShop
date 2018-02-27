<%@ include file="/WEB-INF/include/head.jspf"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<tag:css />
<title>Main</title>
</head>
<body>

	<div class="wrapper">
		<tag:header />

		<div class="container-sign-in">

			<form action="Controller" method="post">
			
				<table>
					<tr>
						<td>Put in starting station</td>
						<td id="tdColor"><input type="text" name="startingStation"></td>
						<td>Put in end station</td>
						<td id="tdColor"><input type="text" name="endStation"></td>
					</tr>
				</table>
				<input type="submit" value="Find route" name="command"
					id="buttonOrder2" />
			</form>
			<!-- Show list station -->
			<c:if test="${trainInfo != null}">
				<form action="Controller" method="get">
					<table>
						<tr>
							<th>Train number</th>
							<th>Travel time</th>
							<th>Starting station</th>
							<th>Departure time</th>
							<th>End station</th>
							<th>Arrival time</th>
							<th>Type</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Type</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Type</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Link</th>
						</tr>

						<c:forEach items="${trainInfo}" var="item">
							<tr>
								<td>${item.trainNumber}</td>
								<td>${item.travel_time}</td>
								<td>${item.startingStation}</td>
								<td>${item.departureTime}</td>
								<td>${item.endStation}</td>
								<td>${item.arrivalTime}</td>
								<td>${item.type1}</td>
								<td>${item.quantity1}</td>
								<td>${item.price1}</td>
								<td>${item.type2}</td>
								<td>${item.quantity2}</td>
								<td>${item.price2}</td>
								<td>${item.type3}</td>
								<td>${item.quantity3}</td>
								<td>${item.price3}</td>


								<td><a
									href="http://localhost:8080/SummaryTask/Controller?command=searchRequest&idRoute=${item.idRoute}"><u>more</u></a></td>


							</tr>

						</c:forEach>
					</table>
				</form>
				<c:if test="${sessionScope.loginIn != null}">
					<form action="Controller" method="post">
						<table id="buyTable">
							<tr>
								<th>Train Number</th>
								<th>Type of place</th>
								<th>Quantity</th>
							</tr>
							<tr>
								<td><select name="trainNumber" id="tdColor">
										<c:forEach items="${trainInfo}" var="item">
											<option>${ item.trainNumber}</option>
										</c:forEach>
								</select></td>
								<td><select name="type" id="tdColor">
										<option>compartment</option>
										<option>reserved seat</option>
										<option>common</option>
								</select></td>
								<td><select name="quantity" id="tdColor">
										<c:forEach var="i" begin="1" end="6">
											<option>${i }</option>
										</c:forEach>
								</select></td>
							</tr>
						</table>
						
						<input type="submit" name="command" value="Buy ticket"
							id="buttonOrder2" onclick="return confirmBuy();">
					</form>
				</c:if>
			</c:if>

		</div>
		<div class="field">
			<tag:footer />
		</div>
	</div>
	<script src="style/js/js.js"></script>
</body>
</html>