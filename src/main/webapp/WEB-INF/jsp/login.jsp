<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:basic title="People Management Login">

	<jsp:attribute name="body_area">
	
		<form method="post" action="login" id="login-form">
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
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		<a href="/register">Create an account</a>
	
	</jsp:attribute>

</t:basic>