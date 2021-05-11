<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My card : ${requestScope.ncard.name}</title>
</head>
<body>

	<h1>This is your ${requestScope.ncard.name} Card!</h1>
	<h2>Family: ${requestScope.ncard.family}</h2>
	<h2>HP: ${requestScope.ncard.hp}</h2>
	<img src=${requestScope.ncard.imgUrl} >

</body>
</html>