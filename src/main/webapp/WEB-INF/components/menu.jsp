<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/">Home</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="/list">List
					People</a></li>
			<li class="nav-item"><a class="nav-link" href="/video">Video in iframe</a></li>
			<li class="nav-item"><a class="nav-link" href="/delay">Delay page</a></li>
			<jsp:include page="submenu.jsp" />
			<li class="nav-item"><a class="nav-link" href="/info">More Info</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" method="post" action="logout">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
		</form>
	</div>
</nav>