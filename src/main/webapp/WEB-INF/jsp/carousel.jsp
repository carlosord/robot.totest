<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:basic title="Delay Page">

	<jsp:attribute name="body_area">
	
		<div id="carouselExampleControls" class="carousel slide"
			data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100"
						src="https://i.stack.imgur.com/kBStb.png" alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100"
						src="https://blog.codecentric.de/files/2017/09/robot-framework-screenshot-3.png"
						alt="Second slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100"
						src="https://www.xoriant.com/blog/wp-content/uploads/2015/07/RobotFramework-2.png" alt="Third slide">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleControls"
				role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleControls"
				role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		
	</jsp:attribute>

</t:basic>