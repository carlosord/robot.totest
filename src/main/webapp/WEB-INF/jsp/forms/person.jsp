<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="post">
	<input type="hidden" class="form-control" name="id" id="id"
		value="${person.id}" />
	<div class="form-group">
		<label for="dni">Dni</label> <input type="text" class="form-control"
			name="dni" id="dni" value="${person.dni}" required />
	</div>
	<div class="form-group">
		<label for="name">Name</label> <input type="text" class="form-control"
			name="name" id="name" value="${person.name}" required />
	</div>
	<div class="form-group">
		<label for="lastname">Lastname</label> <input type="text"
			class="form-control" name="lastname" id="lastname"
			value="${person.lastname}" required />
	</div>
	<div class="form-group">
		<label for="age">Age</label> <input type="number" class="form-control"
			name="age" id="age" value="${person.age}" required />
	</div>
	<div class="form-group">
		<label for="gender">Gender</label>
		<select class="form-control"
			name="gender" id="gender" data-selected="${person.gender}" required>
			<option value="MALE" ${person.gender.equals('MALE') ? 'selected' : ''}>Male</option>
      		<option value="FEMALE" ${person.gender.equals('FEMALE') ? 'selected' : ''}>Female</option>
		</select>
	</div>
	<div class="form-group form-check">
		<input type="checkbox" class="form-check-input" name="hascar" id="hascar" ${person.hascar ? 'checked' : ''}>
		<label class="form-check-label" for="hascar">Has a car</label>
	</div>
	<c:if test="${not empty errorMessage}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${errorMessage}" />
		</div>
	</c:if>
	<button type="submit" class="btn btn-primary"><%=request.getParameter("button")%></button>
</form>