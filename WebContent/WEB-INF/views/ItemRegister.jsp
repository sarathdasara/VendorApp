<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
<%@include file="UserMenu.jsp" %>
	<form action="itemRegis" method="post">
		<pre>
Id:<input type="text" name="id" />
Name:<input type="text" name="itemName" />
Cost:<input type="text" name="itemCost" />
Discount:<input type="text" name="discount" />
CostId:<input type="text" name="costId" />
<input type="submit" value="Register" />
</pre>

	</form>
${msg}
</center>
</body>
</html>