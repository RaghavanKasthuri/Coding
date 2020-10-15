<%@ page contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
   <head>
      <title>Citybike Networks across the globe</title>
      <style>
		.container {
  display: inline-block;
  text-align: left;
  border: thin;
  border: 3px solid green;
  padding: 15px;
  margin-left: 200px;}

 .containerA {
  display: inline-block;
  text-align: left;
  border: thin;
  border: 3px solid green;
  padding: 15px;
  margin-left: 200px;}
	
     </style>
   </head>

   <body>
   	
   	<br>
   	   	
   	<div class="container">
   	
   	<font size="3" face="Arial" color="black"> 
   	<b>Please find the list of all Citybike Networks across the world:</b>
	</font>
	
	
	<br><br>
	<font size="2" face="Arial" color="black">
	<table border="1">
	<tr>
		<td> Network Name</td><td></td>
		<td> Country </td><td></td>
		<td> City </td><td></td> 
	</tr>
	
	<c:forEach items="${list}" var="list">
	<tr>
	<td> ${list.networkName} </td><td></td>
	<td> ${list.country} </td><td></td>
	<td> ${list.city} </td><td></td>
	</tr>
	</c:forEach>
	
	</table>
	</font>
	</div>
   </body>
</html>