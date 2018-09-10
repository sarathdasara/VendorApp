<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
	<form action="editCustomer" method="post">
		<center>	

			<pre>

Id:<input type="text" name="cId" value="${cust.cId}" />
Name:<input type="text" name="cName" value="${cust.cName}" />
Email:<input type="text" name="cEmail" value="${cust.cEmail}" />
Type:
<select name="cType"> ${cust.cType}
<option>--</option>
<option>Customer</option>
<option>Seller</option>
</select>
Address:<textarea name="address">${cust.address}</textarea> 
<%-- Password:<input type="password" name="cPwd" value="${cust.cPwd}" />
Token:<input type="password" name="token" value="${cust.token}" /> --%>
<input type="submit" value="Update">

</pre>
		</center>
	</form>
</body>
</html>