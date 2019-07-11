<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html> 
<head>
<link rel="stylesheet" type="text/css" href="mystyles.css" media="screen" />
</head>

<body> 

<form name='loginForm' action='login.jsp'>
<p class="a">
<b>Today's date & time: <%= (new java.util.Date()).toLocaleString()%></b>
<br><br>
<b> Enter your login details </b>
<br><br>
User Name: <input type="text" 
     value="" name="userName" id="userName">
<br><br>
Password:  <input type="password" 
     value="" name="userPassword" id="userPassword">
<br><br>
<input type="checkbox" onclick="Toggle()"> 
     Show Password  
<br><br><br>

<input type="submit" class="button" value="Submit" onclick="Submit()">
<br></p>

</form>

<script> 
    	
// Toggle between show and hide password based on user input
function Toggle() 
	{ 
	var textOrPassword = document.getElementById("userPassword"); 
       	if (textOrPassword.type === "password") { 
        textOrPassword.type = "text"; 
        } 
        else { 
        textOrPassword.type = "password"; 
        } 
        } 
	
// Toggle between show and hide password based on user input
function Submit() 
	{ 
	var user = document.getElementById("userName");
	var pass = document.getElementById("userPassword");
	var userValue = user.value;
	var passValue = pass.value;
		
	if (userValue.length === 0)
	{ 
	var userError = "Username is a mandatory field";
	}
	if (passValue.length === 0)
	{
	var passError = "Password is a mandatory field";	
	}
	}

</script> 
</body> 
</html> 