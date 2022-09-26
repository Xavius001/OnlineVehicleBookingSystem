<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="A"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>

<A:Admin title="Admin Home">

	<jsp:attribute name="head"></jsp:attribute>
	
	<jsp:attribute name="content">
		<form>
		
			Hey boss! Hows it going?
		
		</form>
	</jsp:attribute>

</A:Admin>