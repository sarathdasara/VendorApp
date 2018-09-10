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
<%@include file="UserMenu.jsp" %>
<form action="updateVendor" method="post">

		<pre>
Id:<input type="text" name="venId"  value="${ven.venId }"/>
Code:<input type="text" name="venCode" value="${ven.venCode }" />
Name:<input type="text" name="venName" value="${ven.venName}" />


<%-- <c:choose> --%>
<%-- <c:when test="${'Contract' eq ven.venType}"> --%>
 Type: <input type="radio" name="venType" value="contract">Contract
         <input type="radio" name="venType" value="parttime">PartTime
          <input type="radio" name="venType" value="fulltime">FullTime
         
<!--           <input type="radio" name="venType" value="contract" >Contract -->
<!--          <input type="radio" name="venType" value="parttime" checked="checked">PartTime -->
<!--           <input type="radio" name="venType" value="fulltime">FullTime -->
<%--           </c:otherwise> --%>
<%--           <c:otherwise> --%>
<!--           <input type="radio" name="venType" value="contract" >Contract -->
<!--          <input type="radio" name="venType" value="parttime">PartTime -->
<!--           <input type="radio" name="venType" value="fulltime" checked="checked">FullTime -->
<%--           </c:otherwise> --%>
<%--           </c:choose> --%>
Address:<textarea name="venAdd">${ven.venAdd}</textarea>  
IdType:<select name="idType">
            <option></option>
            <option value="panCard">PanCard</option>
            <option value="voterId">voterId</option>
            <option value="Aadhar">Aadhar</option>
            <option value="other">Other</option>
         </select>        
IdNum:<input type="text" name="idNum" value="${ven.idNum }" />
Note:<input type="text" name="venDsc"  value="${ven.venDsc }"/>
<input type="submit" value="Update">
</pre>
	</form>
</center>
</body>
</html>