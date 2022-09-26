<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="B"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<B:Branch title="Approve Vehicle Booking">

	<jsp:attribute name="head"></jsp:attribute>
	
	<jsp:attribute name="content">
		<a:if test="${cbList!=null}">
					<f:form modelAttribute="cbList">
						<Table border="1">
							<tr>
								<td> </td>
								<td>Booking Id</td>
								<td>Customer Id</td>
								<td>Vehicle Id</td>
								<td>Branch Id</td>
								<td>Status</td>
							</tr>
							<a:forEach var="cb" items="${cbList}">
								<tr>
									<td><input type="checkbox" name="bookings[]" value="${cb.bookingId}"></td>
									<td>${cb.bookingId}</td>
									<td>${cb.custId.custId.userId}</td>
									<td>${cb.vehicleId.vehicleId}</td>
									<td>${cb.branchId.branchId.userId}</td>
									<td>${cb.status}</td>
								</tr>
							</a:forEach>
						</Table>
						<input type="submit" value="Approve" formaction="http://localhost:8080/OnlineVehicleBookingSystem/ApproveVehicleBooking/ApproveBooking">
						<input type="submit" value="Reject" formaction="http://localhost:8080/OnlineVehicleBookingSystem/ApproveVehicleBooking/RejectBooking">
						<a:out value="${msg}"></a:out>
					</f:form>
				</a:if>
	</jsp:attribute>

</B:Branch>