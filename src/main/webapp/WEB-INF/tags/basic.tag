<!DOCTYPE html>
<%@ tag description="Basic Template" pageEncoding="UTF-8"%>

<%@ attribute name="title"%>
<%@ attribute name="body_area" fragment="true"%>

<html>

	<head>
		<title>${title}</title>
		<jsp:include page="/WEB-INF/components/css-includes.jsp" />
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/components/menu.jsp" />
		<div class="container">
			<jsp:invoke fragment="body_area" />
		</div>
	</body>
	
	<footer>
		<jsp:include page="/WEB-INF/components/js-includes.jsp" />
	</footer>
	
</html>