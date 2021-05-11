<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Cards</title>
</head>
<body>

	<c:forEach items="${sessionScope.lcard}" var="card">
		<h1>This is your ${card.name} Card!</h1>
		<h2>Family: ${card.family}</h2>
		<h2>HP: ${card.hp}</h2>
		<img src=${card.imgUrl} height="80" width="80">
		<hr>
	</c:forEach>
</body>
</html>