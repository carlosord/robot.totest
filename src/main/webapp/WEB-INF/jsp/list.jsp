<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:basic title="People List">

	<jsp:attribute name="body_area">
	
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
	
	</jsp:attribute>

</t:basic>