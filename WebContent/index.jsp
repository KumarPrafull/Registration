<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav><a href="login.jsp">Login</a></nav>

<form action="Register" method="post">
<table>
	<tr><td>User name :</td>
		<td><input type="text" name="uname" pattern="[A-Za-z]*">
		<small>eg: Only alphabets allowed</small>
		</td>
	</tr>
	
	<tr>
		<td>Enter a mobile number:</td>
		<td>
  		<input type="tel" name="phone" placeholder="Enter 10 digit Mobile number" pattern="[6-9]{1}[0-9]{9}" required> 
  		<small>eg: 9834524567</small>
  		</td>
  	</tr>
	
	<tr><td>Age :</td>
		<td>  <input type="number" id="age" name="age" min="1" max="999">
		<small>eg: age must be between 1-999</small>
		</td>
		
	</tr>
  
 	<tr><td>Gender :</td><td> <select name="gender">
 			<option value="male"> Male
 			<option value="female"> Female
 			<option value="other"> Other</select></td>
 	</tr>

	<tr><td>Address :</td>
		<td>
			<input type="text" name="address" pattern="[A-Za-z0-9]{1,200}">
			<small>eg: Only Alphabets and Numbers allowed. Below 200 characters</small>
		</td>
	</tr>
  
	<tr><td>Password :</td>
		<td><input type="password" name="password" placeholder="at least eight character and one special character" pattern="(?=.*?[#?!@$%^&*-]).{8,}">
		<small>eg: Must have at least 8 characters with special characters</small>
		</td>
	</tr>

	<tr><td></td><td><input type="submit" value="register"></td></tr>

</table>

</form>
</body>
</html>