<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:basic title="Delay Page">

	<jsp:attribute name="body_area">
	
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#modal">
		  Launch a modal window to enter a date
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="modal" tabindex="-1" role="dialog"
			aria-labelledby="modalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="modalLabel">Modal Window</h5>
		        <button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="form-group">
					<label for="input-date">Enter a date</label> <input type="date"
								class="form-control" name="input-date" id="input-date"
								placeholder="Enter a date" />
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		    </div>
		  </div>
		</div>
		
	</jsp:attribute>

</t:basic>