<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="A"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<A:Admin title="Admin Approval Page">

	<jsp:attribute name="head">
	</jsp:attribute>
	
	<jsp:attribute name="content">
		
		
		<f:form modelAttribute="loginList">
			<input type="submit" value="All Requests" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/All">
			<input type="submit" value="Sort By Status" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/StatusSort">
			<input type="submit" value="Sort By Role" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/RoleSort">
			<input type="submit" value="Pending Only" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/">
			<table border="1">
				<tr>
					<td> </td>
					<td>User Id</td>
					<td>Password</td>
					<td>Role</td>
					<td>Status</td>
				</tr>
				
				<a:forEach var="l" items="${loginList}">
					<tr>
						<td><input type="checkbox" name="loginItem[]" value="${l.userId}"></td>
						<td>${l.userId}</td>
						<td>${l.password}</td>
						<td>${l.role}</td>
						<td>${l.status}</td>
					</tr>
				</a:forEach>
				
			</table>
			<input type="submit" value="Approve" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/ApproveLogin">
			<input type="submit" value="Reject" formaction="http://localhost:8080/OnlineVehicleBookingSystem/AdminApprovalPage/RejectLogin">
			<a:out value="${msg}"></a:out>
		</f:form>
	</jsp:attribute>

</A:Admin>