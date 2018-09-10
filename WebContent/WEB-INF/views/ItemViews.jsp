<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="UserMenu.jsp" %>
<center>
<a href="ItemPdfView">ItemPdfSheet</a>
<br>
<a href="ItemExcelSheet">ItemExcelSheet</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>COST</th>
			<th>DISCOUNT</th>
			<th>COSTID</th>
		</tr>
		
		<c:forEach items="${i}" var="i">
			<tr>
				<td><c:out value="${i.id}" /></td>
				<td><c:out value="${i.itemName}" /></td>
				<td><c:out value="${i.itemCost}" /></td>
				<td><c:out value="${i.discount}" /></td>
				<td><c:out value="${i.costId}" /></td>
				<td><a href="deleteItem?id=${i.id}">Delete</a></td>
				<td><a href="editItem1?id=${i.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>