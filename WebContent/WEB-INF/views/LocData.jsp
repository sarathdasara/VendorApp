<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<center>
<h1>welcome to Location Register page Details</h1>


<%@include file="UserMenu.jsp" %>

<a href="locPdfView">LocPdfSheet</a>
<br>
<a href="locExcelSheet">LocExcelSheet</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>CODE</th>
			<th>TYPE</th>
			<th>DESCRIPTION</th>
			<td>Operations</td>
		</tr>
		
		<c:forEach items="${location}" var="loc">
			<tr>
				<td><c:out value="${loc.locId}" /></td>
				<td><c:out value="${loc.locName}" /></td>
				<td><c:out value="${loc.locCode}" /></td>
				<td><c:out value="${loc.locType}" /></td>
				<td><c:out value="${loc.locDsc}" /></td>
				<td><a href="deleteLoc?locId=${loc.locId}">Delete</a></td>
				<td><a href="editLoc?locId=${loc.locId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	</center>
	</body>
</html>