<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor</title>
</head>
<body>
<center>
<%@include file="UserMenu.jsp" %>
	<form action="venRegister" method="post">

		<pre>
Id:<input type="text" name="venId" />
Code:<input type="text" name="venCode" />
Name:<input type="text" name="venName" />
Type:<input type="radio" name="venType" value="contract">Contract
         <input type="radio" name="venType" value="parttime">PartTime
          <input type="radio" name="venType" value="fulltime">FullTime
Address:<textarea name="venAdd"></textarea>  
IdType:<select name="idType">
            <option></option>
            <option value="panCard">PanCard</option>
            <option value="voterId">voterId</option>
            <option value="Aadhar">Aadhar</option>
            <option value="other">Other</option>
         </select>        
IdNum:<input type="text" name="idNum" />
Note:<input type="text" name="venDsc" />
<input type="submit" value="Register">
</pre>
	</form>
	${ved}
	</br>
	<a href="viewVendors">viewVendoData</a>
	</center>
</body>
</html>