<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>
<title>Insert title here</title>

</head>
<body>
	<center>
<%@include file="UserMenu.jsp" %>
<h2>Vendor Data</h2>
<a href="vendorExternalSheet">VendorExcel</a>
<br>
<a href="vendorPdfSheet">VendorPdf</a>
<table border="1">
		<tr>
			<th>ID</th>
			<th>CODE</th>
			<th>NAME</th>
			<th>TYPE</th>
			<th>ADDRESS</th>
			<th>IDType</th>
			<th>IDNum</th>
			<th>Description</th>
			<td>Operations</td>
		</tr>
		<c:forEach items="${vendor}" var="ven">
			<tr>
				<td><c:out value="${ven.venId}"/></td>
				<td><c:out value="${ven.venCode}" /></td>
				<td><c:out value="${ven.venName}" /></td>
				<td><c:out value="${ven.venType}" /></td>
				<td><c:out value="${ven.venAdd}" /></td>
				<td><c:out value="${ven.idType}" /></td>
				<td><c:out value="${ven.idNum}" /></td>
				<td><c:out value="${ven.venDsc}" /></td>
				<td><a href="deleteVen?venId=${ven.venId}">Delete</a></td>
				<td><a href="editVendor?venId=${ven.venId}">Edit</a></td>
				
			</tr>
		</c:forEach>
	</table>
	</center>
	</body>
</html>