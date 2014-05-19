/*jQuery("#longLinkInput").keypress(function () {
	alert("test");
});*/
jQuery(document).ready(function() {
	var lastLongLink = jQuery("#longLinkInput").val();
	
	window.setInterval(function() {
		
		var resultPanel = jQuery("#resultPanel");
		var recentLinks = jQuery("#recentLinks");
		var longLinkInput = jQuery("#longLinkInput");
		var qrImageWrapper = jQuery("#qrImageWrapper");
		var currentLongLink = longLinkInput.val();
		
		if(lastLongLink == currentLongLink) {
			return;
		}
		
		lastLongLink = currentLongLink;
		
		if(currentLongLink == "" && recentLinks.hasClass("col-md-8")) {
			recentLinks.removeClass("col-md-8").addClass("col-md-12");
		} else if(recentLinks.hasClass("col-md-12")) {
			recentLinks.removeClass("col-md-12").addClass("col-md-8");
		}
		
		if(qrImageWrapper.length == 0) {
			resultPanel.append("<div class=\"col-md-4\" id=\"qrImageWrapper\"><img id=\"qrImage\" width=\"100%\" title=\"QR Image\" src=\"\"/></div>");
		}
		
		jQuery("#qrImage").attr("src", hostName + "/api/QrRender?u=" + currentLongLink + "&width=" + 300 + "&height=" + 300);
		
	}, 1000);
});