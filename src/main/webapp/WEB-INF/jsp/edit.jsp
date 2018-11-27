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
		<form method="post">
			<input type="hidden"
					class="form-control" name="id" id="id" value="${person.id}" />
			<div class="form-group">
				<label for="dni">Dni</label> <input type="text"
					class="form-control" name="dni" id="dni" value="${person.dni}" readonly required/>
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" name="name" id="name" value="${person.name}" required/>
			</div>
			<div class="form-group">
				<label for="lastname">Lastname</label> <input type="text"
					class="form-control" name="lastname" id="lastname" value="${person.lastname}" required/>
			</div>
			<div class="form-group">
				<label for="age">Age</label> <input type="number"
					class="form-control" name="age" id="age" value="${person.age}" required/>
			</div>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${errorMessage}" />
				</div>
			</c:if>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
		<a href="/list">Back</a>
	</div>

	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</body>

</html>