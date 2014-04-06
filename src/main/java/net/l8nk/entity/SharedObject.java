package net.l8nk.entity;

import java.math.BigInteger;
import java.util.HashMap;

public class SharedObject {
	
	private static SharedObject instance;
	private BigInteger linkToken = BigInteger.ZERO;
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
	public BigInteger getLinkToken() {
		return linkToken;
	}

	/**
	 * @param linkToken the currentId to set
	 */
	public void setLinkToken(BigInteger linkToken) {
		synchronized (this.linkToken) {
			this.linkToken = linkToken;
		}		
	}
	
	/**
	 * @return the currentId after increase it 
	 */
	public BigInteger increaseLinkToken() {
		synchronized (this.linkToken) {
			this.linkToken = this.linkToken.add(new BigInteger("1"));
			return this.linkToken;
		}
	}

}
