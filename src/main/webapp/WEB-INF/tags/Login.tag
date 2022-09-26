<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>
    <link href="/styles/MyStyle.css" rel="StyleSheet"> 
<meta charset="ISO-8859-1">
<title>${title}</title>
<jsp:invoke fragment="head"></jsp:invoke>
</head>
<body>
      <!--  <div style="position:absolute;top:0px;left:0px;width:100%;height:15%">
           <img
              src="/images/TitleF.png"
              style="width: 100%; height: 100%">
    </div> -->
    
<div style="position:absolute;top:-7.5%;width:100%;left:12.5%;height:50%">
     <h2>    
        <p style = "font-family:georgia,garamond,serif;font-size:70px;font-style:italic;">
        The Furious Booking Company
        </p>
     </h2>
</div>
     <div style="position:absolute;top:20%;left:0px;width:100%;height:85%">
      <img
                src="/images/orangecarlogin.png"
                style="width: 100%; height: 200%">    
    </div>



   
    <div style="position:absolute;top:15%;width:100%;left:0px;height:10%">
        <ul>
          <li><a href="http://localhost:8080/OnlineVehicleBookingSystem/">Homepage</a></li>
          <li><a href="http://localhost:8080/OnlineVehicleBookingSystem/register">New User Creation</a></li>
          <li style="float:right"><a class="active" href="http://localhost:8080/OnlineVehicleBookingSystem/login">Login</a></li>
        </ul>
        <h1> Welcome Guest<a:out value=""></a:out>
        </h1>
    </div>
    
    <div style="position:absolute;top:40%;width:40%;left:5%;height:100%">
    
    
      <jsp:invoke fragment="content"></jsp:invoke>
    
    </div>
    
</body>
</html>