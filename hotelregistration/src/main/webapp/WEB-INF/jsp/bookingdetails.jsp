<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>UserHome</title>
</head>
<body>
	<h1>Rooms booked by customers!</h1>
	<table >
				<thead>
					<tr>
						
						<th>Booking Id</th>
						
						<th>Room type</th>
						<th>Number of persons</th>
						<th>From date</th>
						<th>To date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rooms}" var="room">
						<tr>
							<td>${room.bookingId}</td>
							
							<td>${room.roomType}</td>
							<td>${room.noOfPersons}</td>
							<td>${room.fromDate}</td>
							<td>${room.toDate}</td>
							
							

						</tr>
					</c:forEach>

				</tbody>
			
			</table>
				<a href="/home">Go Back</a>
</body>
</html>