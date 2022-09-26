<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="A"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<A:Admin title="Add New Vehicle">
	<jsp:attribute name="head"></jsp:attribute>
	<jsp:attribute name="content">
		<f:form action="http://localhost:8080/OnlineVehicleBookingSystem/AddNewVehicle/Added" modelAttribute="vehicledb">
			<Table>
				<tr>
					<td>Vehicle ID</td>
					<td><f:input path="vehicleId"></f:input></td>
					<td><f:errors path="vehicleId"></f:errors></td>	
				</tr>
				<tr>
					<td>Manufacturer Name</td>
					<td><f:input path="manufactureName"></f:input></td>
					<td><f:errors path="manufactureName"></f:errors></td>
				</tr>
				<tr>
					<td>Color</td>
					<td><f:input path="color"></f:input></td>
					<td><f:errors path="color"></f:errors></td>
				</tr>
				<tr>
					<td>Seating Capacity</td>
					<td><f:input path="seatingCapacity"></f:input></td>
					<td><f:errors path="seatingCapacity"></f:errors></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><f:input path="price"></f:input></td>
					<td><f:errors path="price"></f:errors></td>
				</tr>
				<tr>
					<td>Branch Id</td>
					<td><f:input path="branchId.branchId.userId"></f:input></td>
					<td><f:errors path="branchId.branchId.userId"></f:errors></td>
				</tr>
				<tr>
					<td>Stock</td>
					<td><f:input path="stock"></f:input></td>
					<td><f:errors path="stock"></f:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add" ></td>
				</tr>
			</Table>
			<a:out value="${msg}"></a:out>
		</f:form>
	</jsp:attribute>
</A:Admin>