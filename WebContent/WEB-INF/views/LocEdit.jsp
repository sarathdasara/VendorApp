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
	<form action="updateLoc" method="post">
		<pre>
ID:<input type="text" name="locId" value="${loc.locId}"
				readonly="readonly" />
NAME:<input type="text" name="locName" value="${loc.locName}" />
CODE:<input type="text" name="locCode" value="${loc.locCode}" />

TYPE:
<c:choose>
<c:when test="${'Urban' eq loc.locType}">
<input type="radio" name="locType" value="Urban" checked="checked">Urban
      <input type="radio" name="locType" value="Rural">Rural
      </c:when>
  <c:otherwise>
  <input type="radio" name="locType" value="Urban">Urban
      <input type="radio" name="locType" value="Rural" checked="checked">Rural
  
  </c:otherwise>
  </c:choose>
Description:<textarea name="locDsc">${loc.locDsc}</textarea>
<input type="submit" value="submit" />
</pre>
	</form>
</center>
</body>
</html>