<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<title>First Web Application</title>
</head>

<body>
	<div class="container">
		<form method="post" action="register">
			<div class="form-group">
				<label for="username">Username</label> <input type="text"
					class="form-control" name="username" id="username"
					aria-describedby="emailHelp" placeholder="Enter username" />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" name="password" id="password"
					placeholder="Enter password">
			</div>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>
			<button type="submit" class="btn btn-primary">Create account</button>
		</form>
	</div>

	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</body>

</html>