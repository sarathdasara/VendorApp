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
	<form action="insertLoc" method="post">

		<pre>
ID:<input type="text" name="locId" />
NAME:<input type="text" name="locName" />
CODE:<input type="text" name="locCode" />
TYPE:<input type="radio" name="locType" value="Urban">Urban
      <input type="radio" name="locType" value="Rural">Rural
Description:<textarea name="locDsc"></textarea>
<input type="submit" value="submit" />
</pre>
	</form>
	${msg}
	<br />
	<a href="viewAll">viewAllLocs</a>
	</center>
</body>
</html>