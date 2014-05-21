/*jQuery("#longLinkInput").keypress(function () {
	alert("test");
});*/
jQuery(document).ready(function() {
	var lastLongLink = jQuery("#longLinkInput").val();
	
	window.setInterval(function() {
		
		var qrImage = jQuery("#qrImage");
		var recentLinks = jQuery("#recentLinks");
		var longLinkInput = jQuery("#longLinkInput");
		var qrImageWrapper = jQuery("#qrImageWrapper");
		var currentLongLink = longLinkInput.val();
		
		if(lastLongLink == currentLongLink) {
			return;
		}
		
		lastLongLink = currentLongLink;
		jQuery("#result-panel").remove()
		
		if(currentLongLink == "") {
			qrImage.remove();
			qrImageWrapper.removeClass("well").removeClass("result-panel");
			return;
		}
		
		if(currentLongLink == "" && recentLinks.hasClass("col-md-8")) {
			recentLinks.removeClass("col-md-8").addClass("col-md-12");
		} else if(recentLinks.hasClass("col-md-12")) {
			recentLinks.removeClass("col-md-12").addClass("col-md-8");
		}
		
		if(qrImage.length == 0) {
			qrImageWrapper.append("<img id=\"qrImage\" alt=\"Generating...\" width=\"100%\" title=\"QR Image\" src=\"\"/>");
			qrImageWrapper.addClass("well").addClass("result-panel");
		}
		
		jQuery("#qrImage").attr("src", hostName + "/api/QrRender?u=" + currentLongLink + "&width=" + 300 + "&height=" + 300);
		
	}, 1000);
});