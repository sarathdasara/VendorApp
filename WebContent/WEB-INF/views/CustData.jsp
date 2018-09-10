<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="UserMenu.jsp" %>
<center>
<a href="custExternalExcel">CustExcelSheet</a>
<a href="customerExternalPdf">CustPdfSheet</a>
<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>Email</th>
			<th>TYPE</th>
			<th>ADDRESS</th>
			<th>Password</th>
			<th>Token</th>
			<th>Operations</th>
		</tr>
		 <c:forEach items="${customer}" var="cust">
		<tr>
		<td><c:out value="${cust.cId}"/></td>
		<td><c:out value="${cust.cName}"/></td>
		<td><c:out value="${cust.cEmail}"/></td>
		<td><c:out value="${cust.cType}"/></td>
		<td><c:out value="${cust.address}"/></td>
		<td><c:out value="${cust.cPwd}"/></td>
		<td><c:out value="${cust.token}"/></td>
		<td><a href="customDelete?cId=${cust.cId }">Delete</a>
		<a href="customerEdit?cId=${cust.cId }">Edit</a></td>
		</tr>
		</c:forEach>

</table>
</center>
</body>
</html>