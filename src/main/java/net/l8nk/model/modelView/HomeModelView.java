/**
 * 
 */
package net.l8nk.model.modelView;

import net.l8nk.model.Link;

/**
 * @author thuc.le
 *
 */
public class HomeModelView {
	private Link link;
	private String errorMessage;

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}
	
	public boolean isGeneratedLink() {
		if(this.link == null) {
			return false;
		}
		
		String shortLink = this.link.getShortLink();
		if(shortLink == null || shortLink.isEmpty()) {
			return false;
		}
		
		return true;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean isHasError() {
		if(this.errorMessage == null || this.errorMessage.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	
}
