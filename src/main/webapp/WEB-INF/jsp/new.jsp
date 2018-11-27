<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>First Web Application</title>
</head>

<body>
	<div class="container">
		<jsp:include page="forms/person.jsp"> 
			<jsp:param name="button" value="Create Person" />
		</jsp:include>
		<a href="/list">Back</a>
	</div>

	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</body>

</html>