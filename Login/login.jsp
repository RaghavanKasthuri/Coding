<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html> 
<head>
<link rel="stylesheet" type="text/css" href="mystyles.css" media="screen" />
</head>

<body>
<form id="personalDetailsForm" action="addPersonalDetails" method="post">

<%  
    String name = request.getParameter("userName");
    String password = request.getParameter("userPassword");

    session.setAttribute("username",name);
    session.setAttribute("password", password);
%>

<p class="a">
Dear <b><% out.println(name); %></b>, please enter your personal details
<br><br>
Name: <input type="text" 
     value="" id="fullName">
<br><br>
Mobile Number  <input type="text" 
     value="" id="mobileNumber">
<br><br>
Email Address  <input type="text" 
     value="" id="emailAddress">
<br><br><br>
<button class="button" id="submitButton" type="submit">Save & Continue</button>
<br></p>

</form>
</body> 
</html> 