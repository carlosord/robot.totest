$( document ).ready(function() {
	$('.alert').hide();
});

function showConfirm(url) {
	$.confirm({
		title : 'Delete Person!',
		content : 'Do you really want to delete that person?!',
		theme : 'supervan',
		buttons : {
			Confirm : function() {
				window.location.href = url;
			},
			Cancel : function() {
			}
		}
	});
}

function showDate() {
	$("#showed-input-date").text($("#input-date").val());
	$('.alert').show();
}