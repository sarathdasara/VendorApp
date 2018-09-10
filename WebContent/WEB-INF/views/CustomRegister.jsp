<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
<form action="insertCustomer" method="post">
<center>
<h2>welcome to customer</h2>
<pre>

Id:<input type="text" name="cId"/>
Name:<input type="text" name="cName"/>
Email:<input type="text" name="cEmail"/>
Type:<select name="cType">
<option>--</option>
<option>Customer</option>
<option>Seller</option>
</select>
Address:<textarea name="address"></textarea> 
<!-- Password:<input type="password" name="cPwd"/>
Token:<input type="password" name="token"/> -->
<input type="submit" value="Register">

</pre>
${msg}
<a href="allCustomers">CustomerData</a>
</center>

</form>

</body>
</html>