<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:basic title="People Management New">

	<jsp:attribute name="body_area">
	
		<jsp:include page="forms/person.jsp"> 
			<jsp:param name="button" value="Create Person" />
		</jsp:include>
	
	</jsp:attribute>

</t:basic>