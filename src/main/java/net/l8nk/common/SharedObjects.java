package net.l8nk.common;

public class SharedObjects {
	
	private static SharedObjects instance;
	private Long linkToken;

	private SharedObjects() {
		
	}
	
	public static SharedObjects getInstance() {
		if(SharedObjects.instance == null) {
			SharedObjects.instance = new SharedObjects();
		}
		
		return SharedObjects.instance;
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
			return ++this.linkToken;
		}
	}
}
