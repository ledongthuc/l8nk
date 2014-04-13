/**
 * 
 */
package net.l8nk.viewmodel;

import java.util.ArrayList;

import net.l8nk.entity.Link;

/**
 * @author thuc.le
 *
 */
public class HomeModel {
	private Link link;
	private ArrayList<Link> recentLinks;
	private ArrayList<Link> usersLinks;
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

	/**
	 * @return the usersLinks
	 */
	public ArrayList<Link> getUsersLinks() {
		return usersLinks;
	}

	/**
	 * @param usersLinks the usersLinks to set
	 */
	public void setUsersLinks(ArrayList<Link> usersLinks) {
		this.usersLinks = usersLinks;
	}

	public ArrayList<Link> getRecentLinks() {
		if(recentLinks == null) {
			recentLinks = new ArrayList<>();
		}
		return recentLinks;
	}

	public void setRecentLinks(ArrayList<Link> recentLinks) {
		this.recentLinks = recentLinks;
	}
	
	
}
