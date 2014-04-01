/**
 * 
 */
package net.l8nk.data.entity;

import java.math.BigInteger;
import java.util.ArrayList;

import net.l8nk.common.L8nkEncoding;
import net.l8nk.common.SharedObject;
import net.l8nk.common.Utility;

/**
 * @author thuc.le
 *
 */
public class Link {
	private String encodedPart;
	private String longLink;
	
	public Link(String longLink) {
		this.longLink = longLink;
		this.generateShortLink();
	}
	
	public Link() {
		
	}
	
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
	
	public void generateShortLink() {
		if((this.encodedPart == null || this.encodedPart.isEmpty()) && 
		   (this.longLink != null && !this.longLink.isEmpty())) {
			
			synchronized (SharedObject.CachedLinks) {
				Link link = (Link)SharedObject.CachedLinks.get(this.getLongLink());
				
				if(link == null) {
					SharedObject sharedObject = SharedObject.getInstance();
					BigInteger linkToken = sharedObject.increaseLinkToken();
					this.encodedPart = L8nkEncoding.encode(linkToken);
					
					SharedObject.CachedLinks.put(getLongLink(), this);
				} else {
					this.encodedPart = link.encodedPart;
				}
			}
		}
	}
	
}
