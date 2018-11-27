<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<title>First Web Application</title>
</head>

<body>

	<div class="container">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Dni</th>
					<th scope="col">Name</th>
					<th scope="col">Lastname</th>
					<th scope="col">Age</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${people}">
					<tr>
						<th scope="row">${person.dni}</th>
						<td>${person.name}</td>
						<td>${person.lastname}</td>
						<td>${person.age}</td>
						<td><a href="/edit/${person.dni}"><span class="fas fa-edit"></span></a></td>
						<td><a href="/delete/${person.dni}"><span class="fas fa-trash-alt"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/new">Create a person</a>
	</div>

	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</body>

</html>