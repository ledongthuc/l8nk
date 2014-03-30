package net.l8nk.common;

import java.math.BigInteger;
import java.util.HashMap;

import com.sun.swing.internal.plaf.synth.resources.synth;

import net.l8nk.model.Link;

public class SharedObject {
	
	private static SharedObject instance;
	private BigInteger linkToken = BigInteger.ZERO;
	private boolean isMoveCachedLinksToDatabase;
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

	synchronized public boolean isMoveCachedLinksToDatabase() {
		return isMoveCachedLinksToDatabase;
	}

	synchronized public void MoveCachedLinksToDatabase(boolean isMoveCachedLinksToDatabase) {
		this.isMoveCachedLinksToDatabase = isMoveCachedLinksToDatabase;
	}
}
