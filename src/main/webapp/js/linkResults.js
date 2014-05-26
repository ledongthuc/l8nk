/**
 * 
 */
jQuery(".oldRow").click(function() {
	var detail = jQuery(this).data("url-detail");
	window.location.href = detail;
});