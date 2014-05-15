/**
 * 
 */
package net.l8nk.entity;

import java.sql.Date;

import net.l8nk.common.Utility;

/**
 * @author thuc.le
 *
 */
public class Link {
	
	private long linkId;
	private String encodedPart;
	private String longLink;
	private int domainId;
	private int clicks;
	private Date createdDate;
	private Date lastAccessed;
	private String description;
	private String hashLink;
	
	
	public String getShortLink() {
		return Utility.buildShortUrl(encodedPart);
	}
	
	public void setEncodedPart(String encodedPart) {
		this.encodedPart = encodedPart;
	}
	
	public String getLongLink() {
		return Utility.formatUrl(longLink);
	}
	
	public void setLongLink(String longLink) {
		this.longLink = longLink;
	}

	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}

	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHashLink() {
		return hashLink;
	}

	public void setHashLink(String hashLink) {
		this.hashLink = hashLink;
	}
	
}
