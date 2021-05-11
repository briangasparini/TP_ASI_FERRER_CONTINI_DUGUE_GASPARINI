<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poc JSP PAGE</title>
</head>
<body>
	<h1>SUPER HEROS JSP PAGE CREATOR</h1>
	<h3>this page is generated from the server using the EL expression
		this is ${54 < 21 || 10>1}</h3>
	<ul>
		<li> name parameter value: ${param.name}</li>
		<li> name parameter value: ${param.surname}</li>
	</ul>
</body>
</html>