<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<title>First Web Application</title>
	<jsp:include page="components/includes.jsp"/> 
</head>
<body>

	<jsp:include page="components/menu.jsp"/> 
	
	<div class="container">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Dni</th>
					<th scope="col">Name</th>
					<th scope="col">Lastname</th>
					<th scope="col">Age</th>
					<th scope="col">Gender</th>
					<th scope="col">Has car</th>
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
						<td><span class="fas fa-${fn:toLowerCase(person.gender)}"></span></td>
						<td><span
							class="fas fa-${person.hascar ? 'check' : 'times' }"></span></td>
						<td><a href="/edit/${person.dni}"><span
								class="fas fa-edit"></span></a></td>
						<td><a href="/delete/${person.dni}"><span
								class="fas fa-trash-alt"></span></a></td>
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