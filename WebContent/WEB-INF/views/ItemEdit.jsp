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
	<center>
		<%@include file="UserMenu.jsp"%>
		<form action="editItem" method="post">
			<pre>
Id:<input type="text" name="id" value="${i.id}" />
Name:<input type="text" name="itemName" value="${i.itemName}" />
Cost:<input type="text" name="itemCost" value="${i.itemCost}" />
Discount:<input type="text" name="discount" value="${i.discount}" />
CostId:<input type="text" name="costId" value="${i.costId}" />
<input type="submit" value="Update" />
</pre>
		</form>
	</center>
</body>
</html>