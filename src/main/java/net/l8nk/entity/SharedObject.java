package net.l8nk.entity;

import java.util.HashMap;

public class SharedObject {
	
	private static SharedObject instance;
	private Long linkToken = new Long(0);
	public static HashMap<String, Link> CachedLinks = new HashMap<String, Link>();
	
	private SharedObject() {
		
	}
	
	public static SharedObject getInstance() {
		if(SharedObject.instance == null) {
			SharedObject.instance = new SharedObject();
		}
		
		return SharedObject.instance;
	}
	
	/**
	 * @return the currentId
	 */
	public long getLinkToken() {
		return linkToken;
	}

	/**
	 * @param linkToken the currentId to set
	 */
	public void setLinkToken(long linkToken) {
		synchronized (this.linkToken) {
			this.linkToken = linkToken;
		}		
	}
	
	/**
	 * @return the currentId after increase it 
	 */
	public long increaseLinkToken() {
		synchronized (this.linkToken) {
			this.linkToken = this.linkToken + 1;
			return this.linkToken;
		}
	}

}
